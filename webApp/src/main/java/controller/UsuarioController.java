/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import service.UsuarioServicelImpl;
import service.IUsuarioService;

/**
 *
 * @author milan
 */
@RequestScoped
@ManagedBean(name = "usuarioController")
public class UsuarioController implements Serializable{
    private IUsuarioService service;
    private Usuario usuario;
    private Usuario selectedUsuario;
    private List<Usuario> listaUsuario;
    
    @PostConstruct
    public void init(){
       service = new UsuarioServicelImpl();
       usuario = new Usuario();
       listaUsuario = service.obtenerRegistros();
    }
    
    public void agregarRegistro() {
        //this.listaRegistros.add(this.nuevoPais)
        service.crearRegistro(usuario);
        listaUsuario = service.obtenerRegistros();
      
        FacesMessage msg = new FacesMessage("Registro creado exitósamente", String.valueOf(1));
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
    }
    
    public void eliminarRegistro(Usuario usuario){
        int idUsuario = usuario.getIdUsuario();
        service.eliminarRegistro(usuario);
        listaUsuario = service.obtenerRegistros();
        FacesMessage msg = new FacesMessage("Registro eliminado exitósamente",String.valueOf(idUsuario));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void onRowEdit(RowEditEvent event){
        Usuario usuario=((Usuario) event.getObject());
        service.actualizarRegistro(usuario);
        FacesMessage mensaje = new FacesMessage("Registro editado exitósamente", String.valueOf(usuario.getIdUsuario()));
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    public void onRowCancel(RowEditEvent event){
        FacesMessage msg = new FacesMessage("Actualización cancelada", String.valueOf(usuario.getIdUsuario()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowSelect(SelectEvent event){
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public IUsuarioService getService() {
        return service;
    }

    public void setService(IUsuarioService service) {
        this.service = service;
    }

    public Usuario getSelectedUsuario() {
        return selectedUsuario;
    }

    public void setSelectedUsuario(Usuario selectedUsuario) {
        this.selectedUsuario = selectedUsuario;
    }
    
    

    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }
    
}
