package com.company.web.commands;

import javax.servlet.http.HttpServletRequest;

public class Receiver {
	public static Command cmd = new Command();
	public static void init(HttpServletRequest request) {
		System.out.println("리시버");
		cmd = Commander.direct(request);
	}

}
