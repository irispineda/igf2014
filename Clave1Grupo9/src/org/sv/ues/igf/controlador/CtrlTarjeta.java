package org.sv.ues.igf.controlador;

import java.math.BigDecimal;
import java.util.Date;
import org.sv.ues.igf.entidades.Tarjeta;
import org.sv.ues.igf.dao.TarjetaDAO;




public class CtrlTarjeta {
	private TarjetaDAO daoDepto = new TarjetaDAO();

	public boolean crearTarjeta(String nombreTarjeta, BigDecimal limiteMinimo,
			BigDecimal limiteMaximo,String Nombre_emisor, Date fechaIngreso, BigDecimal tasaInteres) {
		if (daoDepto.daTarjetaByNombre(nombreTarjeta) == null) {
			Tarjeta tarjeta = new Tarjeta(nombreTarjeta, limiteMinimo, limiteMaximo,Nombre_emisor ,fechaIngreso, tasaInteres);
			daoDepto.guardaActualiza(tarjeta);
			return true;
		} else
			return false;
	}

	
	public boolean eliminarTargeta(String nombreTargeta) {
		if (daoDepto.daTarjetaByNombre(nombreTargeta) != null) {

			Tarjeta tarjeta = daoDepto.daTarjetaByNombre(nombreTargeta);
					
			daoDepto.eliminar(tarjeta);
			return true;
		} else
			return false;
	}
	
	
	//CtrlProveedor crear metodo que devuelva datos por ID(ESTE ES EL METODO CONSULTAR)

	public Tarjeta daTarjetaById(int idTarjeta){
			if(daoDepto.daTargetaByIdTargeta(idTarjeta) != null){
				Tarjeta buscado = daoDepto.daTargetaByIdTargeta(idTarjeta);
				return buscado;
			}else{
				return null;			
			}		
		}//fin de metodo daClienteById


	public boolean modificarTargeta(String nombreAntiguo,String nombreTarjeta, BigDecimal limiteMinimo,
			BigDecimal limiteMaximo,String Nombre_emisor, Date fechaIngreso, BigDecimal tasaInteres) {
		if(daoDepto.daTarjetaByNombre(nombreAntiguo) != null) {
		Tarjeta tarjeta =daoDepto.daTarjetaByNombre( nombreAntiguo) ;
		
		tarjeta.setNombreTarjeta(nombreTarjeta) ;
		tarjeta.setLimiteMinimo(limiteMinimo) ;
		tarjeta.setLimiteMaximo(limiteMaximo);
		tarjeta.setNombre_emisor(Nombre_emisor) ;
		
		tarjeta.setFechaIngreso(fechaIngreso) ;
		tarjeta.setTasaInteres(tasaInteres) ;
        
                    
		
		daoDepto.guardaActualiza(tarjeta) ;
		return true ;
		}
		else
		return false ;
		}

	
	
	public Tarjeta daTarjetaByNombre(String nombre) {
		return daoDepto.daTarjetaByNombre(nombre);
	}
}
