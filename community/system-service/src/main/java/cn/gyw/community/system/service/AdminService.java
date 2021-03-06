package cn.gyw.community.system.service;

import cn.gyw.community.security.util.JwtTokenUtil;
import cn.gyw.community.system.bo.AdminUserDetails;
import cn.gyw.community.system.dao.AdminLoginLogMapper;
import cn.gyw.community.system.dao.AdminRoleRelationMapper;
import cn.gyw.community.system.dto.AdminDto;
import cn.gyw.community.system.entity.*;
import cn.gyw.community.system.dao.AdminMapper;
import cn.gyw.community.system.enums.SystemRespEnum;
import cn.gyw.platform.common.web.base.mgb.BaseService;
import cn.gyw.platform.common.web.utils.RequestUtil;
import cn.hutool.core.collection.CollUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AdminService extends BaseService<Admin> {

    private static final Logger log = LoggerFactory.getLogger(AdminService.class);

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private AdminLoginLogMapper adminLoginLogMapper;
    @Autowired
    private AdminRoleRelationMapper adminRoleRelationMapper;

    public Admin getAdminByUsername(String username) {
//        Admin admin = adminCacheService.getAdmin(username);
        Admin admin = null;
        if(admin!=null) return  admin;
        Example example = new Example(Admin.class);
        example.createCriteria().andEqualTo(Admin.KEY_USERNAME, username);
        List<Admin> adminList = adminMapper.selectByExample(example);
        if (adminList != null && adminList.size() > 0) {
            admin = adminList.get(0);
//            adminCacheService.setAdmin(admin);
            return admin;
        }
        return null;
    }

    public Admin register(AdminDto adminDto) {
        Admin umsAdmin = new Admin();
        BeanUtils.copyProperties(adminDto, umsAdmin);
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setStatus(1);
        //???????????????????????????????????????
        Example example = new Example(Admin.class);
        example.createCriteria().andEqualTo(Admin.KEY_USERNAME, umsAdmin.getUsername());
        List<Admin> umsAdminList = adminMapper.selectByExample(example);
        if (umsAdminList.size() > 0) {
            return null;
        }
        //???????????????????????????
        String encodePassword = passwordEncoder.encode(umsAdmin.getPassword());
        umsAdmin.setPassword(encodePassword);
        adminMapper.insert(umsAdmin);
        return umsAdmin;
    }

    public String login(String username, String password) {
        String token = null;
        //????????????????????????????????????
        try {
            UserDetails userDetails = loadUserByUsername(username);
            SystemRespEnum.PASSWORD_ERROR.assertTrue(passwordEncoder.matches(password, userDetails.getPassword()));
            SystemRespEnum.USER_DISABLE.assertTrue(userDetails.isEnabled());
            UsernamePasswordAuthenticationToken authentication
                    = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
//            updateLoginTimeByUsername(username);
            insertLoginLog(username);
        } catch (AuthenticationException e) {
            log.warn("????????????:{}", e.getMessage());
        }
        return token;
    }

    /**
     * ??????????????????
     * @param username ?????????
     */
    private void insertLoginLog(String username) {
        Admin admin = getAdminByUsername(username);
        if(admin==null) return;
        AdminLoginLog loginLog = new AdminLoginLog();
        loginLog.setAdminId(admin.getId());
        loginLog.setCreateTime(new Date());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        loginLog.setIp(RequestUtil.getRequestIp(request));
        adminLoginLogMapper.insert(loginLog);
    }

    public List<Resource> getResourceList(Long adminId) {
//        List<Resource> resourceList = adminCacheService.getResourceList(adminId);
        List<Resource> resourceList = new ArrayList<>();
        if(CollUtil.isNotEmpty(resourceList)){
            return  resourceList;
        }
        resourceList = adminRoleRelationMapper.getResourceList(adminId);
        if(CollUtil.isNotEmpty(resourceList)){
            // ??????????????????
//            adminCacheService.setResourceList(adminId,resourceList);
        }
        return resourceList;
    }

    public List<Role> getRoleList(Long adminId) {
        return adminRoleRelationMapper.getRoleList(adminId);
    }

    public UserDetails loadUserByUsername(String username){
        //??????????????????
        Admin admin = getAdminByUsername(username);
        if (admin != null) {
            List<Resource> resourceList = getResourceList(admin.getId());
            return new AdminUserDetails(admin,resourceList);
        }
        throw new UsernameNotFoundException("????????????????????????");
    }

    public int updateRole(Long id, List<Long> roleIds) {
        int count = roleIds == null ? 0 : roleIds.size();
        //????????????????????????
        Example example = new Example(AdminRoleRelation.class);
        example.createCriteria().andEqualTo(AdminRoleRelation.KEY_ID, id);
        adminRoleRelationMapper.deleteByExample(example);
        //???????????????
        if (!CollectionUtils.isEmpty(roleIds)) {
            List<AdminRoleRelation> list = new ArrayList<>();
            for (Long roleId : roleIds) {
                AdminRoleRelation roleRelation = new AdminRoleRelation();
                roleRelation.setAdminId(id);
                roleRelation.setRoleId(roleId);
                list.add(roleRelation);
            }
            adminRoleRelationMapper.insertList(list);
        }
        // adminCacheService.delResourceList(adminId);
        return count;
    }
}
