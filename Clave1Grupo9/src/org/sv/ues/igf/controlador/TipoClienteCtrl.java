package org.sv.ues.igf.controlador;

import java.util.List;

import org.sv.ues.igf.dao.TipoClienteDAO;
import org.sv.ues.igf.entidades.Tipocliente;

public class TipoClienteCtrl {
	private TipoClienteDAO dao = new TipoClienteDAO();
	
	public TipoClienteCtrl() {
	}

	public boolean guardar(Tipocliente tipoCliente) {
		boolean existe = false;
		if(dao.findById(tipoCliente.getIdtipocliente()) != null) {
			existe = true;
		} else {
			dao.guardar(tipoCliente);
		}
		return existe;
	}

	public void borrar(String idTipoCliente) {
		dao.borrar(idTipoCliente);
	}

	public Tipocliente findById(String idTipoCliente) {
		Tipocliente tipocliente = dao.findById(idTipoCliente);
		return tipocliente;
	}

	public List findByAll() {
		List lst = dao.findByAll();
		return lst;
	}
}
