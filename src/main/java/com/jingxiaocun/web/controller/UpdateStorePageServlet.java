/**
 * 修改页面
 */
package com.jingxiaocun.web.controller;

import com.jingxiaocun.domain.Goods;
import com.jingxiaocun.service.GoodsService;
import com.jingxiaocun.web.controller.base.AbstractController;
import com.jingxiaocun.web.formBean.InOrOutStoreFormBean;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class UpdateStorePageServlet extends AbstractController {

	protected Logger logger = Logger.getLogger(getClass());

	@Autowired
	GoodsService service;

	@RequestMapping("/UpdateStorePageServlet")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String id = request.getParameter("id");
			if (id != null && !id.equals("")) {
				Goods goods = new Goods();
				goods.setId(id);
				List<Goods> list = service.queryGoodsList(goods);
				if (list != null && list.size() == 1) {
					request.setAttribute("formBean", setFormBean(list.get(0)));
					request.getRequestDispatcher("/updateStoreServlet.jsp").forward(request, response);
				}
			}

		} catch (Exception e) {
			request.setAttribute("message", "跳转到修改页面失败！" + e);
			logger.error(e.getMessage(), e);
			request.getRequestDispatcher("/updateStoreServlet.jsp").forward(request, response);
		}
	}

	private InOrOutStoreFormBean setFormBean(Goods goods) {
		InOrOutStoreFormBean formBean = new InOrOutStoreFormBean();
		formBean.setId(goods.getId());
		formBean.setIn_or_out_type(goods.getIn_or_out_type());
		formBean.setStore_name(goods.getStore_name());
		formBean.setGoods_name(goods.getGoods_name());
		formBean.setGoods_num(String.valueOf(goods.getGoods_num()));
		formBean.setGoods_price(String.valueOf(goods.getGoods_price()));
		if (goods.getIn_or_out_date() != null) {
			formBean.setIn_or_out_date(String.valueOf(goods.getIn_or_out_date()));
		}
		return formBean;
	}

}
