package vn.vnpt.bacsigiadinh.repository;

import vn.vnpt.bacsigiadinh.domain.BenhNhan;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data MongoDB repository for the BenhNhan entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BenhNhanRepository extends MongoRepository<BenhNhan, String> {
}
