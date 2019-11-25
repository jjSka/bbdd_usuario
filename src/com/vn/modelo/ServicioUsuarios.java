/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.modelo;

import jdk.nashorn.internal.runtime.regexp.RegExp;

/**
 *
 * @author PC
 */
public class ServicioUsuarios {

    public boolean validarEmail(String email) {
        String re = "^(.+)@(.+)$";
        return true;
    }

    public boolean validarPassWord(String pwd) {
        String re = "^[a-zA-Z][ ]*$";
        return true;
    }

    public boolean validarNombre(String name) {
        String re = "^[a-zA-Z][ ]*$";
        return true;
    }
}
