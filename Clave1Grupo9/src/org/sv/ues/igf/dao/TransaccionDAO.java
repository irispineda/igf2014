package org.sv.ues.igf.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.sv.ues.igf.entidades.*;
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
	
	public Tarjetacredito findTarjeta(int ident){
		iniciarSesion();
		Criteria crt = s.createCriteria(Tarjetacredito.class);
		crt.add(Restrictions.eq("idtarjetacredito", ident));
		Tarjetacredito tarjeta = (Tarjetacredito) crt.uniqueResult();
		finSesion();
		return tarjeta;
	}
	
	public List findAllTarjetas(){
		iniciarSesion();
		Criteria crt = s.createCriteria(Tarjetacredito.class);
		List lst = crt.list();
		finSesion();
		return lst;
	}
	
	public Cliente findCliente(int ident){
		iniciarSesion();
		Criteria crt = s.createCriteria(Cliente.class);
		crt.add(Restrictions.eq("idcliente", ident));
		Cliente cliente = (Cliente) crt.uniqueResult();
		finSesion();
		return cliente;
	}
	
	public List findAllClientes(){
		iniciarSesion();
		Criteria crt = s.createCriteria(Cliente.class);
		List lst = crt.list();
		finSesion();
		return lst;
	}
	
	public Pais findPais(int ident){
		iniciarSesion();
		Criteria crt = s.createCriteria(Pais.class);
		crt.add(Restrictions.eq("idpais", ident));
		Pais pais = (Pais) crt.uniqueResult();
		finSesion();
		return pais;
	}
	
	public List findAllPaises(){
		iniciarSesion();
		Criteria crt = s.createCriteria(Pais.class);
		List lst = crt.list();
		finSesion();
		return lst;
	}
	
	public Concepto findConcepto(int ident){
		iniciarSesion();
		Criteria crt = s.createCriteria(Concepto.class);
		crt.add(Restrictions.eq("idconcepto", ident));
		Concepto concepto = (Concepto) crt.uniqueResult();
		finSesion();
		return concepto;
	}
	
	public List findAllConceptos(){
		iniciarSesion();
		Criteria crt = s.createCriteria(Concepto.class);
		List lst = crt.list();
		finSesion();
		return lst;
	}
	
	public Clientetarjetaestado findClienteTarjetaEstado(Tarjetacredito tarjeta, Cliente cliente, Date fecha){
		iniciarSesion();
		Criteria crt = s.createCriteria(Clientetarjetaestado.class);
		crt.add(Restrictions.eq("Tarjetacredito", tarjeta));
		crt.add(Restrictions.eq("Cliente", cliente));
		crt.add(Restrictions.eq("fecha", fecha));
		Clientetarjetaestado cliTarEst = (Clientetarjetaestado) crt.uniqueResult();
		finSesion();
		return cliTarEst;
	}
	
	public List findClienteTarjetaEstado(){
		iniciarSesion();
		Criteria crt = s.createCriteria(Clientetarjetaestado.class);
		List lst = crt.list();
		finSesion();
		return lst;
	}
}
