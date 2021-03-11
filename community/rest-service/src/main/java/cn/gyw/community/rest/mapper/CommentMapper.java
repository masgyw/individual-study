package cn.gyw.community.rest.mapper;

import cn.gyw.community.rest.comment.entity.Comment;
import cn.gyw.community.rest.dto.CommentDto;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface CommentMapper extends BaseMapper<Comment> {

    List<CommentDto> queryByPostId(String postId);
}
