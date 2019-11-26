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

    public void crearParaTest() {

    }

    @Test
    public void crearUsuariosInvalidos() {
        DAOUsuario du = new DAOUsuario();
        List<Usuario> ls = new ArrayList<>();
        du.crear(new Usuario("prueba@gmail.com", "aa", "asa", 0));
        Usuario u = du.leerUno("prueba@gmail.com");

        System.out.println(u.getName() + " " + u.getEmail() + " " + u.getPassword() + " " + u.getEdad());

    }

    @Test
    public void crearUsuariosValidos() {
        //       DAOUsuario du= new DAOUsuario();
//        assertNotNull(du.crear(new Usuario("email@email.com","password","Felix",23)));

        

    }

    @Test
    public void modificarUsuariosValidos() {
        Usuario u1= du.crear(new Usuario("abc@gmail.com","123e","Antonio", 18));
        Usuario u2= du.crear(new Usuario("hola@gmail.com","4444","Fernando",21));
        Usuario u3= du.crear(new Usuario("def@gmail.com","4455","Rosa",30));
        Usuario u4= du.crear(new Usuario("buenas@gmail.com","4567","Alba",32));
        
        du.modificar(u1.getId(),"ddd@hotmail.com",u1.getPassword(),u1.getName(),u1.getEdad());
        assertEquals("ddd@hotmail.com",du.leerUno(u1.getId()).getEmail());
        du.modificar(u2.getId(),u2.getEmail(),"1222","Fernan",21);
        assertEquals("Fernan",du.leerUno("hola@gmail.com").getName());
        du.modificar(u3.getId(),"def@gmail.com","1234",u3.getName(),u3.getEdad());
        assertEquals("1234",du.leerUno("def@gmail.com").getPassword());
        du.modificar(u4.getId(),u4.getEmail(),u4.getPassword(),u3.getName(),15);
        assertEquals(15,du.leerUno("buenas@gmail.com").getEdad());
    }
    
    @Test
    public void modificacionesInvalidasDeUsuarios(){
        Usuario u1= du.crear(new Usuario("abc@gmail.com","123e","Antonio", 18));
        Usuario u2= du.crear(new Usuario("hola@gmail.com","4444","Fernando",21));
        Usuario u3= du.crear(new Usuario("def@gmail.com","4455","Rosa",30));
        Usuario u4= du.crear(new Usuario("buenas@gmail.com","4567","Alba",32));
        
        du.modificar(u1.getId(),"dddhotmail.com",u1.getPassword(),u1.getName(),u1.getEdad());
        
        assertNotEquals("dddhotmail.com",du.leerUno("abc@gmail.com").getEmail());
        du.modificar(u2.getId(),u2.getEmail(),"1222","Fer",21);
        assertNotEquals("Fer",du.leerUno("hola@gmail.com").getName());
        du.modificar(u3.getId(),"def@gmail.com","1",u3.getName(),u3.getEdad());
        assertNotEquals("1",du.leerUno("hola@gmail.com").getPassword());
        du.modificar(u4.getId(),u4.getEmail(),u4.getPassword(),u3.getName(),11);
        assertNotEquals(11,du.leerUno("buenas@gmail.com").getEdad());
    }

    @Test
    public void eliminarUsuarios() {

    }
}
