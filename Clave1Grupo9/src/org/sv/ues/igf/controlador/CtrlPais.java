package org.sv.ues.igf.controlador;

import java.util.List;
import org.sv.ues.igf.entidades.Pais;
import org.sv.ues.igf.dao.PaisDAO;




public class CtrlPais {
	private PaisDAO paisdao = new PaisDAO();
	
	//aqui biene el error
	public boolean crearPais(String nombrePais) {
		if (paisdao.daPaisByNombre(nombrePais) == null) {
			Pais pais = new Pais(nombrePais);
			paisdao.guardaActualiza(pais);// va a pais dao
			return true;
		} else
			return false;
	}
	
	public boolean eliminarPais(String nombrePais) {
		if (paisdao.daPaisByNombre(nombrePais) != null) {
			Pais pais = paisdao.daPaisByNombre(nombrePais);
			paisdao.eliminar(pais);
			return true;
		} else
			return false;
	}
	
	public boolean modificarPais(String nombreAntiguo, String nombrePais) {
		/*if (paisdao.daPaisByNombre(nombrePais) != null) {
			Pais pais = paisdao.daPaisByNombre(nombrePais);
			paisdao.guardaActualiza(pais);
			return true;
		} else
			return false;*/
		if (paisdao.daPaisByNombre(nombreAntiguo)!= null) {
			Pais pais = paisdao.daPaisByNombre(nombreAntiguo);
			pais.setNombrePais(nombrePais);
			paisdao.guardaActualiza(pais);
			return true;
		} else
			return false;
	}
	
	public List<Pais> daPais() {
		return paisdao.daPais();
	}
	
	public Pais daPaisById(short idpais) {
		return paisdao.daPaisById(idpais);
	}
	public Pais daPaisByNombre(String nombre) {
		return paisdao.daPaisByNombre(nombre);
	}

}
