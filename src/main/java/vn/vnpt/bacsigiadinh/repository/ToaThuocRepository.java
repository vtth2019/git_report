package vn.vnpt.bacsigiadinh.repository;

import vn.vnpt.bacsigiadinh.domain.ToaThuoc;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data MongoDB repository for the ToaThuoc entity.
 */
@Repository
public interface ToaThuocRepository extends MongoRepository<ToaThuoc, String> {

    @Query("{}")
    Page<ToaThuoc> findAllWithEagerRelationships(Pageable pageable);

    @Query("{}")
    List<ToaThuoc> findAllWithEagerRelationships();

    @Query("{'id': ?0}")
    Optional<ToaThuoc> findOneWithEagerRelationships(String id);
}
