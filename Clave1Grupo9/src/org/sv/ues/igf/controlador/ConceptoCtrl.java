package org.sv.ues.igf.controlador;

import java.util.List;

import org.sv.ues.igf.dao.ConceptoDAO;
import org.sv.ues.igf.entidades.Concepto;

public class ConceptoCtrl {
	
	private ConceptoDAO dao = new ConceptoDAO();
	
	public void guardar(Concepto concepto){
		dao.guardar(concepto);
	}
	
	public void borrar(int ident){
		dao.borrar(ident);
	}
	
	public Concepto findById(int ident){
		Concepto concepto = dao.findById(ident);
		return concepto;
	}
	
	public List findByAll(){
		List lst = dao.findByAll();
		return lst;
	}
}
