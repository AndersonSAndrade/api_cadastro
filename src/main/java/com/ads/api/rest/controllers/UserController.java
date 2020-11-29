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
public class UserController {

        private final UserRepository repository;

    @GetMapping()
    public List<Usuario> find(Usuario filtro){
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(filtro, matcher);
        return repository.findAll(example);
    }

    @PostMapping( consumes = {"multipart/form-data"})
    public ResponseEntity<Usuario> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        File convertFile = new File("./src/main/resources/uploads/"+file.getOriginalFilename());
        convertFile.createNewFile();
        FileOutputStream fout = new FileOutputStream(convertFile);
        fout.write(file.getBytes());
        fout.close();
        return new ResponseEntity("Imagem adicionada com sucesso", OK);
    }

    @GetMapping("/{id}")
    public Usuario getClienteById(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(NOT_FOUND, "Usuário não encontrado"));
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ResponseEntity<Usuario> save(@RequestBody @Valid Usuario usuario){
        Usuario req = repository.save(usuario);
        return ResponseEntity.ok(req);
    }

    @PutMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody Usuario usuario){
        repository.findById(id).map(c -> {
            usuario.setCodigo(c.getCodigo());
            repository.save(usuario);
            return c;
        }).orElseThrow(() ->
                new ResponseStatusException(NOT_FOUND, "Usuário não encontrado"));
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Integer id){
        repository.findById(id).map(c -> {
            repository.delete(c);
            return c;
        }).orElseThrow(() ->
                new ResponseStatusException(NOT_FOUND, "Usuário não encontrado"));
    }




}
