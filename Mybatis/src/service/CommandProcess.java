package service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandProcess {

	String requestPro(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException;
	
	
}


