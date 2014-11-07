package org.sv.ues.igf.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.sv.ues.igf.entidades.Clientetarjetaestado;
import org.sv.ues.igf.entidades.ClientetarjetaestadoId;
import org.sv.ues.igf.entidades.Concepto;
import org.sv.ues.igf.utilidades.HibernateUtil;

public class ClienteTarjetaEstadoDAO {
	private HibernateUtil hu = new HibernateUtil();
	private SessionFactory sf;
	private Session s;
	private Transaction tx;
	
	public void guardar(Clientetarjetaestado clienteTarjetaEstado){
		try{
			iniciarTransaccion();
			s.saveOrUpdate(clienteTarjetaEstado);
			finTransaccion();
		}catch(Exception e){
			System.err.println(this+"Ocurrio un error "+e.getMessage());
		}
	}
	
	public void borrar(int idtarjetacredito){
		try{
			iniciarTransaccion();
			Clientetarjetaestado Clientetarjetaestado = findByIdClienteTarjetaEstado(idtarjetacredito);
			s.delete(Clientetarjetaestado);
			finTransaccion();
		}catch(Exception e){
			System.err.println(this+"Ocurrio un error "+e.getMessage());
		}
	}
	
	public Clientetarjetaestado findById(int idtarjetacredito){
		iniciarSesion();
		Clientetarjetaestado Clientetarjetaestado = findByIdClienteTarjetaEstado(idtarjetacredito);
		finSesion();
		return Clientetarjetaestado;
	}
	
	public List findByAll(){
		iniciarSesion();
		Query query = s.getNamedQuery("Clientetarjetaestado.findByAll");
		List lst = query.list();
		finSesion();
		return lst;
	}
	
	private Clientetarjetaestado findByIdClienteTarjetaEstado(int idtarjetacredito){
		Query query = s.getNamedQuery("Clientetarjetaestado.findByIdClienteTarjetaEstado");
		query.setParameter("id",idtarjetacredito);
		Clientetarjetaestado Clientetarjetaestado = (Clientetarjetaestado) query.uniqueResult();
		return Clientetarjetaestado;
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
