package cn.gyw.community.content.service;

import cn.gyw.community.content.entity.Subject;
import cn.gyw.community.content.dao.SubjectMapper;
import cn.gyw.platform.common.web.base.mgb.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService extends BaseService<Subject> {

	@Autowired
    private SubjectMapper subjectMapper;
}
