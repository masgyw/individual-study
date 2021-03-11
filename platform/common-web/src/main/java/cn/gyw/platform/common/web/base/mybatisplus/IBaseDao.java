package cn.gyw.platform.common.web.base.mybatisplus;

import cn.gyw.platform.common.web.log.entity.ApiLog;

/**
 * 标准 Dao
 */
public interface IBaseDao {

   int selectCount();
   
   boolean insert(String table, ApiLog apiLog);
   
   boolean update(String table, ApiLog apiLog);
}
