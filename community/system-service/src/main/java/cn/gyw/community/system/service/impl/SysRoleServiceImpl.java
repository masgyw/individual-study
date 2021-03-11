package cn.gyw.community.system.service.impl;

import cn.gyw.community.system.entity.SysRole;
import cn.gyw.community.system.mapper.SysRoleMapper;
import cn.gyw.community.system.service.ISysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service(value = "sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

}
