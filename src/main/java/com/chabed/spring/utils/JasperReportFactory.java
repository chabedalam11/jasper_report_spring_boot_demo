package com.chabed.spring.utils;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;


import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

public class JasperReportFactory {
	
	public void openReport(String fileName,HashMap<String,Object> hmParams,HttpServletResponse response) {
		 Connection conn = new DBUtils().getDBConnection();
	     JasperReport jasperReport =getCompiledFile(fileName);
	     try {
			generateReportPDF(response, hmParams, jasperReport, conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public JasperReport getCompiledFile(String fileName){
		try {
			File reportFile = new File(System.getProperty("user.dir") + "\\"+fileName+".jasper");
	        // If compiled file is not found, then compile XML template
	        if (!reportFile.exists()) {
	        	JasperCompileManager.compileReportToFile(
						System.getProperty("user.dir") + "\\"+fileName+".jrxml",
						System.getProperty("user.dir") + "\\"+fileName+".jasper"
					);
	            }
	        JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(reportFile.getPath());
	        System.out.println("done2");  
	        return jasperReport;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private void generateReportPDF (HttpServletResponse resp, Map<String, Object> parameters, JasperReport jasperReport, Connection conn)throws JRException, NamingException, SQLException, IOException {
        byte[] bytes = null;
        bytes = JasperRunManager.runReportToPdf(jasperReport,parameters,conn);
        resp.reset();
        resp.resetBuffer();
        resp.setContentType("application/pdf");
        resp.setContentLength(bytes.length);
        ServletOutputStream ouputStream = resp.getOutputStream();
        ouputStream.write(bytes, 0, bytes.length);
        ouputStream.flush();
    }
	
	
	/*private void generateReportHtml( JasperPrint jasperPrint, HttpServletRequest req, HttpServletResponse resp) throws IOException, JRException {
	    HtmlExporter exporter=new HtmlExporter();
	    List<JasperPrint> jasperPrintList = new ArrayList<JasperPrint>();
	    jasperPrintList.add(jasperPrint);
	    exporter.setExporterInput(SimpleExporterInput.getInstance(jasperPrintList));
	    exporter.setExporterOutput( new SimpleHtmlExporterOutput(resp.getWriter()));
	    SimpleHtmlReportConfiguration configuration =new SimpleHtmlReportConfiguration();
	    exporter.setConfiguration(configuration);
	    exporter.exportReport();
	}*/
	
	
	/*@RequestMapping(value = "/generateReport", method = RequestMethod.POST)
	public String generateReport(@Valid @ModelAttribute("jasperInputForm") JasperInputForm jasperInputForm,BindingResult result,Model model, HttpServletRequest request,HttpServletResponse response) throws ParseException {
	 
	    if (result.hasErrors()) {
	        System.out.println("validation error occured in jasper input form");
	        return "loadJasper";
	 
	    }
	 
	    String reportFileName = "JREmp1";
	 
	    Connection conn = null;
	    try {
	        try {
	 
	             Class.forName("com.mysql.jdbc.Driver");
	            } catch (ClassNotFoundException e) {
	                System.out.println("Please include Classpath Where your MySQL Driver is located");
	                e.printStackTrace();
	            }  
	 
	         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","******");
	 
	     if (conn != null)
	     {
	         System.out.println("Database Connected");
	     }
	     else
	     {
	         System.out.println(" connection Failed ");
	     }
	 
	          String rptFormat = jasperInputForm.getRptFmt();
	          String noy = jasperInputForm.getNoofYears();
	 
	          System.out.println("rpt format " + rptFormat);
	          System.out.println("no of years " + noy);
	 
	           //Parameters as Map to be passed to Jasper
	           HashMap<String,Object> hmParams=new HashMap<String,Object>();
	 
	           hmParams.put("noy", new Integer(noy));
	 
	                   hmParams.put("Title", "Employees working more than "+ noy + " Years");
	 
	            JasperReport jasperReport = getCompiledFile(reportFileName, request);
	 
	        if (rptFormat.equalsIgnoreCase("html") ) {
	 
	            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hmParams, conn);
	            generateReportHtml(jasperPrint, request, response); // For HTML report
	 
	        }
	 
	        else if  (rptFormat.equalsIgnoreCase("pdf") )  {
	 
	            generateReportPDF(response, hmParams, jasperReport, conn); // For PDF report
	 
	            }
	 
	       } catch (Exception sqlExp) {
	 
	           System.out.println( "Exception::" + sqlExp.toString());
	 
	       } finally {
	 
	            try {
	 
	            if (conn != null) {
	                conn.close();
	                conn = null;
	            }
	 
	            } catch (SQLException expSQL) {
	 
	                System.out.println("SQLExp::CLOSING::" + expSQL.toString());
	 
	            }
	 
	           }
	 
	return null;
	 
	}*/
}
