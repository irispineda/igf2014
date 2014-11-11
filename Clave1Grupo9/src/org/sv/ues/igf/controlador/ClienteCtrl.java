package org.sv.ues.igf.controlador;

import java.util.List;

import org.sv.ues.igf.dao.ClienteDAO;

import org.sv.ues.igf.entidades.Cliente;

public class ClienteCtrl {
	private ClienteDAO dao = new ClienteDAO();

	public boolean guardar(Cliente cliente) {
		return dao.guardar(cliente);
	}

	public boolean borrar(int idCliente) {
		return dao.borrar(idCliente);
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
