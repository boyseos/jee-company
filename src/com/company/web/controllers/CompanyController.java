package com.company.web.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.web.commands.Receiver;
import com.company.web.commands.Sender;
import com.company.web.enums.Action;

@WebServlet("/company.do")
public class CompanyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("컴패니컨");
		Receiver.init(request);
		switch (Action.valueOf(request.getParameter("action").toUpperCase())) {
		case CREATE: 
				request.setAttribute("page", "login"); break;
		case LOGIN: 
				request.setAttribute("page", "main"); break;
		default:
			break;
		}
		System.out.println(String.format("request 값 출력:%s %s %s %s ",
	            request.getParameter("empNo"),
	            request.getParameter("eName"),
	            request.getParameter("dName"),
	            request.getParameter("page")) );
		Sender.forward(request, response);
	}
}
