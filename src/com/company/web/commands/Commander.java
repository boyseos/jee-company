package com.company.web.commands;

import javax.servlet.http.HttpServletRequest;

import com.company.web.enums.Action;


public class Commander  {
	 public static Command direct(HttpServletRequest request) {
		 System.out.println("커맨더");
		 Command cmd = null;
		 try {
			switch (Action.valueOf(request.getParameter("action").toUpperCase())) {
			case CREATE:
				cmd = new CreateCommand(request); break;
			case LOGIN:
				cmd = new LoginCommand(request); break;
			case MOVE:
				cmd = new MoveCommand(request); break;
			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cmd;
	 }
		
}
