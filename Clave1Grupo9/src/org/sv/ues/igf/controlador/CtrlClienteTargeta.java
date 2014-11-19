package org.sv.ues.igf.controlador;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.sv.ues.igf.dao.ClienteTargetaDAO;
import org.sv.ues.igf.entidades.Cliente;
import org.sv.ues.igf.entidades.Clientetarjeta;
import org.sv.ues.igf.entidades.ClientetarjetaId;
import org.sv.ues.igf.entidades.Tarjeta;
import org.sv.ues.igf.entidades.Tarjetacredito;
import org.sv.ues.igf.utilidades.HibernateUtil;

import java.math.BigDecimal;
import java.util.Date;





public class CtrlClienteTargeta {
	private ClienteTargetaDAO daoDepto = new ClienteTargetaDAO();

	public boolean crearClienteTargeta(int idtarjetacredito, int idcliente, Tarjetacredito tarjetacredito, Cliente cliente, Date fechaEmision, BigDecimal limiteCredito, Integer puntosTarjeta) {
		if (daoDepto.daClienteTargetaById(idtarjetacredito, idcliente)!=null) {
			ClientetarjetaId id = new ClientetarjetaId(idtarjetacredito, idcliente);
			Clientetarjeta clientetarjeta = new Clientetarjeta(id, tarjetacredito, cliente, fechaEmision, limiteCredito, puntosTarjeta);
			return true;
		} else
			return false;
	}

	
	public boolean eliminarClienteTargeta(Date Fecha_Emision) {
		if (daoDepto.daClienteTargetaByNombre(Fecha_Emision) != null) {

			Clientetarjeta cliente = daoDepto.daClienteTargetaByNombre(Fecha_Emision);
					
			daoDepto.eliminar(cliente);
			return true;
		} else
			return false;
	}

    //fin de metodo daClienteById
	public boolean modificarClienteTargeta(Date fecha_Emision, BigDecimal limite_credito,
			Integer puntos_targeta) {
		if(daoDepto.daClienteTargetaByNombre(fecha_Emision) != null) {
		Clientetarjeta tarjeta =daoDepto.daClienteTargetaByNombre(fecha_Emision) ;
		tarjeta.setFechaEmision(fecha_Emision) ;
		tarjeta.setLimiteCredito(limite_credito);
		tarjeta.setPuntosTarjeta(puntos_targeta);
                    
		
		daoDepto.guardaActualiza(tarjeta) ;
		return true ;
		}
		else
		return false ;
	}

}
