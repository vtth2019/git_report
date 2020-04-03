package vn.vnpt.bacsigiadinh.service.impl;

import vn.vnpt.bacsigiadinh.service.BenhNhanService;
import vn.vnpt.bacsigiadinh.domain.BenhNhan;
import vn.vnpt.bacsigiadinh.repository.BenhNhanRepository;
import vn.vnpt.bacsigiadinh.service.dto.BenhNhanDTO;
import vn.vnpt.bacsigiadinh.service.mapper.BenhNhanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service Implementation for managing {@link BenhNhan}.
 */
@Service
public class BenhNhanServiceImpl implements BenhNhanService {

    private final Logger log = LoggerFactory.getLogger(BenhNhanServiceImpl.class);

    private final BenhNhanRepository benhNhanRepository;

    private final BenhNhanMapper benhNhanMapper;

    public BenhNhanServiceImpl(BenhNhanRepository benhNhanRepository, BenhNhanMapper benhNhanMapper) {
        this.benhNhanRepository = benhNhanRepository;
        this.benhNhanMapper = benhNhanMapper;
    }

    /**
     * Save a benhNhan.
     *
     * @param benhNhanDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public BenhNhanDTO save(BenhNhanDTO benhNhanDTO) {
        log.debug("Request to save BenhNhan : {}", benhNhanDTO);
        BenhNhan benhNhan = benhNhanMapper.toEntity(benhNhanDTO);
        benhNhan = benhNhanRepository.save(benhNhan);
        return benhNhanMapper.toDto(benhNhan);
    }

    /**
     * Get all the benhNhans.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    public Page<BenhNhanDTO> findAll(Pageable pageable) {
        log.debug("Request to get all BenhNhans");
        return benhNhanRepository.findAll(pageable)
            .map(benhNhanMapper::toDto);
    }

    /**
     * Get one benhNhan by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    public Optional<BenhNhanDTO> findOne(String id) {
        log.debug("Request to get BenhNhan : {}", id);
        return benhNhanRepository.findById(id)
            .map(benhNhanMapper::toDto);
    }

    /**
     * Delete the benhNhan by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(String id) {
        log.debug("Request to delete BenhNhan : {}", id);
        benhNhanRepository.deleteById(id);
    }
}
