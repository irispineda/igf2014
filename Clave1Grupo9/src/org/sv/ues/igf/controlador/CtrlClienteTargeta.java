package org.sv.ues.igf.controlador;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.sv.ues.igf.dao.ClienteTargetaDAO;
import org.sv.ues.igf.entidades.ClienteTargeta;
import org.sv.ues.igf.entidades.Tarjeta;
import org.sv.ues.igf.utilidades.HibernateUtil;

import java.math.BigDecimal;
import java.util.Date;





public class CtrlClienteTargeta {
	private ClienteTargetaDAO daoDepto = new ClienteTargetaDAO();

	public boolean crearClienteTargeta(int id,Date Fecha_Emision ,BigDecimal Puntos_targeta, BigDecimal Limite_credito) {
		if (daoDepto.daClienteTargetaById(id)!=null) {
			ClienteTargeta cliente= new ClienteTargeta(id,Fecha_Emision,Puntos_targeta,Limite_credito);
			daoDepto.guardaActualiza(cliente);
			return true;
		} else
			return false;
	}

	
	public boolean eliminarClienteTargeta(Date Fecha_Emision) {
		if (daoDepto.daClienteTargetaByNombre(Fecha_Emision) != null) {

			ClienteTargeta cliente = daoDepto.daClienteTargetaByNombre(Fecha_Emision);
					
			daoDepto.eliminar(cliente);
			return true;
		} else
			return false;
	}
	public ClienteTargeta daClienteTargetaById(int idCliente){
		if(daoDepto.daClienteTargetaById(idCliente) != null){
			ClienteTargeta buscado = daoDepto.daClienteTargetaById(idCliente);
			return buscado;
		}else{
			return null;			
		}		
	}//fin de metodo daClienteById
	public boolean modificarClienteTargeta(Date fecha_Emision, BigDecimal limite_credito,
			BigDecimal puntos_targeta) {
		if(daoDepto.daClienteTargetaByNombre(fecha_Emision) != null) {
		ClienteTargeta tarjeta =daoDepto.daClienteTargetaByNombre(fecha_Emision) ;
		tarjeta.setFecha_Emision(fecha_Emision) ;
		tarjeta.setLimite_credito(limite_credito);
		tarjeta.setPuntos_credito(puntos_targeta);
                    
		
		daoDepto.guardaActualiza(tarjeta) ;
		return true ;
		}
		else
		return false ;
		}


	
	public ClienteTargeta daClienteTarByid(int id) {
		return daoDepto.daClienteTargetaById(id);
	}
}
