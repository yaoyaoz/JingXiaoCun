package com.jingxiaocun.web.controller;

import com.jingxiaocun.domain.Goods;
import com.jingxiaocun.utils.WebUtils;
import com.jingxiaocun.web.controller.base.AbstractController;
import com.jingxiaocun.web.formBean.InOrOutStoreFormBean;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;

@Controller
public class InOrOutStoreController extends AbstractController {

	protected Logger logger = Logger.getLogger(getClass());

	@RequestMapping("/InOrOutStoreServlet")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		InOrOutStoreFormBean formBean = WebUtils.request2Bean(request, InOrOutStoreFormBean.class);

		if (!formBean.validate()) {
			request.setAttribute("formBean", formBean);
			request.getRequestDispatcher("/inOrOutStoreServlet.jsp").forward(request, response);
			return;
		}

		try {
			Goods goods = new Goods();
			goods.setId(WebUtils.makeId());
			goods.setIn_or_out_type(formBean.getIn_or_out_type());
			goods.setStore_name(formBean.getStore_name());
			goods.setGoods_name(formBean.getGoods_name());
			goods.setGoods_num(Integer.parseInt(formBean.getGoods_num()));
			goods.setGoods_price(Double.parseDouble(formBean.getGoods_price()));
			goods.setIn_or_out_date(dateFormat.parse(formBean.getIn_or_out_date()));

			service.inOrOutStore(goods);
			request.setAttribute("message", "恭喜您，保存成功！");
			request.getRequestDispatcher("/inOrOutStoreServlet.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("message", "入/出库操作失败！" + e);
			logger.error(e.getMessage(), e);
			request.getRequestDispatcher("/inOrOutStoreServlet.jsp").forward(request, response);
		}
	}

}
