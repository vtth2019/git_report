package vn.vnpt.bacsigiadinh.repository;

import vn.vnpt.bacsigiadinh.domain.BaoHiemYTe;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data MongoDB repository for the BaoHiemYTe entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BaoHiemYTeRepository extends MongoRepository<BaoHiemYTe, String> {
}
