/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


@Named(value = "ctrlIMC")
@RequestScoped
public class CtrlIMC {
    
    private double peso;
    private double altura;
    
    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

  
  public void calcular() {
    
    final double imc = getPeso() / Math.pow(getAltura(), 2) ;
    String mensaje= " " + String.valueOf(imc);
    
    if (imc < 18.5){
        mensaje += "\n Abajo de lo normal " ;
    }
    else if (imc >= 18.5 && imc <= 24.9 ){
        mensaje += "\n Normal";
    }
    else if (imc >= 25.0 && imc <= 29.9 ){
        mensaje += "\n Superior al normal";
    }
    else if (imc > 30.0){
        mensaje += "\n Obesidad";
    }
    
    
    FacesContext.getCurrentInstance()
    .addMessage(null, new FacesMessage(mensaje));
    
    
  }
}
