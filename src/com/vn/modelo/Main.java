/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        DAOUsuario du= new DAOUsuario();
        du.crear(new Usuario("a@a.com","1234","Jose",23));
        List<Usuario>lU= new ArrayList<Usuario>();
        Usuario u1= du.leerUno("a@a.com");
        System.out.println(u1.getName());
    }
    
}
