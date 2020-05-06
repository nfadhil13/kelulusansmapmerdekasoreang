package com.smapmerdeksasoreang.smapmeredekasoreang.dao;

import com.smapmerdeksasoreang.smapmeredekasoreang.model.Siswa;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiswaRepository extends MongoRepository<Siswa, String>{
}
