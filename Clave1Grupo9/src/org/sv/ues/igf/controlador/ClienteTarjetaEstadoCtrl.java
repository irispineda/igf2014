package org.sv.ues.igf.controlador;

import java.util.List;

import org.sv.ues.igf.dao.ClienteTarjetaEstadoDAO;
import org.sv.ues.igf.dao.ConceptoDAO;
import org.sv.ues.igf.entidades.Clientetarjetaestado;
import org.sv.ues.igf.entidades.ClientetarjetaestadoId;
import org.sv.ues.igf.entidades.Concepto;

public class ClienteTarjetaEstadoCtrl {
private ClienteTarjetaEstadoDAO  dao = new ClienteTarjetaEstadoDAO ();
	
public void guardar(Clientetarjetaestado clienteTarjetaEstado){
		dao.guardar(clienteTarjetaEstado);
	}
	
	public void borrar(int idtarjetacredito ){
		dao.borrar(idtarjetacredito);
	}
	
	public Clientetarjetaestado findById(int idtarjetacredito){
		Clientetarjetaestado Clientetarjetaestado = dao.findById(idtarjetacredito);
		return Clientetarjetaestado;
	}
	
	public List findByAll(){
		List lst = dao.findByAll();
		return lst;
	}
}

