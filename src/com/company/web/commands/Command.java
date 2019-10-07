package com.company.web.commands;

import javax.servlet.http.HttpServletRequest;

import com.company.web.pool.Constants;

import lombok.Data;
@Data
public class Command implements Order {
	protected HttpServletRequest request;
	protected String domain, page, view;
	
	@Override
	public void execute() {
		setDomain();
		setView();
		setPage();
		//일단 반복되는 구문 정리하려고 공통분모인 커맨드에 끌고 오긴했다.
	}
	
	public void setDomain() {
		domain = (request.getServletPath()
				.substring(1,request.getServletPath().indexOf(".")));
	}
	
	public void setView() {
		view = String.format(Constants.DOUBLE_PATH, domain,"main");
	}
	
	public void setPage() {
		page = page != null ? page : 
			(request.getParameter("page")==null) ?
				"login" : request.getParameter("page");
		request.setAttribute("page", page);
	}
}
