package vn.vnpt.bacsigiadinh.service.impl;

import vn.vnpt.bacsigiadinh.service.BacSiService;
import vn.vnpt.bacsigiadinh.domain.BacSi;
import vn.vnpt.bacsigiadinh.repository.BacSiRepository;
import vn.vnpt.bacsigiadinh.service.dto.BacSiDTO;
import vn.vnpt.bacsigiadinh.service.mapper.BacSiMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service Implementation for managing {@link BacSi}.
 */
@Service
public class BacSiServiceImpl implements BacSiService {

    private final Logger log = LoggerFactory.getLogger(BacSiServiceImpl.class);

    private final BacSiRepository bacSiRepository;

    private final BacSiMapper bacSiMapper;

    public BacSiServiceImpl(BacSiRepository bacSiRepository, BacSiMapper bacSiMapper) {
        this.bacSiRepository = bacSiRepository;
        this.bacSiMapper = bacSiMapper;
    }

    /**
     * Save a bacSi.
     *
     * @param bacSiDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public BacSiDTO save(BacSiDTO bacSiDTO) {
        log.debug("Request to save BacSi : {}", bacSiDTO);
        BacSi bacSi = bacSiMapper.toEntity(bacSiDTO);
        bacSi = bacSiRepository.save(bacSi);
        return bacSiMapper.toDto(bacSi);
    }

    /**
     * Get all the bacSis.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    public Page<BacSiDTO> findAll(Pageable pageable) {
        log.debug("Request to get all BacSis");
        return bacSiRepository.findAll(pageable)
            .map(bacSiMapper::toDto);
    }

    /**
     * Get one bacSi by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    public Optional<BacSiDTO> findOne(String id) {
        log.debug("Request to get BacSi : {}", id);
        return bacSiRepository.findById(id)
            .map(bacSiMapper::toDto);
    }

    /**
     * Delete the bacSi by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(String id) {
        log.debug("Request to delete BacSi : {}", id);
        bacSiRepository.deleteById(id);
    }
}
