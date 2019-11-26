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
    public void modificarUsuariosValidos() {
        Usuario u1= su.crear(new Usuario("adios@o.com","123e","Antonio", 18));
        Usuario u2= su.crear(new Usuario("hola@gmail.com","4444","Fernando",21));
        Usuario u3= su.crear(new Usuario("def@gmail.com","4455","Rosana",30));
        Usuario u4= su.crear(new Usuario("buenas@gmail.com","4567","Alba Maria",32));
        
        su.modificar(u1.getId(),"adios@gmail.com",u1.getPassword(),u1.getName(),u1.getEdad());
        assertEquals("adios@gmail.com",su.leerUno("adios@gmail.com").getEmail());
        su.modificar(u2.getId(),u2.getEmail(),"1222","Fernan",21);
        assertEquals("Fernan",su.leerUno("hola@gmail.com").getName());
        su.modificar(u3.getId(),"def@gmail.com","1234",u3.getName(),u3.getEdad());
        assertEquals("1234",su.leerUno("def@gmail.com").getPassword());
        su.modificar(u4.getId(),u4.getEmail(),u4.getPassword(),u3.getName(),15);
        assertEquals(15,su.leerUno("buenas@gmail.com").getEdad());
    }
    
    @Test
    public void modificacionesInvalidasDeUsuarios(){
        Usuario u1= su.crear(new Usuario("abc@gmail.com","123e","Antonio", 18));
        Usuario u2= su.crear(new Usuario("hola@gmail.com","4444","Fernando",21));
        Usuario u3= su.crear(new Usuario("def@gmail.com","4455","Rosana",30));
        Usuario u4= su.crear(new Usuario("buenas@gmail.com","4567","Alba Maria",32));
        
        su.modificar(u1.getId(),"dddhotmail.com",u1.getPassword(),u1.getName(),u1.getEdad());
        
        assertNotEquals("dddhotmail.com",su.leerUno("abc@gmail.com").getEmail());
        su.modificar(u2.getId(),u2.getEmail(),"1222","Fer",21);
        assertNotEquals("Fer",su.leerUno("hola@gmail.com").getName());
        su.modificar(u3.getId(),"def@gmail.com","1",u3.getName(),u3.getEdad());
        assertNotEquals("1",su.leerUno("def@gmail.com").getPassword());
    }

    @Test
    public void eliminarUsuarios() {

    }
}
