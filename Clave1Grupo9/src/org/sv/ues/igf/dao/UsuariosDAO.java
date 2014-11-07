package org.sv.ues.igf.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.sv.ues.igf.entidades.Usuarios;
import org.sv.ues.igf.utilidades.HibernateUtil;

public class UsuariosDAO {
	private HibernateUtil hu = new HibernateUtil();
	private SessionFactory sf;
	private Session s;
	private Transaction tx;
	
	public void guardar(Usuarios usuarios){
		try{
			iniciarTransaccion();
			s.saveOrUpdate(usuarios);
			finTransaccion();
		}catch(Exception e){
			System.err.println(this+"Ocurrio un error "+e.getMessage());
		}
	}
	
	public void borrar(int ident){
		try{
			iniciarTransaccion();
			Usuarios usuarios = findByIdUsuarios(ident);
			s.delete(usuarios);
			finTransaccion();
		}catch(Exception e){
			System.err.println(this+"Ocurrio un error "+e.getMessage());
		}
	}
	
	public Usuarios findById(int ident){
		iniciarSesion();
		Usuarios usuarios = findByIdUsuarios(ident);
		finSesion();
		return usuarios;
	}
	
	public List findByAll(){
		iniciarSesion();
		Query query = s.getNamedQuery("Usuarios.findByAll");
		List lst = query.list();
		finSesion();
		return lst;
	}
	
	private Usuarios findByIdUsuarios(int ident){
		Query query = s.getNamedQuery("Usuarios.findById");
		query.setParameter("id",ident);
		Usuarios usuarios = (Usuarios) query.uniqueResult();
		return usuarios;
	}
	
	public Usuarios findByUsuarioPassword(String usuario, String password){
		iniciarSesion();
		Query query = s.getNamedQuery("Usuarios.findByUsuarioPassword");
		query.setParameter("usuario",usuario);
		query.setParameter("pass",password);
		Usuarios usuarios = (Usuarios) query.uniqueResult();
		finSesion();
		return usuarios;
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
