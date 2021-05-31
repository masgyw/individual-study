package cn.gyw.community.rest.mapper;

import org.apache.ibatis.annotations.Mapper;

import cn.gyw.community.rest.reply.entity.Reply;
import cn.gyw.platform.common.web.base.mgb.BaseDao;

@Mapper
public interface ReplyMapper extends BaseDao<Reply> {

}
