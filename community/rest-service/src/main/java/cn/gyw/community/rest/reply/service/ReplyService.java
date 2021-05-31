package cn.gyw.community.rest.reply.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.gyw.community.rest.mapper.ReplyMapper;
import cn.gyw.community.rest.reply.entity.Reply;
import cn.gyw.platform.common.web.base.mgb.BaseService;

@Service(value = "replyService")
public class ReplyService extends BaseService<Reply> implements IReplyService {

	@Autowired
	private ReplyMapper replyMapper;
}
