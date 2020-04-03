package vn.vnpt.bacsigiadinh.service;

import vn.vnpt.bacsigiadinh.service.dto.BacSiDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link vn.vnpt.bacsigiadinh.domain.BacSi}.
 */
public interface BacSiService {

    /**
     * Save a bacSi.
     *
     * @param bacSiDTO the entity to save.
     * @return the persisted entity.
     */
    BacSiDTO save(BacSiDTO bacSiDTO);

    /**
     * Get all the bacSis.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<BacSiDTO> findAll(Pageable pageable);

    /**
     * Get the "id" bacSi.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<BacSiDTO> findOne(String id);

    /**
     * Delete the "id" bacSi.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
