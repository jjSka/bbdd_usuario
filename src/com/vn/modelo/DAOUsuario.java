/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.modelo;

import com.vn.modelo.Usuario;
import com.vn.modelo.interfaces.IDAOUsuario;
import com.vn.modelo.sql.SQLConnection;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class DAOUsuario implements IDAOUsuario{
    
    private List<Usuario> listaUsuarios;
    private Connection conn;
    
    public DAOUsuario() {
        listaUsuarios = new ArrayList<>();
        conn = new SQLConnection().openConnection("jdbc:derby://localhost:1527/db_users", "root", "1234");
    }
    
    @Override
    public Usuario crear(Usuario nuevoUsuario){
        listaUsuarios.add(nuevoUsuario);
        return null;
    }
    @Override
    public void modificar(int id, String email, String pwd, String nombre, int edad){
        
    }
    @Override
    public boolean eliminar(int id){
        boolean flag = false;
        for(Usuario usuario : listaUsuarios){
            if(id==usuario.getId()){
                flag=true;
                listaUsuarios.remove(usuario);
            }
        }
        return flag;
    }
    @Override
    public Usuario leerUno(int id){
        return null;
    }
    @Override
    public Usuario leerUno(String email){
        for(Usuario usuario : listaUsuarios){
           if(usuario.getEmail()==email)
               return usuario;
       }
        return null;
    }
    @Override
    public List<Usuario> leerTodos(String nombre){
        
        return listaUsuarios;
    }
    @Override
    public List<Usuario> leerTodos(){
        return listaUsuarios;
    }
    
}
