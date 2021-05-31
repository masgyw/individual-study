package cn.gyw.community.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.gyw.community.system.dto.FileInfoDto;
import cn.gyw.community.system.entity.FileInfo;
import cn.gyw.community.system.service.IFileInfoService;
import cn.gyw.platform.common.web.base.mgb.BaseController;

@RestController
@RequestMapping("/fileInfo")
public class FileInfoController extends BaseController<FileInfo, FileInfoDto> {

	@Autowired
	private IFileInfoService fileInfoService;
}
