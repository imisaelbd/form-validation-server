package mx.edu.utez.sda.validationstart.service.FormService;

import lombok.RequiredArgsConstructor;
import mx.edu.utez.sda.validationstart.model.Form.Form;
import mx.edu.utez.sda.validationstart.model.Form.FormRepository;
import mx.edu.utez.sda.validationstart.model.Form.dto.FormDto;
import mx.edu.utez.sda.validationstart.utils.CustomResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional

public class FormService {

    private final FormRepository repository;

    @Transactional(rollbackFor = Exception.class)
    public CustomResponse<Form> create (FormDto form){
        String id = UUID.randomUUID().toString();
        String newId = id.substring(0, 7);
        form.setId(newId);
        Form newForm = new Form();
        BeanUtils.copyProperties(form, newForm);
        repository.save(newForm);
        return new CustomResponse<>(
                newForm, false, 200, "Formulario registrado correctamente!"
        );
    }
}
