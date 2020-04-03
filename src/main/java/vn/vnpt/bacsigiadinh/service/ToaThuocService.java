package vn.vnpt.bacsigiadinh.service;

import vn.vnpt.bacsigiadinh.service.dto.ToaThuocDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link vn.vnpt.bacsigiadinh.domain.ToaThuoc}.
 */
public interface ToaThuocService {

    /**
     * Save a toaThuoc.
     *
     * @param toaThuocDTO the entity to save.
     * @return the persisted entity.
     */
    ToaThuocDTO save(ToaThuocDTO toaThuocDTO);

    /**
     * Get all the toaThuocs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ToaThuocDTO> findAll(Pageable pageable);

    /**
     * Get all the toaThuocs with eager load of many-to-many relationships.
     *
     * @return the list of entities.
     */
    Page<ToaThuocDTO> findAllWithEagerRelationships(Pageable pageable);

    /**
     * Get the "id" toaThuoc.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ToaThuocDTO> findOne(String id);

    /**
     * Delete the "id" toaThuoc.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
