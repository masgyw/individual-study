package cn.gyw.community.content.service;

import cn.gyw.community.content.entity.PrefrenceArea;
import cn.gyw.community.content.dao.PrefrenceAreaMapper;
import cn.gyw.platform.common.web.base.mgb.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrefrenceAreaService extends BaseService<PrefrenceArea> {

	@Autowired
    private PrefrenceAreaMapper prefrenceAreaMapper;
}
