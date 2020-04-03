package vn.vnpt.bacsigiadinh.repository;

import vn.vnpt.bacsigiadinh.domain.BacSi;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data MongoDB repository for the BacSi entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BacSiRepository extends MongoRepository<BacSi, String> {
}
