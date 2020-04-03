package vn.vnpt.bacsigiadinh.service;

import vn.vnpt.bacsigiadinh.service.dto.ThongTinKhamBenhDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

import java.io.ByteArrayOutputStream;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

/**
 * Service Interface for managing {@link vn.vnpt.bacsigiadinh.domain.ThongTinKhamBenh}.
 */
public interface ThongTinKhamBenhService {

    /**
     * Save a thongTinKhamBenh.
     *
     * @param thongTinKhamBenhDTO the entity to save.
     * @return the persisted entity.
     */
    ThongTinKhamBenhDTO save(ThongTinKhamBenhDTO thongTinKhamBenhDTO);

    /**
     * Get all the thongTinKhamBenhs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ThongTinKhamBenhDTO> findAll(Pageable pageable);

    /**
     * Get the "id" thongTinKhamBenh.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ThongTinKhamBenhDTO> findOne(String id);

    /**
     * Delete the "id" thongTinKhamBenh.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
    
    public String generateReport();
    public byte[] generateJasperReportPDF(HttpServletRequest httpServletRequest, String jasperReportName, ByteArrayOutputStream outputStream, Map parameters);
     public void csv(JasperPrint jasperPrint) throws JRException;
}
