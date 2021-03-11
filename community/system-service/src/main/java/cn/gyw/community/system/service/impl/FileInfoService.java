package cn.gyw.community.system.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.gyw.community.system.entity.FileInfo;
import cn.gyw.community.system.mapper.FileInfoMapper;
import cn.gyw.community.system.service.IFileInfoService;

@Service
public class FileInfoService extends ServiceImpl<FileInfoMapper, FileInfo> implements IFileInfoService {

}
