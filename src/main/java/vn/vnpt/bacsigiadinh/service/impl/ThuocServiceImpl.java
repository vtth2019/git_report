package vn.vnpt.bacsigiadinh.service.impl;

import vn.vnpt.bacsigiadinh.service.ThuocService;
import vn.vnpt.bacsigiadinh.domain.Thuoc;
import vn.vnpt.bacsigiadinh.repository.ThuocRepository;
import vn.vnpt.bacsigiadinh.service.dto.ThuocDTO;
import vn.vnpt.bacsigiadinh.service.mapper.ThuocMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Thuoc}.
 */
@Service
public class ThuocServiceImpl implements ThuocService {

    private final Logger log = LoggerFactory.getLogger(ThuocServiceImpl.class);

    private final ThuocRepository thuocRepository;

    private final ThuocMapper thuocMapper;

    public ThuocServiceImpl(ThuocRepository thuocRepository, ThuocMapper thuocMapper) {
        this.thuocRepository = thuocRepository;
        this.thuocMapper = thuocMapper;
    }

    /**
     * Save a thuoc.
     *
     * @param thuocDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public ThuocDTO save(ThuocDTO thuocDTO) {
        log.debug("Request to save Thuoc : {}", thuocDTO);
        Thuoc thuoc = thuocMapper.toEntity(thuocDTO);
        thuoc = thuocRepository.save(thuoc);
        return thuocMapper.toDto(thuoc);
    }

    /**
     * Get all the thuocs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    public Page<ThuocDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Thuocs");
        return thuocRepository.findAll(pageable)
            .map(thuocMapper::toDto);
    }

    /**
     * Get one thuoc by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    public Optional<ThuocDTO> findOne(String id) {
        log.debug("Request to get Thuoc : {}", id);
        return thuocRepository.findById(id)
            .map(thuocMapper::toDto);
    }

    /**
     * Delete the thuoc by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(String id) {
        log.debug("Request to delete Thuoc : {}", id);
        thuocRepository.deleteById(id);
    }
}
