package vn.vnpt.bacsigiadinh.repository;

import vn.vnpt.bacsigiadinh.domain.ThongTinKhamBenh;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data MongoDB repository for the ThongTinKhamBenh entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ThongTinKhamBenhRepository extends MongoRepository<ThongTinKhamBenh, String> {
}

