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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class DAOUsuario implements IDAOUsuario {

    private Connection conn;

    public DAOUsuario() {
    }

    @Override
    public Usuario crear(Usuario nuevoUsuario) {
        ServicioUsuarios su = new ServicioUsuarios();
        boolean flag = true;
        int edad = nuevoUsuario.getEdad();
        String email = nuevoUsuario.getEmail();
        String password = nuevoUsuario.getPassword();
        String name = nuevoUsuario.getName();
        flag = su.validarEmail(email) ? flag : false;
        flag = su.validarNombre(name) ? flag : false;
        flag = su.validarPassWord(password) ? flag : false;
        flag = su.validarEdad(edad + "") ? flag : false;

        if (flag) {
            if (leerUno(email) != null) {
                return leerUno(nuevoUsuario.getEmail());
            }
            String sqlQuery = "INSERT INTO USUARIO (EMAIL, PASSWORD, NOMBRE, EDAD) VALUES ( ? , ? , ? , ? ) ";
            String sqlIns = "SELECT ID FROM USUARIO WHERE EMAIL = ? ";
            try {
                conn = new SQLConnection().openConnection();
                PreparedStatement sentenciaSQL = conn.prepareStatement(sqlQuery);
                sentenciaSQL.setString(1, email);
                sentenciaSQL.setString(2, password);
                sentenciaSQL.setString(3, name);
                sentenciaSQL.setInt(4, edad);
                sentenciaSQL.executeUpdate();
                PreparedStatement sentenciaSQL2 = conn.prepareStatement(sqlIns);
                sentenciaSQL2.setString(1, nuevoUsuario.getEmail());
                ResultSet rs = sentenciaSQL2.executeQuery();
                int id = 0;
                while (rs.next()) {
                    id = rs.getInt("ID");
                }
                nuevoUsuario.setId(id);
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            nuevoUsuario.setId(0);
        } else {
            System.err.println("Error de validacion: Email - " + su.validarEmail(email) + " Nombre: - " + su.validarNombre(name) + " Password: - " + su.validarPassWord(password));
            return null;
        }

        return nuevoUsuario;
    }

    @Override
    public void modificar(int id, String email, String pwd, String nombre, int edad) {
        ServicioUsuarios su = new ServicioUsuarios();
        boolean flag = true;

        flag = su.validarEmail(email) ? flag : false;
        flag = su.validarNombre(nombre) ? flag : false;
        flag = su.validarPassWord(pwd) ? flag : false;
        if (flag) {
            String sqlQuery = "UPDATE USUARIO SET EMAIL = ? , PASSWORD = ? , NOMBRE = ? , EDAD = ? WHERE ID = ? ";
            try {
                conn = new SQLConnection().openConnection();
                PreparedStatement sentenciaSQL = conn.prepareStatement(sqlQuery);
                sentenciaSQL.setString(1, email);
                sentenciaSQL.setString(2, pwd);
                sentenciaSQL.setString(3, nombre);
                sentenciaSQL.setInt(4, edad);
                sentenciaSQL.setInt(5, id);
                sentenciaSQL.executeUpdate();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.err.println("Error de validacion: Email - " + su.validarEmail(email) + " Nombre: - " + su.validarNombre(nombre) + " Password: - " + su.validarPassWord(pwd));
        }

    }

    @Override
    public boolean eliminar(int id) {
        String sqlQuery = "DELETE FROM USUARIO WHERE ID= ? ";
        boolean flag = true;
        try {
            conn = new SQLConnection().openConnection();
            PreparedStatement sentenciaSQL = conn.prepareStatement(sqlQuery);
            sentenciaSQL.setInt(1, id);
            sentenciaSQL.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            flag = false;
        }

        return flag;
    }

    @Override
    public Usuario leerUno(int id) {
        List<Usuario> listaUsuarios = leerTodos();
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

    @Override
    public Usuario leerUno(String email) {
        List<Usuario> listaUsuarios = leerTodos();
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getEmail().equals(email)) {
                return usuario;
            }
        }
        return null;
    }

    @Override
    public List<Usuario> leerTodos(String nombre) {
        List<Usuario> listaUsuarios = leerTodos();
        List<Usuario> listaNombreUsuarios = new ArrayList<>();
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getName().equals(nombre)) {
                listaNombreUsuarios.add(usuario);
            }
        }
        return listaNombreUsuarios;
    }

    @Override
    public List<Usuario> leerTodos() {
        List<Usuario> list = new ArrayList<>();
        String sql = "SELECT * FROM USUARIO";
        try {
            conn = new SQLConnection().openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            int id, age;
            String nombre, password, email;
            while (rs.next()) {
                id = rs.getInt("ID");
                age = rs.getInt("EDAD");
                nombre = rs.getString("NOMBRE");
                password = rs.getString("PASSWORD");
                email = rs.getString("EMAIL");
                Usuario us = new Usuario(email, password, nombre, age);
                us.setId(id);
                list.add(us);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
