/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.tests;

import com.vn.modelo.DAOUsuario;
import com.vn.modelo.Usuario;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PC
 */
public class TestModeloUsuario {
    

    public void crearParaTest(){
        DAOUsuario du= new DAOUsuario();
        du.crear(new Usuario("email@email.com","password","Felix",23));
    }
    
    @Test
    public void crearUsuariosInvalidos() {
        DAOUsuario dao = new DAOUsuario();
        dao.crear(new Usuario("aaa", "-", "999", 0));
    }
    @Test
    public void crearUsuariosValidos() {
        
        
    }
    @Test
    public void modificarUsuarios() {
        
    }    
    @Test
    public void eliminarUsuarios() {
        
    }     
}
