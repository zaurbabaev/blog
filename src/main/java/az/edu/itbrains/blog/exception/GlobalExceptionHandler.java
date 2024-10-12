package az.edu.itbrains.blog.exception;

import az.edu.itbrains.blog.payloads.MessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<MessageResponse> resourceNotFoundException(ResourceNotFoundException exception) {
        String message = exception.getMessage();
        MessageResponse messageResponse = new MessageResponse(message);
        return new ResponseEntity<>(messageResponse, HttpStatus.NOT_FOUND);
    }
}
