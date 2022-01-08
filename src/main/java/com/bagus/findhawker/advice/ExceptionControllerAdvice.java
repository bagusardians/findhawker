package com.bagus.findhawker.advice;

import com.bagus.findhawker.hawker.ErrorEntity;
import com.bagus.findhawker.hawker.ErrorType;
import com.bagus.findhawker.hawker.HawkerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler(value = HawkerException.class)
	public ResponseEntity<ErrorEntity> handleFriendServiceException(HawkerException e) {
		ErrorType errorType = e.getErrorType();
		ErrorEntity error = new ErrorEntity(
				errorType.getMessage()
		);
		return new ResponseEntity<>(error, errorType.getErrorStatus());
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ErrorEntity> handleException(Exception e) {
		ErrorEntity error = new ErrorEntity(
				"Internal Server Error"
		);
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}