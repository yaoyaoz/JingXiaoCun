package com.jingxiaocun.web.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jingxiaocun.domain.Goods;
import com.jingxiaocun.service.GoodsService;
import com.jingxiaocun.service.impl.GoodsServiceImpl;
import com.jingxiaocun.utils.WebUtils;
import com.jingxiaocun.web.formBean.InOrOutStoreFormBean;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Servlet implementation class UpdateStoreServlet
 */
@Controller
public class UpdateStoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	GoodsService service = new GoodsServiceImpl();

	protected Logger logger = Logger.getLogger(getClass());

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@RequestMapping("/UpdateStoreServlet")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		InOrOutStoreFormBean formBean = WebUtils.request2Bean(request, InOrOutStoreFormBean.class);
		request.setAttribute("formBean", formBean);

		if (!formBean.validate()) {
			request.setAttribute("formBean", formBean);
			request.getRequestDispatcher("/updateStoreServlet.jsp").forward(request, response);
			return;
		}

		try {
			Goods goods = new Goods();
			goods.setId(request.getParameter("id"));
			goods.setIn_or_out_type(formBean.getIn_or_out_type());
			goods.setStore_name(formBean.getStore_name());
			goods.setGoods_name(formBean.getGoods_name());
			goods.setGoods_num(Integer.parseInt(formBean.getGoods_num()));
			goods.setGoods_price(Double.parseDouble(formBean.getGoods_price()));
			goods.setIn_or_out_date(dateFormat.parse(formBean.getIn_or_out_date()));

			service.updateStore(goods);
			request.setAttribute("message", "恭喜您，修改成功！");
			request.getRequestDispatcher("/updateStoreServlet.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("message", "修改失败！" + e);
			logger.error(e.getMessage(), e);
			request.getRequestDispatcher("/updateStoreServlet.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
