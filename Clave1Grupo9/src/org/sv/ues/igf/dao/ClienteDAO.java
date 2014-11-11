package org.sv.ues.igf.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.sv.ues.igf.entidades.Cliente;
import org.sv.ues.igf.utilidades.HibernateUtil;

public class ClienteDAO {
	private HibernateUtil hu = new HibernateUtil();
	private SessionFactory sf;
	private Session s;
	private Transaction tx;

	public boolean guardar(Cliente cliente) {
		try {
			iniciarTransaccion();
			s.saveOrUpdate(cliente);
			finTransaccion();
			return true;
		} catch (Exception e) {
			System.err.println(this + "Ocurrio un error " + e.getMessage());
			return false;
		}
	}

	public boolean borrar(int idCliente) {
		try {
			iniciarTransaccion();
			Cliente cliente = findByIdCliente(idCliente);
			s.delete(cliente);
			finTransaccion();
			return true;
		} catch (Exception e) {
			System.err.println(this + "Ocurrio un error " + e.getMessage());
			return false;
		}
	}

	public Cliente findById(int idCliente) {
		iniciarSesion();
		Cliente cliente = findByIdCliente(idCliente);
		finSesion();
		return cliente;
	}

	public List findByAll() {
		iniciarSesion();
		Query query = s.getNamedQuery("Cliente.findByAll");
		List lst = query.list();
		finSesion();
		return lst;
	}

	private Cliente findByIdCliente(int idCliente) {
		Query query = s.getNamedQuery("Cliente.findByIdCliente");
		query.setParameter("id", idCliente);
		Cliente concepto = (Cliente) query.uniqueResult();
		return concepto;
	}

	private void iniciarTransaccion() {
		sf = hu.getSf();
		s = sf.openSession();
		tx = s.beginTransaction();
	}

	private void finTransaccion() {
		s.flush();
		tx.commit();
		s.close();
	}

	private void iniciarSesion() {
		sf = hu.getSf();
		s = sf.openSession();
	}

	private void finSesion() {
		s.flush();
		s.close();
	}
}
