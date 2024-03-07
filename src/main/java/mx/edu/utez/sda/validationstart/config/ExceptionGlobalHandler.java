package mx.edu.utez.sda.validationstart.config;

import mx.edu.utez.sda.validationstart.utils.CustomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Objects;

@ControllerAdvice

public class ExceptionGlobalHandler {
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<?> customValidationErrorHandling(MethodArgumentNotValidException exception) {
        CustomResponse<String> errorDetails = new CustomResponse<>(
                null,
                true,
                400,
                Objects.requireNonNull(exception.getBindingResult().getFieldError()).getDefaultMessage()
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    public ResponseEntity<?> customHttpMessageNotReadableExceptionHandling() {
        CustomResponse<String> errorDetails = new CustomResponse<>(
                null,
                true,
                400,
                "La fecha ingresada no es valida"
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
