package cn.gyw.community.rest.post.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.gyw.community.rest.mapper.PostMapper;
import cn.gyw.community.rest.post.entity.Post;
import cn.gyw.platform.common.web.base.mgb.BaseService;

@Service
public class PostService extends BaseService<Post> implements IPostService {

	@Autowired
	private PostMapper postMapper;
}
