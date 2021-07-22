package com.portifolio.personsapi.entity;

import com.portifolio.personsapi.enums.PhoneType;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Como vai ser o incremento do banco
    private Long id;
    //enumeration, enum, precisa mostrar como vai ser salvo
    @Enumerated(EnumType.STRING)
    @Column(nullable=false)//Not null
    private PhoneType type;
    @Column(nullable = false)//Not null
    private String number;
}
