package vn.vnpt.bacsigiadinh.repository;

import vn.vnpt.bacsigiadinh.domain.Thuoc;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data MongoDB repository for the Thuoc entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ThuocRepository extends MongoRepository<Thuoc, String> {
}
