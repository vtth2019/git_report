package vn.vnpt.bacsigiadinh.service.impl;

import vn.vnpt.bacsigiadinh.service.BaoHiemYTeService;
import vn.vnpt.bacsigiadinh.domain.BaoHiemYTe;
import vn.vnpt.bacsigiadinh.repository.BaoHiemYTeRepository;
import vn.vnpt.bacsigiadinh.service.dto.BaoHiemYTeDTO;
import vn.vnpt.bacsigiadinh.service.mapper.BaoHiemYTeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service Implementation for managing {@link BaoHiemYTe}.
 */
@Service
public class BaoHiemYTeServiceImpl implements BaoHiemYTeService {

    private final Logger log = LoggerFactory.getLogger(BaoHiemYTeServiceImpl.class);

    private final BaoHiemYTeRepository baoHiemYTeRepository;

    private final BaoHiemYTeMapper baoHiemYTeMapper;

    public BaoHiemYTeServiceImpl(BaoHiemYTeRepository baoHiemYTeRepository, BaoHiemYTeMapper baoHiemYTeMapper) {
        this.baoHiemYTeRepository = baoHiemYTeRepository;
        this.baoHiemYTeMapper = baoHiemYTeMapper;
    }

    /**
     * Save a baoHiemYTe.
     *
     * @param baoHiemYTeDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public BaoHiemYTeDTO save(BaoHiemYTeDTO baoHiemYTeDTO) {
        log.debug("Request to save BaoHiemYTe : {}", baoHiemYTeDTO);
        BaoHiemYTe baoHiemYTe = baoHiemYTeMapper.toEntity(baoHiemYTeDTO);
        baoHiemYTe = baoHiemYTeRepository.save(baoHiemYTe);
        return baoHiemYTeMapper.toDto(baoHiemYTe);
    }

    /**
     * Get all the baoHiemYTes.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    public Page<BaoHiemYTeDTO> findAll(Pageable pageable) {
        log.debug("Request to get all BaoHiemYTes");
        return baoHiemYTeRepository.findAll(pageable)
            .map(baoHiemYTeMapper::toDto);
    }

    /**
     * Get one baoHiemYTe by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    public Optional<BaoHiemYTeDTO> findOne(String id) {
        log.debug("Request to get BaoHiemYTe : {}", id);
        return baoHiemYTeRepository.findById(id)
            .map(baoHiemYTeMapper::toDto);
    }

    /**
     * Delete the baoHiemYTe by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(String id) {
        log.debug("Request to delete BaoHiemYTe : {}", id);
        baoHiemYTeRepository.deleteById(id);
    }
}
