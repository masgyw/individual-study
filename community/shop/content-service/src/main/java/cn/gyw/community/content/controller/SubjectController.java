package cn.gyw.community.content.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import cn.gyw.community.content.entity.Subject;
import cn.gyw.community.content.dto.SubjectDto;
import cn.gyw.community.content.service.SubjectService;
import cn.gyw.platform.common.web.base.mgb.BaseController;

@RestController
@RequestMapping("/subject")
public class SubjectController extends BaseController<Subject,SubjectDto> {

    @Autowired
    private SubjectService subjectService;
	
}
