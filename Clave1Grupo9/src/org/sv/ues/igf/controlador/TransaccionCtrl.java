package org.sv.ues.igf.controlador;

import java.util.List;

import org.sv.ues.igf.dao.TransaccionDAO;
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
}
