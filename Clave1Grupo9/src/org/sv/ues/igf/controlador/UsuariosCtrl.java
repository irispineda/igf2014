package org.sv.ues.igf.controlador;

import java.util.List;

import org.sv.ues.igf.dao.UsuariosDAO;
import org.sv.ues.igf.entidades.Usuarios;

public class UsuariosCtrl {
	
	private UsuariosDAO dao = new UsuariosDAO();
	
	public void guardar(Usuarios usuarios){
		dao.guardar(usuarios);
	}
	
	public void borrar(int ident){
		dao.borrar(ident);
	}
	
	public Usuarios findById(int ident){
		Usuarios usuarios = dao.findById(ident);
		return usuarios;
	}
	
	public List findByAll(){
		List lst = dao.findByAll();
		return lst;
	}
	
	public Boolean validaUsuario(String usuario, String password){
		Usuarios usuarios = dao.findByUsuarioPassword(usuario, password);
		if (usuarios==null) return false;
		return true;
	}
}
