package org.sv.ues.igf.controlador;

import java.math.BigDecimal;
import java.util.Date;
import org.sv.ues.igf.*;
import org.sv.ues.igf.dao.TarjetaDAO;
import org.sv.ues.igf.entidades.Tarjeta;




public class CtrlTarjeta {
	private TarjetaDAO daotar = new TarjetaDAO();

	public boolean crearTarjeta(String nombreTarjeta, BigDecimal limiteMinimo,
			BigDecimal limiteMaximo,String Nombre_emisor, Date fechaIngreso, BigDecimal tasaInteres) {
		if (daotar.daTarjetaByNombre(nombreTarjeta) == null) {
			Tarjeta tarjeta = new Tarjeta(nombreTarjeta, limiteMinimo, limiteMaximo,Nombre_emisor ,fechaIngreso, tasaInteres);
			daotar.guardaActualiza(tarjeta);
			return true;
		} else
			return false;
	}

	
	public boolean eliminarTargeta(String nombreTargeta) {
		if (daotar.daTarjetaByNombre(nombreTargeta)!= null) {

			Tarjeta tarjeta = daotar.daTarjetaByNombre(nombreTargeta);
					
			daotar.eliminar(tarjeta);
			return true;
		} else
			return false;
	}
	
	
	//CtrlProveedor crear metodo que devuelva datos por ID(ESTE ES EL METODO CONSULTAR)

	public Tarjeta daTarjetaById(int idTarjeta){
			if(daotar.daTargetaByIdTargeta(idTarjeta) != null){
				Tarjeta buscado = daotar.daTargetaByIdTargeta(idTarjeta);
				return buscado;
			}else{
				return null;			
			}		
		}//fin de metodo daClienteById


	public boolean modificarTargeta(String nombreAntiguo,String nombreTarjeta, BigDecimal limiteMinimo,
			BigDecimal limiteMaximo,String Nombre_emisor, Date fechaIngreso, BigDecimal tasaInteres) {
		if(daotar.daTarjetaByNombre(nombreAntiguo) != null) {
		Tarjeta tarjeta =daotar.daTarjetaByNombre( nombreAntiguo) ;
		
		tarjeta.setNombreTarjeta(nombreTarjeta) ;
		tarjeta.setLimiteMinimo(limiteMinimo) ;
		tarjeta.setLimiteMaximo(limiteMaximo);
		tarjeta.setNombre_emisor(Nombre_emisor) ;
		
		tarjeta.setFechaIngreso(fechaIngreso) ;
		tarjeta.setTasaInteres(tasaInteres) ;
        
                    
		
		daotar.guardaActualiza(tarjeta) ;
		return true ;
		}
		else
		return false ;
		}

	
	
	public Tarjeta daTarjetaByNombre(String nombre) {
		return daotar.daTarjetaByNombre(nombre);
	}
}
