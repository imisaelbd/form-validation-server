package mx.edu.utez.sda.validationstart.controller.Form;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mx.edu.utez.sda.validationstart.model.Form.Form;
import mx.edu.utez.sda.validationstart.model.Form.dto.FormDto;
import mx.edu.utez.sda.validationstart.service.FormService.FormService;
import mx.edu.utez.sda.validationstart.utils.CustomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/form")
@CrossOrigin
@RequiredArgsConstructor

public class FormController {

    private final FormService service;

    @PostMapping("/create")
    public ResponseEntity<CustomResponse<Form>> create (@Valid @RequestBody FormDto form){
        try {
            CustomResponse<Form> response = service.create(form);
            HttpStatus statusCode = response.isError() ? HttpStatus.BAD_REQUEST : HttpStatus.OK;
            return new ResponseEntity<>(
                    response,
                    statusCode
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new CustomResponse<>(
                            null, true, 400, e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
}
