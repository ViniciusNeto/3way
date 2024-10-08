package com.api.vendas.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.api.vendas.dtos.ErrorDto;
import com.api.vendas.exceptions.AppException;

@ControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler(value = { AppException.class })
	@ResponseBody
	public ResponseEntity<ErrorDto> handleException(AppException ex){
		return ResponseEntity.status(ex.getStatus()).body(new ErrorDto(ex.getMessage()));
	}

}
