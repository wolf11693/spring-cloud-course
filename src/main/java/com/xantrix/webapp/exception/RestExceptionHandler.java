package com.xantrix.webapp.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.xantrix.webapp.controller.exception.BindingException;
import com.xantrix.webapp.controller.exception.DuplicateException;
import com.xantrix.webapp.controller.exception.NotFoundException;
import com.xantrix.webapp.response.ResponseBody;
import com.xantrix.webapp.response.ResponsePayload;

@ControllerAdvice
@RestController
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = NotFoundException.class)
	public final ResponseEntity<ResponseBody<?>> exceptionNotFoundHandler(Exception ex) {
		ResponseBody<ResponsePayload> response = new ResponseBody<ResponsePayload>(null);
		response.addMessage(ex.getMessage());

		return new ResponseEntity<ResponseBody<?>>(response, new HttpHeaders(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = {BindingException.class, Exception.class})
	public ResponseEntity<ResponseBody<?>> exceptionBindingHandler(Exception ex) {
		ResponseBody<ResponsePayload> response = new ResponseBody<ResponsePayload>(null);
		
		if(ex instanceof BindingException) {
			response.addMessage(ex.getMessage());
		} else {
			response.addMessage("La richiesta non può essere eseguita a causa di un errore generico");
		}
		response.addMessage(ex.getMessage());

		return new ResponseEntity<ResponseBody<?>>(response, new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(DuplicateException.class)
	public ResponseEntity<ResponseBody<?>> exceptionDeplicateRecordHandler(Exception ex) {
		ResponseBody<ResponsePayload> response = new ResponseBody<ResponsePayload>(null);
		response.addMessage(ex.getMessage());

		return new ResponseEntity<ResponseBody<?>>(response, new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE);
	}
}