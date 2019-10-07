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
		CompanyBean cp = new CompanyBean();
		cp.setEmpno(request.getParameter("empNo"));
		cp.setEname(request.getParameter("eName"));
		cp.setJob(request.getParameter("job"));
		cp.setMgr(request.getParameter("mgr"));
		cp.setHireDate(request.getParameter("hireDate"));
		cp.setSal(request.getParameter("sal"));
		cp.setComm(request.getParameter("comm"));
		cp.setDeptno(request.getParameter("deptNo"));
		if (CompanyServiceImpl.getInstance().joinEmp(cp)) {
			System.out.println("회원가입 성공");
		}else {
			System.out.println("회원가입 실패");
			setPage("login");
			setDomain("facade");
			request.setAttribute("action",request.getContextPath()+"/facade.do");
		}
		super.execute();
	}
}
