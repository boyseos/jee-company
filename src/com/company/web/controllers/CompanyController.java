package com.company.web.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.web.commands.Receiver;
import com.company.web.commands.Sender;

@WebServlet("/company.do")
public class CompanyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, 
		HttpServletResponse response) throws ServletException, IOException {
		Receiver.init(request);
		Sender.forward(request, response);
	}
}
