package com.company.web.commands;

import javax.servlet.http.HttpServletRequest;

public class MoveCommand extends Command{
	public MoveCommand(HttpServletRequest request) {
		setRequest(request);
		execute();
	}
	 @Override
	public void execute() {
		 super.execute();
	}
}
