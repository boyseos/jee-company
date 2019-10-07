package com.company.web.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sender {
	public static void forward(HttpServletRequest request, 
			HttpServletResponse response) {
		System.out.println("센더");
		try {
			System.out.println(String.format("sender 값 출력:%s %s %s %s ",
		            request.getParameter("empNo"),
		            request.getParameter("eName"),
		            request.getParameter("dName"),
		            request.getParameter("page")) );
			request.getRequestDispatcher(Receiver.cmd.getView())
			.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void redirect(HttpServletRequest request,
			HttpServletResponse response, String url) {
		try {
			response.sendRedirect(request.getContextPath()+url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
