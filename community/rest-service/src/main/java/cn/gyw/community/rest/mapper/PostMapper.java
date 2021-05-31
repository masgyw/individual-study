package cn.gyw.community.rest.mapper;

import org.apache.ibatis.annotations.Mapper;

import cn.gyw.community.rest.post.entity.Post;
import cn.gyw.platform.common.web.base.mgb.BaseDao;

@Mapper
public interface PostMapper extends BaseDao<Post> {

}
