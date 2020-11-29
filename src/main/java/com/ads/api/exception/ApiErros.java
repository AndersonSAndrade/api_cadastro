/*
 * Copyright (c) 2020. Olá todos os direitos reservados para Anderson S. Andrade.
 * Local do Arquivo: (/Users/andersons.andrade/Desktop/JAVA/SPRING/DEVELOPER/CADASTRO/api/src/main/java/com/ads/api/exception/ApiErros.java)
 * Projeto: api -> api -> ApiErros
 * Criador: andersons.andrade
 * Última Modificação: 28/11/2020 01:10
 */

package com.ads.api.exception;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class ApiErros {
    @Getter
    private List<String> erros;

    public ApiErros(List<String> erros) {
        this.erros = erros;
    }

    public ApiErros(String msgError){
        this.erros = Arrays.asList(msgError);
    }


}
