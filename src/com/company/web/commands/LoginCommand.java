package com.company.web.commands;

import javax.servlet.http.HttpServletRequest;

import com.company.web.domains.CompanyBean;
import com.company.web.serviceimpls.CompanyServiceImpl;

public class LoginCommand extends Command{
	public LoginCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}
	@Override
	public void execute() {
		CompanyBean param = new CompanyBean();
		System.out.println(String.format("로그인커맨드 값 출력:%s %s %s %s ",
	            request.getParameter("empNo"),
	            request.getParameter("eName"),
	            request.getParameter("dName"),
	            request.getParameter("page")) );
		param.setEmpno(request.getParameter("empNo"));
		param.setEname(request.getParameter("eName"));
		param.setDname(request.getParameter("dName"));
		if(CompanyServiceImpl.getInstance().login(param)!=null) {
			setPage(request.getParameter("page"));
			request.setAttribute("user", CompanyServiceImpl.getInstance().login(param));
			request.setAttribute("company", CompanyServiceImpl.getInstance().search(param));
		} else {
			setPage("main");
		}System.out.println("123"+CompanyServiceImpl.getInstance().login(param));
		
		super.execute();
	}
}
