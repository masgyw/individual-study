package cn.gyw.community.rest.reply.service;

import cn.gyw.community.rest.mapper.ReplyMapper;
import cn.gyw.community.rest.reply.entity.Reply;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service(value = "replyService")
public class ReplyService extends ServiceImpl<ReplyMapper, Reply> implements IReplyService {

}
