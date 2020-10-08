package com.huyy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huyy.pojo.Log;
import com.huyy.service.LogService;
import com.huyy.service.impl.LogServiceImpl;

@WebServlet(urlPatterns = "/insert")
public class InsertServlet extends HttpServlet {

	private LogService logService = new LogServiceImpl();

	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		Log log = new Log();
		log.setAccIn(req.getParameter("accin"));
		log.setAccOut(req.getParameter("accout"));
		log.setMoney(Double.parseDouble(req.getParameter("money")));
		int index = logService.insertLog(log);
		if (index > 0) {
			resp.sendRedirect("success.jsp");
		} else {
			resp.sendRedirect("fail.jsp");
		}
	}

}
