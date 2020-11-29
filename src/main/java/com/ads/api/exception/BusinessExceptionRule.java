/*
 * Copyright (c) 2020. Olá todos os direitos reservados para Anderson S. Andrade.
 * Local do Arquivo: (/Users/andersons.andrade/Desktop/JAVA/SPRING/DEVELOPER/CADASTRO/api/src/main/java/com/ads/api/exception/BusinessExceptionRule.java)
 * Projeto: api -> api -> BusinessExceptionRule
 * Criador: andersons.andrade
 * Última Modificação: 28/11/2020 10:05
 */

package com.ads.api.exception;

public class BusinessExceptionRule extends RuntimeException{
    public BusinessExceptionRule(String msg){
        super(msg);
    }
}
