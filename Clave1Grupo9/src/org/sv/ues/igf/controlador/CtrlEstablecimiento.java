package org.sv.ues.igf.controlador;


import java.sql.Date;
import java.util.List;
import org.sv.ues.igf.entidades.*;
import org.sv.ues.igf.dao.*;


public class CtrlEstablecimiento {
	private EstablecimientoDAO daoest= new EstablecimientoDAO();
	
	public boolean crearEstablecimiento(String establecimiento,String domicilio, Date fecha, String activo) {
		if (daoest.daEstablecimientoByNombre(establecimiento) == null) {
			Establecimiento est = new Establecimiento(establecimiento,domicilio,fecha,activo);
			daoest.guardaActualiza(est);
			return true;
		} else
			return false;
	}

	public boolean eliminarEstablecimiento(String nombre) {
		if (daoest.daEstablecimientoByNombre(nombre) != null) {
			Establecimiento est = daoest.daEstablecimientoByNombre(nombre);
			daoest.eliminar(est);
			return true;
		} else
			return false;
	}

	public boolean modificarEstablecimiento(String nombreAntiguo, String establecimiento,String domicilio, Date fecha, String activo) {
		if (daoest.daEstablecimientoByNombre(nombreAntiguo) != null) {
			Establecimiento est = daoest.daEstablecimientoByNombre(nombreAntiguo);
			
			est.setEstablecimiento(establecimiento);
			est.setDomicilio(domicilio);
			est.setFechIngreso(fecha);
			est.setActivo(activo);
			daoest.guardaActualiza(est);
			return true;
		} else
			return false;
	}

	public List<Establecimiento> daEstablecimiento() {
		return daoest.daEstablecimiento();
	}

	public Establecimiento daEstablecimientoById(String id) {
		return daoest.daEstablecimientoById(id);
	}

	public Establecimiento daEstablecimientoByNombre(String nombre) {
		return daoest.daEstablecimientoByNombre(nombre);
	}

}
