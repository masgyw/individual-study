package cn.gyw.community.rest.post.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.gyw.community.rest.dto.PostDto;
import cn.gyw.community.rest.post.entity.Post;
import cn.gyw.community.rest.post.service.IPostService;
import cn.gyw.community.rest.rpc.SystemServiceClient;
import cn.gyw.components.web.base.mybatisplus.BaseController;

@RestController
@RequestMapping("/post")
public class PostController extends BaseController<Post, PostDto> {

    @Resource(name = "postService")
    private IPostService postService;
    
    @Autowired
    private SystemServiceClient systemServiceClient;

    /*@GetMapping("/user/{userId}")
    public CommonResponse<UserDto> testQueryUser(@PathVariable("userId") String userId) {
        System.out.println(">> " + userService);
        CommonResponse<UserDto> result = userService.findById(userId);
        System.out.println("<< " + result);
        return result;
    }
    
    @GetMapping("/qq")
    @NeedSetValue
    public PostDto getPostDesc() {
    	PostDto dto = new PostDto();
    	dto.setUid(10000);
    	dto.setCreatedById(1);
    	dto.setPostTitle("unknow");
    	
    	return dto;
    }*/
    
    @GetMapping("/checkUser")
    public String checkUser() {
        System.out.println(systemServiceClient.checkUser("111"));
        return "i am zouren ";
    }
    
    @Override
    protected Map<String, String> setOrderColumns() {
    	Map<String, String> orderMap = new HashMap<>();
    	orderMap.put("desc", Post.CREATED_TIME);
    	return orderMap;
    }
}
