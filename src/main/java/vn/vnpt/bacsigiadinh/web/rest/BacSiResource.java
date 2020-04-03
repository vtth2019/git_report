package vn.vnpt.bacsigiadinh.web.rest;

import vn.vnpt.bacsigiadinh.service.BacSiService;
import vn.vnpt.bacsigiadinh.web.rest.errors.BadRequestAlertException;
import vn.vnpt.bacsigiadinh.service.dto.BacSiDTO;

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
 * REST controller for managing {@link vn.vnpt.bacsigiadinh.domain.BacSi}.
 */
@RestController
@RequestMapping("/api")
public class BacSiResource {

    private final Logger log = LoggerFactory.getLogger(BacSiResource.class);

    private static final String ENTITY_NAME = "hosobacsigiadinhBacSi";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final BacSiService bacSiService;

    public BacSiResource(BacSiService bacSiService) {
        this.bacSiService = bacSiService;
    }

    /**
     * {@code POST  /bac-sis} : Create a new bacSi.
     *
     * @param bacSiDTO the bacSiDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new bacSiDTO, or with status {@code 400 (Bad Request)} if the bacSi has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/bac-sis")
    public ResponseEntity<BacSiDTO> createBacSi(@RequestBody BacSiDTO bacSiDTO) throws URISyntaxException {
        log.debug("REST request to save BacSi : {}", bacSiDTO);
        if (bacSiDTO.getId() != null) {
            throw new BadRequestAlertException("A new bacSi cannot already have an ID", ENTITY_NAME, "idexists");
        }
        BacSiDTO result = bacSiService.save(bacSiDTO);
        return ResponseEntity.created(new URI("/api/bac-sis/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /bac-sis} : Updates an existing bacSi.
     *
     * @param bacSiDTO the bacSiDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated bacSiDTO,
     * or with status {@code 400 (Bad Request)} if the bacSiDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the bacSiDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/bac-sis")
    public ResponseEntity<BacSiDTO> updateBacSi(@RequestBody BacSiDTO bacSiDTO) throws URISyntaxException {
        log.debug("REST request to update BacSi : {}", bacSiDTO);
        if (bacSiDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        BacSiDTO result = bacSiService.save(bacSiDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, bacSiDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /bac-sis} : get all the bacSis.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of bacSis in body.
     */
    @GetMapping("/bac-sis")
    public ResponseEntity<List<BacSiDTO>> getAllBacSis(Pageable pageable) {
        log.debug("REST request to get a page of BacSis");
        Page<BacSiDTO> page = bacSiService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /bac-sis/:id} : get the "id" bacSi.
     *
     * @param id the id of the bacSiDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the bacSiDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/bac-sis/{id}")
    public ResponseEntity<BacSiDTO> getBacSi(@PathVariable String id) {
        log.debug("REST request to get BacSi : {}", id);
        Optional<BacSiDTO> bacSiDTO = bacSiService.findOne(id);
        return ResponseUtil.wrapOrNotFound(bacSiDTO);
    }

    /**
     * {@code DELETE  /bac-sis/:id} : delete the "id" bacSi.
     *
     * @param id the id of the bacSiDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/bac-sis/{id}")
    public ResponseEntity<Void> deleteBacSi(@PathVariable String id) {
        log.debug("REST request to delete BacSi : {}", id);
        bacSiService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id)).build();
    }
}
