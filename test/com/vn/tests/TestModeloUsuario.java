/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.tests;

import com.vn.modelo.DAOUsuario;
import com.vn.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PC
 */
public class TestModeloUsuario {

    public void crearParaTest(){
       
        
        
    }
    
    @Test
    public void crearUsuariosInvalidos() {
        DAOUsuario du= new DAOUsuario();
        List<Usuario> ls = new ArrayList<>();
        ls=du.leerTodos();
        for(Usuario u : ls){
            System.out.println(u.getName()+" "+u.getEmail()+" "+u.getPassword()+" "+u.getEdad());
        }
    }
    @Test
    public void crearUsuariosValidos() {
 //       DAOUsuario du= new DAOUsuario();
//        assertNotNull(du.crear(new Usuario("email@email.com","password","Felix",23)));
        
    }
    @Test
    public void modificarUsuarios() {
        
    }    
    @Test
    public void eliminarUsuarios() {
        
    }     
}
