package org.sv.ues.igf.controlador;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

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
	
	public byte[] reporte(){
		byte[] bytes = null;
		try {
			String path = "C:\\Proyectos\\IGF\\trunk\\Clave1Grupo9\\WebContent\\Concepto\\Report.jrxml";
			File f = new File(path);
			JasperDesign disenioReporte = JRXmlLoader.load(path);
			JasperReport report = JasperCompileManager.compileReport(disenioReporte);
			bytes = JasperRunManager.runReportToPdf(report, new HashMap(), dao.obtenerConexion());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bytes;
	}
}
