package com.smapmerdeksasoreang.smapmeredekasoreang.dao;

import com.smapmerdeksasoreang.smapmeredekasoreang.model.Siswa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;


@Component
public class SiswaDao {

    @Autowired
    SiswaRepository siswaRepository;

    public Collection<Siswa> getSiswa() {
        return siswaRepository.findAll();
    }

    public void addSiswa(Siswa siswa) {
        siswaRepository.save(siswa);
    }

    public Optional<Siswa> getSiswaByNis(String nis) {
        return siswaRepository.findById(nis);
    }
}
