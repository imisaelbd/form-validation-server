package mx.edu.utez.sda.validationstart.model.Form.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data

public class FormDto {
    private String id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 4, message = "El nombre debe tener al menos 3 caracteres")
    @Pattern(regexp = "^[a-zA-Z]+(\\s*[a-zA-Z]*)*[a-zA-Z]+$", message = "El nombre no es válido")
    private String fullName;

    @NotBlank(message = "El correo no puede estar vacío")
    @Email(message = "El correo no es válido")
    private String email;

    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    @Size(max = 20, message = "La contraseña debe tener máximo 20 caracteres")
    private String password;

    @NotBlank(message = "La edad no puede estar vacía")
    @Pattern(regexp = "^[0-9]{1,3}$", message = "La edad no es válida")
    private String age;

    @NotBlank(message = "El genero no puede estar vacío")
    private String genere;

    @NotBlank(message = "El telefono no puede estar vacío")
    @Size(min = 10, message = "El telefono debe tener al menos 10 caracteres")
    @Size(max = 10, message = "El telefono debe tener máximo 10 caracteres")
    @Pattern(regexp = "^[0-9]{10}$", message = "El telefono no es válido")
    private String phone;

    @NotNull(message = "La fecha de nacimiento no puede estar vacía")
    @PastOrPresent(message = "La fecha de nacimiento no puede ser mayor a la fecha actual")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    @NotBlank(message = "El curp no puede estar vacío")
    @Size(min = 18, message = "El curp debe tener al menos 18 caracteres")
    @Size(max = 18, message = "El curp debe tener máximo 18 caracteres")
    @Pattern(regexp = "^[A-Z]{4}[0-9]{6}[HM]{1}[A-Z]{5}[0-9A-Z]{1}[0-9]{1}$", message = "El curp no es válido")
    private String curp;


}
