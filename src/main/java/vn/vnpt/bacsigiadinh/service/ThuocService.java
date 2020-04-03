package vn.vnpt.bacsigiadinh.service;

import vn.vnpt.bacsigiadinh.service.dto.ThuocDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link vn.vnpt.bacsigiadinh.domain.Thuoc}.
 */
public interface ThuocService {

    /**
     * Save a thuoc.
     *
     * @param thuocDTO the entity to save.
     * @return the persisted entity.
     */
    ThuocDTO save(ThuocDTO thuocDTO);

    /**
     * Get all the thuocs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ThuocDTO> findAll(Pageable pageable);

    /**
     * Get the "id" thuoc.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ThuocDTO> findOne(String id);

    /**
     * Delete the "id" thuoc.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
