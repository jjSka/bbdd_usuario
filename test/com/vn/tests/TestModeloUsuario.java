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

    private DAOUsuario su;

    public TestModeloUsuario() {
        su = new DAOUsuario();
    }

    @Test
    public void crearUsuariosInvalidos() {     
        Usuario u1 = su.crear(new Usuario(null, "", "", 1));
        Usuario u2 = su.crear(new Usuario("", null, "Nom", -99));
        Usuario u3 = su.crear(new Usuario("b@a.a", null, "", 0));
        Usuario u4 = su.crear(new Usuario("b@a.a", "1234", "Nom 2", 7));
        Usuario u5 = su.crear(new Usuario("b@a.a", "1234", "Nom 2", 1));
        assertNull(u1);
        assertNull(u2);
        assertNull(u3);
        assertNull(u4);
        assertNull(u5);
        assertNull(su.leerUno("b@a.a"));

    }

    @Test
    public void crearUsuariosValidos() {
        su.crear(new Usuario("a@a.a", "1234", "Nom 1", 20));
        su.crear(new Usuario("a@a.a2", "1234", "Nom 2", 30));

        assertTrue(su.leerUno("a@a.a").getId() > 0);
        assertEquals("Nom 2", su.leerUno("a@a.a2").getName());
    }

    @Test
    public void modificarUsuarios() {

    }

    @Test
    public void eliminarUsuarios() {

    }
}
