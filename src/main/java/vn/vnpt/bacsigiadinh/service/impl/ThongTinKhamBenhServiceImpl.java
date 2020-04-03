package vn.vnpt.bacsigiadinh.service.impl;

import vn.vnpt.bacsigiadinh.service.ThongTinKhamBenhService;
import vn.vnpt.bacsigiadinh.domain.ThongTinKhamBenh;
import vn.vnpt.bacsigiadinh.domain.BenhNhan;
import vn.vnpt.bacsigiadinh.repository.ThongTinKhamBenhRepository;
import vn.vnpt.bacsigiadinh.repository.BenhNhanRepository;
import vn.vnpt.bacsigiadinh.service.dto.ThongTinKhamBenhDTO;
import vn.vnpt.bacsigiadinh.service.mapper.ThongTinKhamBenhMapper;
import vn.vnpt.bacsigiadinh.service.mapper.BenhNhanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;

import net.sf.jasperreports.engine.JasperExportManager;

import net.sf.jasperreports.engine.JasperFillManager;

import net.sf.jasperreports.engine.JasperPrint;

import net.sf.jasperreports.engine.JasperReport;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.SimpleCsvExporterConfiguration;

import net.sf.jasperreports.export.SimpleExporterInput;

import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

import net.sf.jasperreports.export.SimpleWriterExporterOutput;

import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

/**
 * Service Implementation for managing {@link ThongTinKhamBenh}.
 */
@Service
public class ThongTinKhamBenhServiceImpl implements ThongTinKhamBenhService {

    private final Logger log = LoggerFactory.getLogger(ThongTinKhamBenhServiceImpl.class);

    private final ThongTinKhamBenhRepository thongTinKhamBenhRepository;

    private final BenhNhanRepository benhNhanRepository;

    private final ThongTinKhamBenhMapper thongTinKhamBenhMapper;

    private final BenhNhanMapper benhNhanMapper;

    public ThongTinKhamBenhServiceImpl(ThongTinKhamBenhRepository thongTinKhamBenhRepository, ThongTinKhamBenhMapper thongTinKhamBenhMapper, BenhNhanRepository benhNhanRepository, BenhNhanMapper benhNhanMapper){
        this.thongTinKhamBenhRepository = thongTinKhamBenhRepository;
        this.thongTinKhamBenhMapper = thongTinKhamBenhMapper;
        this.benhNhanRepository = benhNhanRepository;
        this.benhNhanMapper = benhNhanMapper;
    }

    /**
     * Save a thongTinKhamBenh.
     *
     * @param thongTinKhamBenhDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public ThongTinKhamBenhDTO save(ThongTinKhamBenhDTO thongTinKhamBenhDTO) {
        log.debug("Request to save ThongTinKhamBenh : {}", thongTinKhamBenhDTO);
        ThongTinKhamBenh thongTinKhamBenh = thongTinKhamBenhMapper.toEntity(thongTinKhamBenhDTO);
        thongTinKhamBenh = thongTinKhamBenhRepository.save(thongTinKhamBenh);
        return thongTinKhamBenhMapper.toDto(thongTinKhamBenh);
    }

    /**
     * Get all the thongTinKhamBenhs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    public Page<ThongTinKhamBenhDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ThongTinKhamBenhs");
        return thongTinKhamBenhRepository.findAll(pageable)
            .map(thongTinKhamBenhMapper::toDto);
    }

    /**
     * Get one thongTinKhamBenh by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    public Optional<ThongTinKhamBenhDTO> findOne(String id) {
        log.debug("Request to get ThongTinKhamBenh : {}", id);
        return thongTinKhamBenhRepository.findById(id)
            .map(thongTinKhamBenhMapper::toDto);
    }

    /**
     * Delete the thongTinKhamBenh by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(String id) {
        log.debug("Request to delete ThongTinKhamBenh : {}", id);
        thongTinKhamBenhRepository.deleteById(id);
    }
    @Override
    public String generateReport() {
                List<BenhNhan> benhNhans = new ArrayList<>();
        
                this.benhNhanRepository.findAll().stream().forEach(e -> benhNhans.add(e));
                log.debug("this.benhNhanRepository.findAll().stream().forEach(e -> benhNhans.add(e)) : {}", benhNhans);
                
                try {
                    String reportPath = ResourceUtils.getURL("classpath").toString();
        
                    File file = ResourceUtils.getFile("classpath:report1_3.jrxml");
        
                    InputStream input = new FileInputStream(file);

                    // Compile the Jasper report from .jrxml to .japser
        
                    JasperReport jasperReport = JasperCompileManager.compileReport(input);

                    // Get your data source
        
                    JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(benhNhans);

                    // Add parameters
        
                    Map<String, Object> parameters = new HashMap<>();
        
                    parameters.put("createdBy", "JavaHelper.org");

                    // Fill the report
        
                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, source);

                    // Export the report to a PDF file
        
                    JasperExportManager.exportReportToPdfFile(jasperPrint, reportPath + "\\baocao.pdf");
        
                    System.out.println("PDF File Generated !!");

                    return "Report successfully generated @path= " + reportPath;
        
        
                } catch (Exception e) {
        
                    return e.getMessage();
        
                }
        
            }

            @Override
            public byte[]  generateJasperReportPDF(HttpServletRequest httpServletRequest, String jasperReportName, ByteArrayOutputStream outputStream, Map parameters) {
                JRPdfExporter exporter = new JRPdfExporter();
                try {
                    List<BenhNhan> benhNhans = new ArrayList<>();
        
                    this.benhNhanRepository.findAll().stream().forEach(e -> benhNhans.add(e));
                    log.debug("this.benhNhanRepository.findAll().stream().forEach(e -> benhNhans.add(e)) : {}", benhNhans);

                    // String reportPath = ResourceUtils.getURL("classpath").toString();
        
                    File reportPath = ResourceUtils.getFile("classpath:report1_3.jrxml");
        
                    // InputStream input = new FileInputStream(file);
                    
                    JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(benhNhans);

                    //String reportPath = ResourceUtils.getURL("classpath").toString();
                    
                  
        

                    String reportLocation = httpServletRequest.getSession().getServletContext().getRealPath("/") +"resources\\report1_3.jrxml";
                   
            
                    InputStream jrxmlInput = new FileInputStream(reportPath); 
                    //this.getClass().getClassLoader().getResource("data.jrxml").openStream();
                    JasperDesign design = JRXmlLoader.load(jrxmlInput);
                    JasperReport jasperReport = JasperCompileManager.compileReport(design);
                    //System.out.println("Report compiled");
            
                    //JasperReport jasperReport = JasperCompileManager.compileReport(reportLocation);
                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, source); // datasource Service
                    
                    //JasperExportManager.exportReportToPdfFile(jasperPrint, reportPath + "\\baocao.pdf");
            
                    exporter.setExporterInput(new SimpleExporterInput(jasperPrint));   
                    exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
                    exporter.exportReport();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error in generate Report..."+e);
                } finally {
                }
                return outputStream.toByteArray();
            }
            @Override
            public void csv(JasperPrint jasperPrint) throws JRException {
              String reportPath = "./";
              // String reportPath = ResourceUtils.getURL("classpath").toString();

                JRCsvExporter exporter = new JRCsvExporter();
        
                exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        
                exporter.setExporterOutput(new SimpleWriterExporterOutput(reportPath + "\\baocao.csv"));
        
        
        
                SimpleCsvExporterConfiguration configuration = new SimpleCsvExporterConfiguration();
        
                configuration.setFieldDelimiter(",");
        
                exporter.setConfiguration(configuration);
        
                exporter.exportReport();
        
            }
}
