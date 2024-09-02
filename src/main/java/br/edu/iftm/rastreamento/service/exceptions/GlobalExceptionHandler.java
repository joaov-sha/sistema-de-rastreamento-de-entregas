package br.edu.iftm.rastreamento.service.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(NaoAcheiException.class)
    public ResponseEntity<?> handleNaoAcheiException(NaoAcheiException e, WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(new Date(), e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    public static class ErrorDetails{
        private Date timestamp;
        private String message;
        private String details;

        public ErrorDetails(Date timestamp, String message, String details){
            super();
            this.timestamp = timestamp;
            this.message = message;
            this.details = details;
        }

        public Date getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Date timestamp) {
            this.timestamp = timestamp;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }

        
    }
}
