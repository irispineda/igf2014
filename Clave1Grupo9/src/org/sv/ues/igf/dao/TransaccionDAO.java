package org.sv.ues.igf.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.sv.ues.igf.entidades.Transaccion;
import org.sv.ues.igf.utilidades.HibernateUtil;

public class TransaccionDAO {
	private HibernateUtil hu = new HibernateUtil();
	private SessionFactory sf;
	private Session s;
	private Transaction tx;
	
	public void guardar(Transaccion transaccion){
		try{
			iniciarTransaccion();
			s.saveOrUpdate(transaccion);
			finTransaccion();
		}catch(Exception e){
			System.err.println(this+"Ocurrio un error "+e.getMessage());
		}
	}
	
	public void borrar(int ident){
		try{
			iniciarTransaccion();
			Transaccion transaccion = findByIdTransaccion(ident);
			s.delete(transaccion);
			finTransaccion();
		}catch(Exception e){
			System.err.println(this+"Ocurrio un error "+e.getMessage());
		}
	}
	
	public Transaccion findById(int ident){
		iniciarSesion();
		Transaccion transaccion = findByIdTransaccion(ident);
		finSesion();
		return transaccion;
	}
	
	public List findByAll(){
		iniciarSesion();
		Query query = s.getNamedQuery("Transaccion.findByAll");
		List lst = query.list();
		finSesion();
		return lst;
	}
	
	private Transaccion findByIdTransaccion(int ident){
		Query query = s.getNamedQuery("Transaccion.findByIdTransaccion");
		query.setParameter("id",ident);
		Transaccion transaccion = (Transaccion) query.uniqueResult();
		return transaccion;
	}
	
	private void iniciarTransaccion(){
		sf = hu.getSf();
		s = sf.openSession();
		tx = s.beginTransaction();
	}
	
	private void finTransaccion(){
		tx.commit();
		s.flush();
		s.close();
	}
	
	private void iniciarSesion(){
		sf = hu.getSf();
		s = sf.openSession();
	}
	
	private void finSesion(){
		s.flush();
		s.close();
	}
}
