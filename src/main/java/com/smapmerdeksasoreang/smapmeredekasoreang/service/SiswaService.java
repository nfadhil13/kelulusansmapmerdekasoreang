package com.smapmerdeksasoreang.smapmeredekasoreang.service;

import com.smapmerdeksasoreang.smapmeredekasoreang.dao.SiswaDao;
import com.smapmerdeksasoreang.smapmeredekasoreang.model.Siswa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
@Service
public class SiswaService {

    @Autowired
    SiswaDao siswaDaoImpl;

    public Collection<Siswa> getSiswa(){
        return siswaDaoImpl.getSiswa();
    }



    public void addSiswa(Siswa siswa) {
        siswaDaoImpl.addSiswa(siswa);
    }

    public Optional<Siswa> getSiswaByNis(String nis) {
        return siswaDaoImpl.getSiswaByNis(nis);
    }
}
