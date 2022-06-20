package com.zuppinproje.zuppinn.controllers;

import com.zuppinproje.zuppinn.models.Dosya;
import com.zuppinproje.zuppinn.models.Musteri;
import com.zuppinproje.zuppinn.services.DosyaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class DosyaController {

    @Autowired
    private DosyaServices dosyaServices;

    @PostMapping("/dosya")
    public ResponseEntity<String> uploadFile(@RequestParam("file")MultipartFile file, @RequestParam String email) throws Exception {
        Dosya dosya = null;
        dosya = dosyaServices.saveDosya(file,email);
        return ResponseEntity.ok("Başarılı");
    }
}
