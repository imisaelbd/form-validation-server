package mx.edu.utez.sda.validationstart.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CustomResponse <T> {

        T data;

        boolean error;

        int statusCode;

        String message;
}
