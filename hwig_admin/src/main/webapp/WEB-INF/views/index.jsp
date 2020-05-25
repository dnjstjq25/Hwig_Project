<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="javax.servlet.http.HttpSession"%>
<%
	if (session != null) {
		Object obj = session.getAttribute("user");
		if (obj != null) {
			response.sendRedirect("/main");
		} else {
			response.sendRedirect("/loginForm");
		}
	} else {
		response.sendRedirect("/loginForm");
	}
%>