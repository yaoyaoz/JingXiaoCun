package com.jingxiaocun.web.controller.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName: IndexController
 * Description:
 * Date: 2020年07月23日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

}