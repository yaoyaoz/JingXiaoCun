package com.jingxiaocun.web.controller.base;

import com.jingxiaocun.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ClassName: AbstractController
 * Description:
 * Date: 2020年07月23日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class AbstractController {

    @Autowired
    protected GoodsService service;

}