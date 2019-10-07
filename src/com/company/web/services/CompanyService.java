package com.company.web.services;

import java.util.List;

import com.company.web.domains.CompanyBean;

public interface CompanyService {

	public boolean joinEmp(CompanyBean param);
	public CompanyBean loginEmp(CompanyBean param);
	public List<CompanyBean> findAllDept();
}
