package org.sv.ues.igf.controlador;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.sv.ues.igf.dao.TransaccionDAO;
import org.sv.ues.igf.entidades.Cliente;
import org.sv.ues.igf.entidades.Clientetarjetaestado;
import org.sv.ues.igf.entidades.Concepto;
import org.sv.ues.igf.entidades.Pais;
import org.sv.ues.igf.entidades.Tarjetacredito;
import org.sv.ues.igf.entidades.Transaccion;

public class TransaccionCtrl {
	
	private TransaccionDAO dao = new TransaccionDAO();
	
	public void guardar(Transaccion transaccion){
		dao.guardar(transaccion);
	}
	
	public void borrar(int ident){
		dao.borrar(ident);
	}
	
	public Transaccion findById(int ident){
		Transaccion transaccion = dao.findById(ident);
		return transaccion;
	}
	
	public List findByAll(){
		List lst = dao.findByAll();
		return lst;
	}

	public Tarjetacredito findTarjeta(int ident){
		return dao.findTarjeta(ident);
	}
	
	public List findAllTarjetas(){
		return dao.findAllTarjetas();
	}
	
	public Cliente findCliente(int ident){
		return dao.findCliente(ident);
	}
	
	public List findAllClientes(){
		return dao.findAllClientes();
	}
	
	public Pais findPais(int ident){
		return dao.findPais(ident);
	}
	
	public List findAllPaises(){
		return dao.findAllPaises();
	}
	
	public Concepto findConcepto(int ident){
		return dao.findConcepto(ident);
	}
	
	public List findAllConceptos(){
		return dao.findAllConceptos();
	}
	
	public Clientetarjetaestado findClienteTarjetaEstado(Tarjetacredito tarjeta, Cliente cliente, Date fecha){
		return dao.findClienteTarjetaEstado(tarjeta, cliente, fecha);
	}
	
	public List findClienteTarjetaEstado(){
		return dao.findClienteTarjetaEstado();
	}
}
