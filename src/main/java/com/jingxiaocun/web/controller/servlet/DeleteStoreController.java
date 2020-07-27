package com.jingxiaocun.web.controller.servlet;

import com.jingxiaocun.web.controller.base.AbstractController;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class DeleteStoreController extends AbstractController {

	protected Logger logger = Logger.getLogger(getClass());

	@RequestMapping("/DeleteStoreServlet")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");

		try {
			if (id != null && !id.equals("")) {
				service.deleteStore(id);
				request.setAttribute("message", "恭喜您，删除成功！");
				request.getRequestDispatcher("/QueryStoreNumRecordServlet").forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("message", "删除失败！" + e);
			logger.error(e.getMessage(), e);
			request.getRequestDispatcher("/QueryStoreNumRecordServlet").forward(request, response);
		}

	}

}
