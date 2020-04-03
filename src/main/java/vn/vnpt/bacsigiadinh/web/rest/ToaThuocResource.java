package vn.vnpt.bacsigiadinh.web.rest;

import vn.vnpt.bacsigiadinh.service.ToaThuocService;
import vn.vnpt.bacsigiadinh.web.rest.errors.BadRequestAlertException;
import vn.vnpt.bacsigiadinh.service.dto.ToaThuocDTO;

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
 * REST controller for managing {@link vn.vnpt.bacsigiadinh.domain.ToaThuoc}.
 */
@RestController
@RequestMapping("/api")
public class ToaThuocResource {

    private final Logger log = LoggerFactory.getLogger(ToaThuocResource.class);

    private static final String ENTITY_NAME = "hosobacsigiadinhToaThuoc";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ToaThuocService toaThuocService;

    public ToaThuocResource(ToaThuocService toaThuocService) {
        this.toaThuocService = toaThuocService;
    }

    /**
     * {@code POST  /toa-thuocs} : Create a new toaThuoc.
     *
     * @param toaThuocDTO the toaThuocDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new toaThuocDTO, or with status {@code 400 (Bad Request)} if the toaThuoc has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/toa-thuocs")
    public ResponseEntity<ToaThuocDTO> createToaThuoc(@RequestBody ToaThuocDTO toaThuocDTO) throws URISyntaxException {
        log.debug("REST request to save ToaThuoc : {}", toaThuocDTO);
        if (toaThuocDTO.getId() != null) {
            throw new BadRequestAlertException("A new toaThuoc cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ToaThuocDTO result = toaThuocService.save(toaThuocDTO);
        return ResponseEntity.created(new URI("/api/toa-thuocs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /toa-thuocs} : Updates an existing toaThuoc.
     *
     * @param toaThuocDTO the toaThuocDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated toaThuocDTO,
     * or with status {@code 400 (Bad Request)} if the toaThuocDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the toaThuocDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/toa-thuocs")
    public ResponseEntity<ToaThuocDTO> updateToaThuoc(@RequestBody ToaThuocDTO toaThuocDTO) throws URISyntaxException {
        log.debug("REST request to update ToaThuoc : {}", toaThuocDTO);
        if (toaThuocDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ToaThuocDTO result = toaThuocService.save(toaThuocDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, toaThuocDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /toa-thuocs} : get all the toaThuocs.
     *
     * @param pageable the pagination information.
     * @param eagerload flag to eager load entities from relationships (This is applicable for many-to-many).
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of toaThuocs in body.
     */
    @GetMapping("/toa-thuocs")
    public ResponseEntity<List<ToaThuocDTO>> getAllToaThuocs(Pageable pageable, @RequestParam(required = false, defaultValue = "false") boolean eagerload) {
        log.debug("REST request to get a page of ToaThuocs");
        Page<ToaThuocDTO> page;
        if (eagerload) {
            page = toaThuocService.findAllWithEagerRelationships(pageable);
        } else {
            page = toaThuocService.findAll(pageable);
        }
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /toa-thuocs/:id} : get the "id" toaThuoc.
     *
     * @param id the id of the toaThuocDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the toaThuocDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/toa-thuocs/{id}")
    public ResponseEntity<ToaThuocDTO> getToaThuoc(@PathVariable String id) {
        log.debug("REST request to get ToaThuoc : {}", id);
        Optional<ToaThuocDTO> toaThuocDTO = toaThuocService.findOne(id);
        return ResponseUtil.wrapOrNotFound(toaThuocDTO);
    }

    /**
     * {@code DELETE  /toa-thuocs/:id} : delete the "id" toaThuoc.
     *
     * @param id the id of the toaThuocDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/toa-thuocs/{id}")
    public ResponseEntity<Void> deleteToaThuoc(@PathVariable String id) {
        log.debug("REST request to delete ToaThuoc : {}", id);
        toaThuocService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id)).build();
    }
}
