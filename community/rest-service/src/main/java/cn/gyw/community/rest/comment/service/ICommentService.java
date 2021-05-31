package cn.gyw.community.rest.comment.service;

import java.util.List;

import cn.gyw.community.rest.comment.entity.Comment;
import cn.gyw.community.rest.dto.CommentDto;
import cn.gyw.platform.common.web.base.mgb.IBaseService;

public interface ICommentService extends IBaseService<Comment> {

    List<CommentDto> findByPostId(String postId);
}
