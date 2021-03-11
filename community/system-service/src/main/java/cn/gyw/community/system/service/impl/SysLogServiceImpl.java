package cn.gyw.community.system.service.impl;

import cn.gyw.community.system.entity.SysLog;
import cn.gyw.community.system.mapper.SysLogMapper;
import cn.gyw.community.system.service.ISysLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service(value = "sysLogService")
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements ISysLogService {
}
