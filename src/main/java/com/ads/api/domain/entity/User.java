/*
 * Copyright (c) 2020. Olá todos os direitos reservados para Anderson S. Andrade.
 * Local do Arquivo: (/Users/andersons.andrade/Desktop/JAVA/SPRING/DEVELOPER/CADASTRO/api/src/main/java/com/ads/api/domain/entity/Usuario.java)
 * Projeto: api -> api -> Usuario
 * Criador: andersons.andrade
 * Última Modificação: 28/11/2020 00:55
 */

package com.ads.api.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "usuario")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;
    private String nome;
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    private String foto;
}
