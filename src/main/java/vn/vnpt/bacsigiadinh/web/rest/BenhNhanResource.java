package vn.vnpt.bacsigiadinh.web.rest;

import vn.vnpt.bacsigiadinh.service.BenhNhanService;
import vn.vnpt.bacsigiadinh.web.rest.errors.BadRequestAlertException;
import vn.vnpt.bacsigiadinh.service.dto.BenhNhanDTO;

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
 * REST controller for managing {@link vn.vnpt.bacsigiadinh.domain.BenhNhan}.
 */
@RestController
@RequestMapping("/api")
public class BenhNhanResource {

    private final Logger log = LoggerFactory.getLogger(BenhNhanResource.class);

    private static final String ENTITY_NAME = "hosobacsigiadinhBenhNhan";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final BenhNhanService benhNhanService;

    public BenhNhanResource(BenhNhanService benhNhanService) {
        this.benhNhanService = benhNhanService;
    }

    /**
     * {@code POST  /benh-nhans} : Create a new benhNhan.
     *
     * @param benhNhanDTO the benhNhanDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new benhNhanDTO, or with status {@code 400 (Bad Request)} if the benhNhan has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/benh-nhans")
    public ResponseEntity<BenhNhanDTO> createBenhNhan(@RequestBody BenhNhanDTO benhNhanDTO) throws URISyntaxException {
        log.debug("REST request to save BenhNhan : {}", benhNhanDTO);
        if (benhNhanDTO.getId() != null) {
            throw new BadRequestAlertException("A new benhNhan cannot already have an ID", ENTITY_NAME, "idexists");
        }
        BenhNhanDTO result = benhNhanService.save(benhNhanDTO);
        return ResponseEntity.created(new URI("/api/benh-nhans/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /benh-nhans} : Updates an existing benhNhan.
     *
     * @param benhNhanDTO the benhNhanDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated benhNhanDTO,
     * or with status {@code 400 (Bad Request)} if the benhNhanDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the benhNhanDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/benh-nhans")
    public ResponseEntity<BenhNhanDTO> updateBenhNhan(@RequestBody BenhNhanDTO benhNhanDTO) throws URISyntaxException {
        log.debug("REST request to update BenhNhan : {}", benhNhanDTO);
        if (benhNhanDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        BenhNhanDTO result = benhNhanService.save(benhNhanDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, benhNhanDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /benh-nhans} : get all the benhNhans.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of benhNhans in body.
     */
    @GetMapping("/benh-nhans")
    public ResponseEntity<List<BenhNhanDTO>> getAllBenhNhans(Pageable pageable) {
        log.debug("REST request to get a page of BenhNhans");
        Page<BenhNhanDTO> page = benhNhanService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /benh-nhans/:id} : get the "id" benhNhan.
     *
     * @param id the id of the benhNhanDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the benhNhanDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/benh-nhans/{id}")
    public ResponseEntity<BenhNhanDTO> getBenhNhan(@PathVariable String id) {
        log.debug("REST request to get BenhNhan : {}", id);
        Optional<BenhNhanDTO> benhNhanDTO = benhNhanService.findOne(id);
        return ResponseUtil.wrapOrNotFound(benhNhanDTO);
    }

    /**
     * {@code DELETE  /benh-nhans/:id} : delete the "id" benhNhan.
     *
     * @param id the id of the benhNhanDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/benh-nhans/{id}")
    public ResponseEntity<Void> deleteBenhNhan(@PathVariable String id) {
        log.debug("REST request to delete BenhNhan : {}", id);
        benhNhanService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id)).build();
    }
}
