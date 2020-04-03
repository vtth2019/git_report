package vn.vnpt.bacsigiadinh.service;

import vn.vnpt.bacsigiadinh.service.dto.BaoHiemYTeDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link vn.vnpt.bacsigiadinh.domain.BaoHiemYTe}.
 */
public interface BaoHiemYTeService {

    /**
     * Save a baoHiemYTe.
     *
     * @param baoHiemYTeDTO the entity to save.
     * @return the persisted entity.
     */
    BaoHiemYTeDTO save(BaoHiemYTeDTO baoHiemYTeDTO);

    /**
     * Get all the baoHiemYTes.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<BaoHiemYTeDTO> findAll(Pageable pageable);

    /**
     * Get the "id" baoHiemYTe.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<BaoHiemYTeDTO> findOne(String id);

    /**
     * Delete the "id" baoHiemYTe.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
