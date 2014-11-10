package org.sv.ues.igf.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.sv.ues.igf.entidades.Tipocliente;
import org.sv.ues.igf.utilidades.HibernateUtil;

public class TipoClienteDAO {
	private HibernateUtil hu = new HibernateUtil();
	private SessionFactory sf;
	private Session s;
	private Transaction tx;

	public void guardar(Tipocliente tipocliente) {
		try {
			iniciarTransaccion();
			s.saveOrUpdate(tipocliente);
			finTransaccion();
		} catch (Exception e) {
			System.err.println(this + "Ocurrio un error " + e.getMessage());
		}
	}

	public boolean borrar(String idTipoCliente) {
		try {
			iniciarTransaccion();
			Tipocliente tipocliente = findByIdTipocliente(idTipoCliente);
			s.delete(tipocliente);
			finTransaccion();
			return true;
		} catch (Exception e) {
			System.err.println(this + "Ocurrio un error " + e.getMessage());
			return false;
		}
	}

	public Tipocliente findById(String idTipoCliente) {
		iniciarSesion();
		Tipocliente tipocliente = findByIdTipocliente(idTipoCliente);
		finSesion();
		return tipocliente;
	}

	public List findByAll() {
		iniciarSesion();
		Query query = s.getNamedQuery("Tipocliente.findByAll");
		List lst = query.list();
		finSesion();
		return lst;
	}

	private Tipocliente findByIdTipocliente(String idTipoCliente) {
		Query query = s.getNamedQuery("Tipocliente.findByIdTipocliente");
		query.setParameter("id", idTipoCliente);
		Tipocliente tipocliente = (Tipocliente) query.uniqueResult();
		return tipocliente;
	}

	private void iniciarTransaccion() {
		sf = hu.getSf();
		s = sf.openSession();
		tx = s.beginTransaction();
	}

	private void finTransaccion() {
		tx.commit();
		s.flush();
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
