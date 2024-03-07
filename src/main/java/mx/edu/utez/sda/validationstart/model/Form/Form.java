package mx.edu.utez.sda.validationstart.model.Form;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collation = "form")

public class Form {

    @Id
    private String id;

    private String fullName;

    private String email;

    private String password;

    private String age;

    private String genere;

    private String phone;

    private Date birthDate;

    private String curp;

}
