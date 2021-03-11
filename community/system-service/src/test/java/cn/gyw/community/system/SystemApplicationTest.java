package cn.gyw.community.system;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.gyw.community.system.dto.UserDto;
import cn.gyw.community.system.mapper.SysUserMapper;
import cn.gyw.components.web.client.IdGenerationService;
import cn.gyw.components.web.model.QueryExample;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SystemApiApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SystemApplicationTest {

    @Autowired
    private SysUserMapper sysUserMapper;
    
    @Autowired
    private IdGenerationService idGenerationService;

    /**
     * 自定义sql
     */
    @Test
    public void queryUserVO() {
        QueryExample example = new QueryExample();
        QueryExample.Criteria criteria = example.createCritria();
        criteria.eq("uid", 1001);

        UserDto sysUserVO = sysUserMapper.findWithRole(example);
        System.out.println(">>" + sysUserVO);
    }
    
    /**
     * 测试 双Buffer ID 生成器代码
     */
    @Test
    public void getId() throws Exception {
        for (int i = 0 ; i < 12 ; i ++) {
            System.out.println(">>>> " + idGenerationService.getId());
        }
    }
}
