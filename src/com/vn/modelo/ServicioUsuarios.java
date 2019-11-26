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
         if(email==null)
            return false;
        String re = "^(.+)@(.+)$";
        System.out.println("mail " + email.matches(re));
        return email.matches(re);
    }

    public boolean validarPassWord(String pwd) {
        if(pwd==null)
            return false;
        if (pwd.length() > 1 && pwd.length()<50) {
            return true;
        } else {
            System.out.println("pass false");
            return false;
        }
    }

    public boolean validarEdad(String edad) {
        int e = Integer.parseInt(edad);
        if (e < 12) {
            return false;
        } else {
            return true;
        }
    }

    public boolean validarNombre(String name) {
         if(name==null)
            return false;
        if (name.length() > 4&&name.length()<50) {
            return true;
        } else {
            System.out.println("name false");
            return false;
        }
    }

    public boolean validar(Usuario usuario) {
        return (validarEmail(usuario.getEmail()) && validarPassWord(usuario.getPassword()) && validarNombre(usuario.getName()) &&validarEdad(usuario.getEdad()+""));
    }
    // validarDatos(....){}
}
