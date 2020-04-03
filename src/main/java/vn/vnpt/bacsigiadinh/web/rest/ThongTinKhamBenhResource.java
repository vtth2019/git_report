package vn.vnpt.bacsigiadinh.web.rest;

import vn.vnpt.bacsigiadinh.service.ThongTinKhamBenhService;
import vn.vnpt.bacsigiadinh.web.rest.errors.BadRequestAlertException;
import vn.vnpt.bacsigiadinh.service.dto.ThongTinKhamBenhDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

/**
 * REST controller for managing {@link vn.vnpt.bacsigiadinh.domain.ThongTinKhamBenh}.
 */
@RestController
@RequestMapping("/api")
public class ThongTinKhamBenhResource {

    private final Logger log = LoggerFactory.getLogger(ThongTinKhamBenhResource.class);

    private static final String ENTITY_NAME = "hosobacsigiadinhThongTinKhamBenh";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ThongTinKhamBenhService thongTinKhamBenhService;

    public ThongTinKhamBenhResource(ThongTinKhamBenhService thongTinKhamBenhService) {
        this.thongTinKhamBenhService = thongTinKhamBenhService;
    }

    /**
     * {@code POST  /thong-tin-kham-benhs} : Create a new thongTinKhamBenh.
     *
     * @param thongTinKhamBenhDTO the thongTinKhamBenhDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new thongTinKhamBenhDTO, or with status {@code 400 (Bad Request)} if the thongTinKhamBenh has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/thong-tin-kham-benhs")
    public ResponseEntity<ThongTinKhamBenhDTO> createThongTinKhamBenh(@RequestBody ThongTinKhamBenhDTO thongTinKhamBenhDTO) throws URISyntaxException {
        log.debug("REST request to save ThongTinKhamBenh : {}", thongTinKhamBenhDTO);
        if (thongTinKhamBenhDTO.getId() != null) {
            throw new BadRequestAlertException("A new thongTinKhamBenh cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ThongTinKhamBenhDTO result = thongTinKhamBenhService.save(thongTinKhamBenhDTO);
        return ResponseEntity.created(new URI("/api/thong-tin-kham-benhs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /thong-tin-kham-benhs} : Updates an existing thongTinKhamBenh.
     *
     * @param thongTinKhamBenhDTO the thongTinKhamBenhDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated thongTinKhamBenhDTO,
     * or with status {@code 400 (Bad Request)} if the thongTinKhamBenhDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the thongTinKhamBenhDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/thong-tin-kham-benhs")
    public ResponseEntity<ThongTinKhamBenhDTO> updateThongTinKhamBenh(@RequestBody ThongTinKhamBenhDTO thongTinKhamBenhDTO) throws URISyntaxException {
        log.debug("REST request to update ThongTinKhamBenh : {}", thongTinKhamBenhDTO);
        if (thongTinKhamBenhDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ThongTinKhamBenhDTO result = thongTinKhamBenhService.save(thongTinKhamBenhDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, thongTinKhamBenhDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /thong-tin-kham-benhs} : get all the thongTinKhamBenhs.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of thongTinKhamBenhs in body.
     */
    @GetMapping("/thong-tin-kham-benhs")
    public ResponseEntity<List<ThongTinKhamBenhDTO>> getAllThongTinKhamBenhs(Pageable pageable) {
        log.debug("REST request to get a page of ThongTinKhamBenhs");
        Page<ThongTinKhamBenhDTO> page = thongTinKhamBenhService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /thong-tin-kham-benhs/:id} : get the "id" thongTinKhamBenh.
     *
     * @param id the id of the thongTinKhamBenhDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the thongTinKhamBenhDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/thong-tin-kham-benhs/{id}")
    public ResponseEntity<ThongTinKhamBenhDTO> getThongTinKhamBenh(@PathVariable String id) {
        log.debug("REST request to get ThongTinKhamBenh : {}", id);
        Optional<ThongTinKhamBenhDTO> thongTinKhamBenhDTO = thongTinKhamBenhService.findOne(id);
        return ResponseUtil.wrapOrNotFound(thongTinKhamBenhDTO);
    }

    /**
     * {@code DELETE  /thong-tin-kham-benhs/:id} : delete the "id" thongTinKhamBenh.
     *
     * @param id the id of the thongTinKhamBenhDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/thong-tin-kham-benhs/{id}")
    public ResponseEntity<Void> deleteThongTinKhamBenh(@PathVariable String id) {
        log.debug("REST request to delete ThongTinKhamBenh : {}", id);
        thongTinKhamBenhService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id)).build();
    }
    @GetMapping("/print/thong-tin-kham-benhs")
    public ResponseEntity<byte[]> printThongTinKhamBenhTheoBenhNhan(HttpServletRequest httpServletReques){
        HttpHeaders headers = new HttpHeaders();
        ByteArrayOutputStream file = new ByteArrayOutputStream();
        thongTinKhamBenhService.generateJasperReportPDF(httpServletReques, "baocao.pdf", file, headers);
        headers.add("content-disposition", "attachment; filename=baocao.pdf");
         ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(file.toByteArray(), headers, HttpStatus.OK);
            return response;
    }
}
