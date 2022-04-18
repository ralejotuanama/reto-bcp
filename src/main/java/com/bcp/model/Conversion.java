package com.bcp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "conversion")
public class Conversion {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
    private int conversionId;
    private int monto;
    private double montocontipocambio;
    private String monedaorigen;
    private String monedadestino;
    private double tipocambio;
    private String usuarioLogueado;


    

public String getUsuarioLogueado() {
		return usuarioLogueado;
	}
	public void setUsuarioLogueado(String usuarioLogueado) {
		this.usuarioLogueado = usuarioLogueado;
	}
public int getConversionId() {
	return conversionId;
}
public void setConversionId(int conversionId) {
	this.conversionId = conversionId;
}


public int getMonto() {
	return monto;
}
public void setMonto(int monto) {
	this.monto = monto;
}
public double getMontocontipocambio() {
	return montocontipocambio;
}
public void setMontocontipocambio(double montocontipocambio) {
	this.montocontipocambio = montocontipocambio;
}
public String getMonedaorigen() {
	return monedaorigen;
}
public void setMonedaorigen(String monedaorigen) {
	this.monedaorigen = monedaorigen;
}
public String getMonedadestino() {
	return monedadestino;
}
public void setMonedadestino(String monedadestino) {
	this.monedadestino = monedadestino;
}
public double getTipocambio() {
	return tipocambio;
}
public void setTipocambio(double tipocambio) {
	this.tipocambio = tipocambio;
}





	
	
	

}
