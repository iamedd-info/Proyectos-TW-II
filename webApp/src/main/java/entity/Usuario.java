/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author milan
 */
@Entity
@Table(name="usuario")
public class Usuario implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario", nullable = false)
    private int idUsuario;
    
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    
        @Column(name = "apellido", nullable = true, length = 50)
    private String apellido;

    public Usuario(int idUsuario, String nombre, String apellido) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    

    public Usuario() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idFramework) {
        this.idUsuario = idFramework;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
        public String getapellido() {
        return apellido;
    }

    public void setapellido(String apellido) {
        this.apellido = apellido;
    }
    
}
