package vn.vnpt.bacsigiadinh.web.rest;

import vn.vnpt.bacsigiadinh.service.ThuocService;
import vn.vnpt.bacsigiadinh.web.rest.errors.BadRequestAlertException;
import vn.vnpt.bacsigiadinh.service.dto.ThuocDTO;

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

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link vn.vnpt.bacsigiadinh.domain.Thuoc}.
 */
@RestController
@RequestMapping("/api")
public class ThuocResource {

    private final Logger log = LoggerFactory.getLogger(ThuocResource.class);

    private static final String ENTITY_NAME = "hosobacsigiadinhThuoc";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ThuocService thuocService;

    public ThuocResource(ThuocService thuocService) {
        this.thuocService = thuocService;
    }

    /**
     * {@code POST  /thuocs} : Create a new thuoc.
     *
     * @param thuocDTO the thuocDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new thuocDTO, or with status {@code 400 (Bad Request)} if the thuoc has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/thuocs")
    public ResponseEntity<ThuocDTO> createThuoc(@RequestBody ThuocDTO thuocDTO) throws URISyntaxException {
        log.debug("REST request to save Thuoc : {}", thuocDTO);
        if (thuocDTO.getId() != null) {
            throw new BadRequestAlertException("A new thuoc cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ThuocDTO result = thuocService.save(thuocDTO);
        return ResponseEntity.created(new URI("/api/thuocs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /thuocs} : Updates an existing thuoc.
     *
     * @param thuocDTO the thuocDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated thuocDTO,
     * or with status {@code 400 (Bad Request)} if the thuocDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the thuocDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/thuocs")
    public ResponseEntity<ThuocDTO> updateThuoc(@RequestBody ThuocDTO thuocDTO) throws URISyntaxException {
        log.debug("REST request to update Thuoc : {}", thuocDTO);
        if (thuocDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ThuocDTO result = thuocService.save(thuocDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, thuocDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /thuocs} : get all the thuocs.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of thuocs in body.
     */
    @GetMapping("/thuocs")
    public ResponseEntity<List<ThuocDTO>> getAllThuocs(Pageable pageable) {
        log.debug("REST request to get a page of Thuocs");
        Page<ThuocDTO> page = thuocService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /thuocs/:id} : get the "id" thuoc.
     *
     * @param id the id of the thuocDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the thuocDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/thuocs/{id}")
    public ResponseEntity<ThuocDTO> getThuoc(@PathVariable String id) {
        log.debug("REST request to get Thuoc : {}", id);
        Optional<ThuocDTO> thuocDTO = thuocService.findOne(id);
        return ResponseUtil.wrapOrNotFound(thuocDTO);
    }

    /**
     * {@code DELETE  /thuocs/:id} : delete the "id" thuoc.
     *
     * @param id the id of the thuocDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/thuocs/{id}")
    public ResponseEntity<Void> deleteThuoc(@PathVariable String id) {
        log.debug("REST request to delete Thuoc : {}", id);
        thuocService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id)).build();
    }
}
