package cn.gyw.community.rest.comment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.gyw.community.rest.comment.entity.Comment;
import cn.gyw.community.rest.comment.service.ICommentService;
import cn.gyw.community.rest.dto.CommentDto;
import cn.gyw.components.web.base.mybatisplus.BaseController;

@RestController
@RequestMapping("/comment")
public class CommentController extends BaseController<Comment, CommentDto> {

    @Autowired
    private ICommentService commentService;

    @GetMapping("/{postId}")
    public List<CommentDto> queryCommentsByPostId(@PathVariable("postId") String postId) {
        return commentService.findByPostId(postId);
    }
}
