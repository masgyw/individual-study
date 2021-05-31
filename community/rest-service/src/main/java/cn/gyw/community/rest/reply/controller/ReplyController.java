package cn.gyw.community.rest.reply.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.gyw.community.rest.dto.ReplyDto;
import cn.gyw.community.rest.reply.entity.Reply;
import cn.gyw.community.rest.reply.service.IReplyService;
import cn.gyw.platform.common.web.base.mgb.BaseController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author guanyw
 * @since 2020-08-11
 */
@RestController
@RequestMapping("/reply")
public class ReplyController extends BaseController<Reply, ReplyDto> {

    @Autowired
    private IReplyService replyService;

}
