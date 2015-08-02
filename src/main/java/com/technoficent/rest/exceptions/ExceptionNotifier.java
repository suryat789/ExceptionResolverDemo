package com.technoficent.rest.exceptions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

public class ExceptionNotifier extends SimpleMappingExceptionResolver {

	@Override
	public ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		BusinessException businessException = null;
		
		if(ex instanceof BusinessException)
			businessException = (BusinessException)ex;

		if(businessException.getExceptionLevel().equals(BusinessException.ExceptionLevel.SEVERE)){
			System.out.println("Notify");
		}
		return super.doResolveException(request, response, handler, ex);
	}
}
