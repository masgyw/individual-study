package cn.gyw.community.rest.post.service;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.gyw.community.rest.mapper.PostMapper;
import cn.gyw.community.rest.post.entity.Post;

@Service
public class PostService extends ServiceImpl<PostMapper, Post> implements IPostService {

}
