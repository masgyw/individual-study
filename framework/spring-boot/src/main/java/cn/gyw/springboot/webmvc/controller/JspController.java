package cn.gyw.springboot.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author
 * @desc
 * @createdTime 2022/10/8
 */
@Controller
@RequestMapping("/jsp")
public class JspController {

    @RequestMapping("/hello")
    private String hello(Model model) {
        model.addAttribute("name", "zhang san");
        return "index";
    }

}
