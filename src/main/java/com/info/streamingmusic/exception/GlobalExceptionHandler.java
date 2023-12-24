package com.info.streamingmusic.exception;

import com.info.streamingmusic.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> handleGlobalException(Exception exception, WebRequest webRequest) {
        ErrorDto errorRespuestaDto = new ErrorDto();
        errorRespuestaDto.setApiPath(webRequest.getDescription(false));
        errorRespuestaDto.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        errorRespuestaDto.setErrorMessage("Se produjo un error interno en el servidor.");
        errorRespuestaDto.setErrorTime(LocalDateTime.now());
        errorRespuestaDto.setDeveloperMessage(exception.getMessage()); // Mensaje original de la excepción para depuración

        return new ResponseEntity<>(errorRespuestaDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDto> handleResourceNotFoundException(NotFoundException exception, WebRequest webRequest) {
        ErrorDto errorRespuestaDto = new ErrorDto();
        errorRespuestaDto.setApiPath(webRequest.getDescription(false));
        errorRespuestaDto.setHttpStatus(HttpStatus.NOT_FOUND);
        errorRespuestaDto.setErrorMessage(exception.getMessage()); // Mensaje personalizado de la excepción
        errorRespuestaDto.setErrorTime(LocalDateTime.now());

        return new ResponseEntity<>(errorRespuestaDto, HttpStatus.NOT_FOUND);
    }

}