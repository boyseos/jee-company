package com.company.web.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.web.commands.Receiver;
import com.company.web.commands.Sender;

@WebServlet("/facade.do")
public class FacadeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	enum Resource {
		CTX,CSS,JS,IMG
	}
	protected void service(HttpServletRequest request, HttpServletResponse
			response) throws ServletException, IOException {
		for(Resource r : Resource.values()) {
			request.getSession().setAttribute(r.toString().toLowerCase(),
					r.toString().toLowerCase().equals("ctx")
					?request.getContextPath()
					:request.getContextPath()+"/resources/"+r.toString().toLowerCase());
		}
		Receiver.init(request);
		Sender.forward(request, response);			
	}
}