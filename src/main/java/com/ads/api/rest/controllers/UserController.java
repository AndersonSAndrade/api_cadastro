/*
 * Copyright (c) 2020. Olá todos os direitos reservados para Anderson S. Andrade.
 * Local do Arquivo: (/Users/andersons.andrade/Desktop/JAVA/SPRING/DEVELOPER/CADASTRO/api/src/main/java/com/ads/api/rest/controllers/UserController.java)
 * Projeto: api -> api -> UserController
 * Criador: andersons.andrade
 * Última Modificação: 28/11/2020 01:09
 */

package com.ads.api.rest.controllers;

import com.ads.api.domain.entity.Usuario;
import com.ads.api.domain.repositories.UserRepository;
import com.ads.api.exception.UserNotFoudException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/usuarios")
@Api("API Usuários")
public class UserController {

        private final UserRepository repository;

    @GetMapping()
    @ApiOperation("Obtendo todos ou Filtrando Usuários por nome")
    public List<Usuario> find(Usuario filtro){
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(filtro, matcher);
        return repository.findAll(example);
    }

    @GetMapping("/{id}")
    @ApiOperation("Obtendo usuário por id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Usuário encontrado."),
            @ApiResponse(code = 404, message = "Usuário não encontrado.")
    })
    public Usuario getClienteById(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(() ->
                new UserNotFoudException());
    }

    @PostMapping
    @ResponseStatus(CREATED)
    @ApiOperation("Salvando um novo usuário")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Usuário salvo com sucesso."),
            @ApiResponse(code = 400, message = "Erro de validação.")
    })
    public ResponseEntity<Usuario> save(@RequestBody @Valid Usuario usuario){
        Usuario req = repository.save(usuario);
        return ResponseEntity.ok(req);
    }

    @PutMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    @ApiOperation("Atualizando usuário por id")
    @ApiResponses({
            @ApiResponse(code = 202, message = "Usuário Atualizado com sucesso."),
            @ApiResponse(code = 404, message = "Usuário não encontrado.")
    })
    public void update(@PathVariable Integer id, @RequestBody Usuario usuario){
        repository.findById(id).map(c -> {
            usuario.setCodigo(c.getCodigo());
            repository.save(usuario);
            return c;
        }).orElseThrow(() ->
                new UserNotFoudException());
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    @ApiOperation("Deletando usuário por id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Usuário deletado com sucesso."),
            @ApiResponse(code = 404, message = "Usuário não encontrado.")
    })
    public void delete(@PathVariable Integer id){
        repository.findById(id).map(c -> {
            repository.delete(c);
            return c;
        }).orElseThrow(() ->
                new UserNotFoudException());
    }




}
