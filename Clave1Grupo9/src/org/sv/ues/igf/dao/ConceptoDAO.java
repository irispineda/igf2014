package org.sv.ues.igf.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.sv.ues.igf.entidades.Concepto;
import org.sv.ues.igf.utilidades.HibernateUtil;

public class ConceptoDAO {
	private HibernateUtil hu = new HibernateUtil();
	private SessionFactory sf;
	private Session s;
	private Transaction tx;
	
	public void guardar(Concepto concepto){
		try{
			iniciarTransaccion();
			s.saveOrUpdate(concepto);
			finTransaccion();
		}catch(Exception e){
			System.err.println(this+"Ocurrio un error "+e.getMessage());
		}
	}
	
	public void borrar(int ident){
		try{
			iniciarTransaccion();
			Concepto concepto = findByIdConcepto(ident);
			s.delete(concepto);
			finTransaccion();
		}catch(Exception e){
			System.err.println(this+"Ocurrio un error "+e.getMessage());
		}
	}
	
	public Concepto findById(int ident){
		iniciarSesion();
		Concepto concepto = findByIdConcepto(ident);
		finSesion();
		return concepto;
	}
	
	public List findByAll(){
		iniciarSesion();
		Query query = s.getNamedQuery("Concepto.findByAll");
		List lst = query.list();
		finSesion();
		return lst;
	}
	
	private Concepto findByIdConcepto(int ident){
		Query query = s.getNamedQuery("Concepto.findByIdConcepto");
		query.setParameter("id",ident);
		Concepto concepto = (Concepto) query.uniqueResult();
		return concepto;
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
