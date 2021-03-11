package cn.gyw.community.rest.comment.service;

import cn.gyw.community.rest.comment.entity.Comment;
import cn.gyw.community.rest.dto.CommentDto;
import cn.gyw.community.rest.mapper.CommentMapper;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "commentService")
public class CommentService extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

    @Override
    public List<CommentDto> findByPostId(String postId) {
        return baseMapper.queryByPostId(postId);
    }
}
