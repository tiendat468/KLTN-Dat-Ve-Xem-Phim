package com.example.datvexemphimonl.config;

import javax.servlet.http.HttpServletRequest;

public class MailConfig {
	public static String getSiteURl(HttpServletRequest request) {
		String siteURL = request.getRequestURL().toString();
		return siteURL.replace(request.getServletPath(), "");
	}

}
