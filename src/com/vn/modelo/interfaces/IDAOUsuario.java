/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.modelo.interfaces;

import com.vn.modelo.Usuario;
import java.util.List;

/**
 *
 * @author PC
 */
public interface IDAOUsuario {
    
    public abstract Usuario crear(Usuario usuario);
    public abstract void modificar(int id, String email, String pwd, String nombre, int edad);
    public abstract boolean eliminar(int id);
    public abstract Usuario leerUno(int id);
    public abstract Usuario leerUno(String email);
    public abstract List<Usuario> leerTodos(String nombre);
    public abstract List<Usuario> leerTodos();
    
}
