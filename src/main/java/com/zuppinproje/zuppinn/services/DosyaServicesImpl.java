package com.zuppinproje.zuppinn.services;

import com.zuppinproje.zuppinn.models.Dosya;
import com.zuppinproje.zuppinn.models.Musteri;
import com.zuppinproje.zuppinn.repositories.DosyaRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Service
public class DosyaServicesImpl implements DosyaServices {

    @Autowired
    private DosyaRepositories dosyaRepositories;
    @Autowired
    private MusteriServices musteriServices;

    @Override
    public Dosya saveDosya(MultipartFile file, String email) throws Exception {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Dosya dosya = new Dosya();
        dosya.setDosyaAdi(fileName);
        dosya.setData(file.getBytes());
        Optional<Musteri> fileSaveMusteri = musteriServices.getMusteri(email);
        if(fileSaveMusteri.isEmpty()) throw new Exception("Müşteri bulunamadı");
        else {
            Musteri asd = fileSaveMusteri.get();
            dosya.setMusteri(asd);
            return dosyaRepositories.save(dosya);
        }
    }
}
