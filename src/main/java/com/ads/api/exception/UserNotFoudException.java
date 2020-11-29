/*
 * Copyright (c) 2020. Olá todos os direitos reservados para Anderson S. Andrade.
 * Local do Arquivo: (/Users/andersons.andrade/Desktop/JAVA/SPRING/DEVELOPER/CADASTRO/api/src/main/java/com/ads/api/exception/UserNotFoudException.java)
 * Projeto: api -> api -> UserNotFoudException
 * Criador: andersons.andrade
 * Última Modificação: 28/11/2020 01:10
 */

package com.ads.api.exception;

public class UserNotFoudException extends RuntimeException{
    public UserNotFoudException() {
        super("Usuário Não Encontrado!");
    }
}
