package org.sv.ues.igf.controlador;

import java.util.List;

import org.sv.ues.igf.dao.ClienteDAO;

import org.sv.ues.igf.entidades.Cliente;

public class ClienteCtrl {
	private ClienteDAO dao = new ClienteDAO();

	public boolean guardar(Cliente cliente) {
		boolean existe = false;
		if(dao.findById(cliente.getIdcliente()) != null) {
			existe = true;
		} else {
			dao.guardar(cliente);
		}
		return existe;
	}

	public void borrar(int idCliente) {
		dao.borrar(idCliente);
	}

	public Cliente findById(int idCliente) {
		Cliente cliente = dao.findById(idCliente);
		return cliente;
	}

	public List findByAll() {
		List lst = dao.findByAll();
		return lst;
	}
}
