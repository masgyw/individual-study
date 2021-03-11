package cn.gyw.community.security.service;

import java.util.List;

import cn.gyw.community.security.domain.CustomData;
import cn.gyw.community.security.domain.ResultDetails;
import cn.gyw.community.security.exception.CustomizeException;

public interface SystemDataService {

	List<CustomData> get();

    CustomData select(String id) throws CustomizeException;

    ResultDetails delete(String id, String authorities) throws CustomizeException;

    CustomData create(CustomData customData);
    
}
