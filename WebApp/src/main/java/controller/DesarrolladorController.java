/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Desarrollador;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import service.DesarrolladorServicelImpl;
import service.IDesarrolladorService;

/**
 *
 * @author milan
 */
@RequestScoped
@ManagedBean(name = "desarrolladorController")
public class DesarrolladorController implements Serializable{
    private IDesarrolladorService serviceD;
    private Desarrollador desarrollador;
    private Desarrollador selectedDesarrollador;
    private List<Desarrollador> listaDesarrollador;
    
    @PostConstruct
    public void init(){
       serviceD = new DesarrolladorServicelImpl();
       desarrollador = new Desarrollador();
       listaDesarrollador = serviceD.obtenerRegistros();
        System.out.println(listaDesarrollador.size());
    }
    
    public static void main(String[] args) {
        DesarrolladorController c = new DesarrolladorController();
        c.init();
        System.out.println("Tamaño "+c.listaDesarrollador.size());
    }
    public void agregarRegistro() {
        //this.listaRegistros.add(this.nuevoPais)
        serviceD.crearRegistro(desarrollador);
        listaDesarrollador = serviceD.obtenerRegistros();
      
        FacesMessage msg = new FacesMessage("Registro creado exitósamente", desarrollador.getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
    }
    
    public void eliminarRegistro(Desarrollador desarrollador){
        int idDesarrollador = desarrollador.getIdDesarrollador();
        serviceD.eliminarRegistro(desarrollador);
        listaDesarrollador = serviceD.obtenerRegistros();
        FacesMessage msg = new FacesMessage("Registro eliminado exitósamente",String.valueOf(idDesarrollador));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void onRowEdit(RowEditEvent event){
        Desarrollador desarrollador=((Desarrollador) event.getObject());
        serviceD.actualizarRegistro(desarrollador);
        FacesMessage mensaje = new FacesMessage("Registro editado exitósamente", String.valueOf(desarrollador.getIdDesarrollador()));
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    public void onRowCancel(RowEditEvent event){
        FacesMessage msg = new FacesMessage("Actualización cancelada", String.valueOf(desarrollador.getIdDesarrollador()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowSelect(SelectEvent event){
    }

    public Desarrollador getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(Desarrollador desarrollador) {
        this.desarrollador = desarrollador;
    }

    public IDesarrolladorService getService() {
        return serviceD;
    }

    public void setService(IDesarrolladorService serviceD) {
        this.serviceD = serviceD;
    }

    public Desarrollador getSelectedDesarrollador() {
        return selectedDesarrollador;
    }

    public void setSelectedDesarrollador(Desarrollador selectedDesarrollador) {
        this.selectedDesarrollador = selectedDesarrollador;
    }
    
    

    public List<Desarrollador> getListaDesarrollador() {
        return listaDesarrollador;
    }

    public void setListaDesarrollador(List<Desarrollador> listaDesarrollador) {
        this.listaDesarrollador = listaDesarrollador;
    }
    
}
