package cn.gyw.community.rest.comment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.gyw.community.rest.comment.entity.Comment;
import cn.gyw.community.rest.dto.CommentDto;
import cn.gyw.community.rest.mapper.CommentMapper;
import cn.gyw.platform.common.web.base.mgb.BaseService;
import tk.mybatis.mapper.entity.Example;

@Service(value = "commentService")
public class CommentService extends BaseService<Comment> implements ICommentService {
	
	@Autowired
	private CommentMapper commentMapper;
	
    @Override
    public List<CommentDto> findByPostId(String postId) {
    	Example example = new Example(Comment.class);
        List<Comment> datas = this.baseDao.selectByExample(example);
        List<CommentDto> resultList = new ArrayList<>(datas.size());
        BeanUtils.copyProperties(datas, resultList);
        return resultList;
    }
}
