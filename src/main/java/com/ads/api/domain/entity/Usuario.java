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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "usuario")
public class Usuario{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    @NotEmpty(message = "O Campo nome é obrigatório.")
    private String nome;
    @Column(name = "data_nascimento")
    @NotNull(message = "O campo data de aniversário é obrigatório.")
    private String dataNascimento;
    @Column(columnDefinition = "text")
    private String foto;
}
