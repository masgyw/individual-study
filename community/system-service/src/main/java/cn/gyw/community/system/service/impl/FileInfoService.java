package cn.gyw.community.system.service.impl;

import cn.gyw.community.system.mapper.FileInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.gyw.community.system.entity.FileInfo;
import cn.gyw.community.system.service.IFileInfoService;
import cn.gyw.platform.common.web.base.mgb.BaseService;

@Service
public class FileInfoService extends BaseService<FileInfo> implements IFileInfoService {
    @Autowired
    private FileInfoMapper fileInfoMapper;

}
