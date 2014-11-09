package org.sv.ues.igf.dao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.sv.ues.igf.entidades.ClienteTargeta;
import org.sv.ues.igf.utilidades.HibernateUtil;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;





public class ClienteTargetaDAO {
	private HibernateUtil hibernateUtil = new HibernateUtil();
	private SessionFactory sessionFactory =hibernateUtil.getSessionFactory();
	private Session sesion;
	private Transaction tx;

	private void iniciaOperacion() throws HibernateException {
		sesion = sessionFactory.openSession();
		tx = sesion.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he)
			throws HibernateException {
		tx.rollback();
		throw new HibernateException("Ocurrió un error en la capa DAO", he);
	}

	public void guardaActualiza(ClienteTargeta cliente) {
		try {
			iniciaOperacion();
			sesion.saveOrUpdate(cliente);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}

	
	public void eliminar(ClienteTargeta cliente) {
		try {
			iniciaOperacion();
			sesion.delete(cliente);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}

	public ClienteTargeta daclienteByIdPro(int id) {
		sesion = sessionFactory.openSession();
		Query query = sesion.getNamedQuery("ClienteTargeta.findByIdPro");
		query.setParameter("idcliente", id);
		ClienteTargeta cliente = (ClienteTargeta) query.uniqueResult();
		sesion.close();
		return cliente;
	}
	public ClienteTargeta daClienteTargetaById(int idCliente){
		sesion = sessionFactory.openSession() ;
		// Retorna la instancia persistente de la clase por medio del
		
		ClienteTargeta id = (ClienteTargeta) sesion.get(ClienteTargeta.class,
		new Integer(idCliente)) ;
		sesion.close() ;
		return id ;
		}
	
	public ClienteTargeta daClienteTargetaByNombre(Date nombre) {
		sesion = sessionFactory.openSession();
		Query query = sesion.getNamedQuery("ClienteTar.findByNombre");
		query.setParameter("Fecha_Emision", nombre);
		ClienteTargeta targeta = (ClienteTargeta) query.uniqueResult();
		sesion.close();
		return targeta;
	}
}
