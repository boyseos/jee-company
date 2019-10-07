package com.company.web.serviceimpls;

import java.util.List;

import com.company.web.daoimpls.CompanyDaoImpl;
import com.company.web.domains.CompanyBean;
import com.company.web.services.CompanyService;

public class CompanyServiceImpl implements CompanyService{
	private static CompanyServiceImpl instance = new CompanyServiceImpl();
	
	public static CompanyServiceImpl getInstance() {return instance;}
	
	private CompanyServiceImpl() {}
	
	@Override
	public boolean joinEmp(CompanyBean param) {
		return CompanyDaoImpl.getInstance().insertEmp(param);
	}

	@Override
	public CompanyBean loginEmp(CompanyBean param) {
		return CompanyDaoImpl.getInstance().selectByEmpnoEname(param);
	}

	@Override
	public List<CompanyBean> findAllDept() {
		return CompanyDaoImpl.getInstance().findByDeptTable();

	
}
}
