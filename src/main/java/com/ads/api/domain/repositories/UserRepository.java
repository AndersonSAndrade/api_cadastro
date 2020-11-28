/*
 * Copyright (c) 2020. Olá todos os direitos reservados para Anderson S. Andrade.
 * Local do Arquivo: (/Users/andersons.andrade/Desktop/JAVA/SPRING/DEVELOPER/CADASTRO/api/src/main/java/com/ads/api/domain/repositories/UsuarioRepository.java)
 * Projeto: api -> api -> UsuarioRepository
 * Criador: andersons.andrade
 * Última Modificação: 28/11/2020 01:00
 */

package com.ads.api.domain.repositories;

import com.ads.api.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    //@Query(value = " select c from Cliente c where c.nome like :nome ")
    List<User> encontrarPorNome(@Param("nome") String nome);
}
