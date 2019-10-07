package com.company.web.commands;

import javax.servlet.http.HttpServletRequest;

import com.company.web.domains.CompanyBean;
import com.company.web.serviceimpls.CompanyServiceImpl;

public class CreateCommand extends Command {
	public CreateCommand(HttpServletRequest request) {
		System.out.println("생성커맨드");
		super.setRequest(request);
		setDomain("facade");
		setAction(request.getParameter("action"));
		this.execute();
	}
	@Override
	public void execute() {
		CompanyBean param = new CompanyBean();
		param.setEmpno(request.getParameter("empNo"));
		param.setEname(request.getParameter("eName"));
		param.setJob(request.getParameter("job"));
		param.setMgr(request.getParameter("mgr"));
		param.setHireDate(request.getParameter("hireDate"));
		param.setSal(request.getParameter("sal"));
		param.setComm(request.getParameter("comm"));
		param.setDeptno(request.getParameter("deptNo"));
		
		if (CompanyServiceImpl.getInstance().join(param)) {
			setPage(request.getParameter("page"));
			
		}else {
			setPage(request.getParameter("page"));
		}
		request.setAttribute("param", CompanyServiceImpl
				.getInstance().join(param));
		super.execute();
	}
}
