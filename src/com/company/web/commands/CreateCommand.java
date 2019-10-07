package com.company.web.commands;

import javax.servlet.http.HttpServletRequest;

import com.company.web.domains.CompanyBean;
import com.company.web.serviceimpls.CompanyServiceImpl;

public class CreateCommand extends Command {
	public CreateCommand(HttpServletRequest request) {
		setRequest(request);
		execute();
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
		if (CompanyServiceImpl.getInstance().joinEmp(param)) {
			System.out.println("회원가입 성공");
		}else {
			System.out.println("회원가입 실패");
			request.setAttribute("page","login");
			setDomain("facade");
			request.setAttribute("action",request.getContextPath()+"/facade.do");
		}
		super.execute();
	}
}
