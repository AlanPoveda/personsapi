package com.portifolio.personsapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;
import org.hibernate.validator.constraints.br.CPF;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private Long id;

    @NotEmpty
    @Size(min=2, max=100) // tamanho entrada
    private String firstName;

    @NotEmpty
    @Size(min=2, max=100) // tamanho da entrada
    private String lastName;

    @NotEmpty // validação
    @CPF // formato cpf
    private String cpf;

    private String birthDate;

    @Valid
    @NotEmpty
    private List<PhonesDTO> phones;
}
