package vn.vnpt.bacsigiadinh.web.rest;

import vn.vnpt.bacsigiadinh.service.BaoHiemYTeService;
import vn.vnpt.bacsigiadinh.web.rest.errors.BadRequestAlertException;
import vn.vnpt.bacsigiadinh.service.dto.BaoHiemYTeDTO;

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
 * REST controller for managing {@link vn.vnpt.bacsigiadinh.domain.BaoHiemYTe}.
 */
@RestController
@RequestMapping("/api")
public class BaoHiemYTeResource {

    private final Logger log = LoggerFactory.getLogger(BaoHiemYTeResource.class);

    private static final String ENTITY_NAME = "hosobacsigiadinhBaoHiemYTe";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final BaoHiemYTeService baoHiemYTeService;

    public BaoHiemYTeResource(BaoHiemYTeService baoHiemYTeService) {
        this.baoHiemYTeService = baoHiemYTeService;
    }

    /**
     * {@code POST  /bao-hiem-y-tes} : Create a new baoHiemYTe.
     *
     * @param baoHiemYTeDTO the baoHiemYTeDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new baoHiemYTeDTO, or with status {@code 400 (Bad Request)} if the baoHiemYTe has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/bao-hiem-y-tes")
    public ResponseEntity<BaoHiemYTeDTO> createBaoHiemYTe(@RequestBody BaoHiemYTeDTO baoHiemYTeDTO) throws URISyntaxException {
        log.debug("REST request to save BaoHiemYTe : {}", baoHiemYTeDTO);
        if (baoHiemYTeDTO.getId() != null) {
            throw new BadRequestAlertException("A new baoHiemYTe cannot already have an ID", ENTITY_NAME, "idexists");
        }
        BaoHiemYTeDTO result = baoHiemYTeService.save(baoHiemYTeDTO);
        return ResponseEntity.created(new URI("/api/bao-hiem-y-tes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /bao-hiem-y-tes} : Updates an existing baoHiemYTe.
     *
     * @param baoHiemYTeDTO the baoHiemYTeDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated baoHiemYTeDTO,
     * or with status {@code 400 (Bad Request)} if the baoHiemYTeDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the baoHiemYTeDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/bao-hiem-y-tes")
    public ResponseEntity<BaoHiemYTeDTO> updateBaoHiemYTe(@RequestBody BaoHiemYTeDTO baoHiemYTeDTO) throws URISyntaxException {
        log.debug("REST request to update BaoHiemYTe : {}", baoHiemYTeDTO);
        if (baoHiemYTeDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        BaoHiemYTeDTO result = baoHiemYTeService.save(baoHiemYTeDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, baoHiemYTeDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /bao-hiem-y-tes} : get all the baoHiemYTes.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of baoHiemYTes in body.
     */
    @GetMapping("/bao-hiem-y-tes")
    public ResponseEntity<List<BaoHiemYTeDTO>> getAllBaoHiemYTes(Pageable pageable) {
        log.debug("REST request to get a page of BaoHiemYTes");
        Page<BaoHiemYTeDTO> page = baoHiemYTeService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /bao-hiem-y-tes/:id} : get the "id" baoHiemYTe.
     *
     * @param id the id of the baoHiemYTeDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the baoHiemYTeDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/bao-hiem-y-tes/{id}")
    public ResponseEntity<BaoHiemYTeDTO> getBaoHiemYTe(@PathVariable String id) {
        log.debug("REST request to get BaoHiemYTe : {}", id);
        Optional<BaoHiemYTeDTO> baoHiemYTeDTO = baoHiemYTeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(baoHiemYTeDTO);
    }

    /**
     * {@code DELETE  /bao-hiem-y-tes/:id} : delete the "id" baoHiemYTe.
     *
     * @param id the id of the baoHiemYTeDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/bao-hiem-y-tes/{id}")
    public ResponseEntity<Void> deleteBaoHiemYTe(@PathVariable String id) {
        log.debug("REST request to delete BaoHiemYTe : {}", id);
        baoHiemYTeService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id)).build();
    }
}
