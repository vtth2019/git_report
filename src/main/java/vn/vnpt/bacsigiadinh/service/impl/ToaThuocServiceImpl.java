package vn.vnpt.bacsigiadinh.service.impl;

import vn.vnpt.bacsigiadinh.service.ToaThuocService;
import vn.vnpt.bacsigiadinh.domain.ToaThuoc;
import vn.vnpt.bacsigiadinh.repository.ToaThuocRepository;
import vn.vnpt.bacsigiadinh.service.dto.ToaThuocDTO;
import vn.vnpt.bacsigiadinh.service.mapper.ToaThuocMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service Implementation for managing {@link ToaThuoc}.
 */
@Service
public class ToaThuocServiceImpl implements ToaThuocService {

    private final Logger log = LoggerFactory.getLogger(ToaThuocServiceImpl.class);

    private final ToaThuocRepository toaThuocRepository;

    private final ToaThuocMapper toaThuocMapper;

    public ToaThuocServiceImpl(ToaThuocRepository toaThuocRepository, ToaThuocMapper toaThuocMapper) {
        this.toaThuocRepository = toaThuocRepository;
        this.toaThuocMapper = toaThuocMapper;
    }

    /**
     * Save a toaThuoc.
     *
     * @param toaThuocDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public ToaThuocDTO save(ToaThuocDTO toaThuocDTO) {
        log.debug("Request to save ToaThuoc : {}", toaThuocDTO);
        ToaThuoc toaThuoc = toaThuocMapper.toEntity(toaThuocDTO);
        toaThuoc = toaThuocRepository.save(toaThuoc);
        return toaThuocMapper.toDto(toaThuoc);
    }

    /**
     * Get all the toaThuocs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    public Page<ToaThuocDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ToaThuocs");
        return toaThuocRepository.findAll(pageable)
            .map(toaThuocMapper::toDto);
    }

    /**
     * Get all the toaThuocs with eager load of many-to-many relationships.
     *
     * @return the list of entities.
     */
    public Page<ToaThuocDTO> findAllWithEagerRelationships(Pageable pageable) {
        return toaThuocRepository.findAllWithEagerRelationships(pageable).map(toaThuocMapper::toDto);
    }

    /**
     * Get one toaThuoc by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    public Optional<ToaThuocDTO> findOne(String id) {
        log.debug("Request to get ToaThuoc : {}", id);
        return toaThuocRepository.findOneWithEagerRelationships(id)
            .map(toaThuocMapper::toDto);
    }

    /**
     * Delete the toaThuoc by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(String id) {
        log.debug("Request to delete ToaThuoc : {}", id);
        toaThuocRepository.deleteById(id);
    }
}
