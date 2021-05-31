package cn.gyw.community.rest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.gyw.community.rest.comment.entity.Comment;
import cn.gyw.community.rest.dto.CommentDto;
import cn.gyw.platform.common.web.base.mgb.BaseDao;

@Mapper
public interface CommentMapper extends BaseDao<Comment> {

    List<CommentDto> queryByPostId(String postId);
}
