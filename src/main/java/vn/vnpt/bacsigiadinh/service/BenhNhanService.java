package vn.vnpt.bacsigiadinh.service;

import vn.vnpt.bacsigiadinh.service.dto.BenhNhanDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link vn.vnpt.bacsigiadinh.domain.BenhNhan}.
 */
public interface BenhNhanService {

    /**
     * Save a benhNhan.
     *
     * @param benhNhanDTO the entity to save.
     * @return the persisted entity.
     */
    BenhNhanDTO save(BenhNhanDTO benhNhanDTO);

    /**
     * Get all the benhNhans.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<BenhNhanDTO> findAll(Pageable pageable);

    /**
     * Get the "id" benhNhan.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<BenhNhanDTO> findOne(String id);

    /**
     * Delete the "id" benhNhan.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
