package com.zuppinproje.zuppinn.services;

import com.zuppinproje.zuppinn.dto.FileDTO;
import com.zuppinproje.zuppinn.models.Dosya;
import com.zuppinproje.zuppinn.models.Musteri;
import com.zuppinproje.zuppinn.repositories.FileRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class FileServicesImpl implements FileServices {

    @Autowired
    private FileRepositories fileRepositories;
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
            dosya.setMusteriId(asd.getCustomer_id());
            return fileRepositories.save(dosya);
        }
    }

    @Override
    public List<Dosya> getAllMusteriDosya(Long musteriId) {
        return fileRepositories.findAllByMusteriId(musteriId);
    }

    @Override
    public boolean updateFile(FileDTO filedto) throws IOException {
        Dosya dosya = fileRepositories.findById(filedto.getId()).orElse(null);
       if(filedto.getDosyaAdi() != null) { dosya.setDosyaAdi(filedto.getDosyaAdi()); }
        if(filedto.getFile() != null) { dosya.setData(filedto.getFile().getBytes()); }
        fileRepositories.save(dosya);
        return true;
    }

    @Override
    public boolean deleteFile(FileDTO fileDTO) throws Exception {
       Dosya deletedDosya = fileRepositories.findById(fileDTO.getId()).orElse(null);
       if(deletedDosya == null) throw new Exception("Dosya bulunamadı");
       else fileRepositories.delete(deletedDosya);
        return false;
    }
}
