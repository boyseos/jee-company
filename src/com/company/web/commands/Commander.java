package com.company.web.commands;

import javax.servlet.http.HttpServletRequest;

import com.company.web.enums.Action;


public class Commander  {
	 public static Command direct(HttpServletRequest request) {
		 Command cmd = null;
		 try {
			switch (Action.valueOf(
					(request.getParameter("action")==null) ? 
							"MOVE": request.getParameter("action")
							.toUpperCase())) {
				case CREATE:	cmd = new CreateCommand(request);	break;
				case LOGIN:		cmd = new LoginCommand(request); 	break;
				default:		cmd = new MoveCommand(request);		break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cmd;
	 }
		
}
