/**
 * 库存查看
 */
package com.jingxiaocun.web.controller;

import com.jingxiaocun.domain.GoodsStoreNum;
import com.jingxiaocun.service.GoodsService;
import com.jingxiaocun.service.impl.GoodsServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//@WebServlet("/QueryStoreNumServlet")
@RestController
public class QueryStoreNumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	GoodsService service = new GoodsServiceImpl();
	
	protected Logger logger = Logger.getLogger(getClass());

	@RequestMapping("/QueryStoreNumServlet")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String store_name = request.getParameter("store_name");
		String goods_name = request.getParameter("goods_name");
		
		request.setAttribute("store_name", store_name);
		request.setAttribute("goods_name", goods_name);
		
		GoodsStoreNum goodsStoreNum = new GoodsStoreNum();
		
		goodsStoreNum.setStore_name("store_name");
		goodsStoreNum.setGoods_name(goods_name);

		try {
			
			List<GoodsStoreNum> list = service.queryStoreNum(goodsStoreNum);
			request.setAttribute("list", list);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (Exception e) {
			logger.info("查看库存记录，异常！" + e);
			request.setAttribute("message", "查询库存失败！");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
