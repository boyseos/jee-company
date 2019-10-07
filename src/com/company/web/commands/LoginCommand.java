package com.company.web.commands;

import javax.servlet.http.HttpServletRequest;

import com.company.web.domains.CompanyBean;
import com.company.web.serviceimpls.CompanyServiceImpl;

public class LoginCommand extends Command{
	public LoginCommand(HttpServletRequest request) {
		setRequest(request);
		execute();
	}
	@Override
	public void execute() {
		CompanyBean cp = new CompanyBean();
		cp.setEmpno(request.getParameter("empNo"));
		cp.setEname(request.getParameter("eName"));
		cp.setDname(request.getParameter("dName"));
		cp = CompanyServiceImpl.getInstance().loginEmp(cp);
		if(cp !=null) {
			request.setAttribute("user", cp);
			request.setAttribute("company", CompanyServiceImpl.getInstance().findAllDept());
		} else {
			setPage("login");
		}
		super.execute();
	}
}
