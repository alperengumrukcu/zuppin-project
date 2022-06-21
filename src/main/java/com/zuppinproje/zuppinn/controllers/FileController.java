package com.zuppinproje.zuppinn.controllers;

import com.zuppinproje.zuppinn.dto.FileDTO;
import com.zuppinproje.zuppinn.models.Dosya;
import com.zuppinproje.zuppinn.models.Musteri;
import com.zuppinproje.zuppinn.services.FileServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@Tag(name = "Dosya")
public class FileController {

    @Autowired
    private FileServices fileServices;

    @PostMapping("/dosya")
    @Operation(description = "Upload File")
    public ResponseEntity<String> uploadFile(@RequestParam("file")MultipartFile file, @RequestParam String email) throws Exception {
        Dosya dosya = null;
        dosya = fileServices.saveDosya(file,email);
        return ResponseEntity.ok("Başarılı");
    }

    @GetMapping("/dosya/{musteriId}")
    public ResponseEntity<List<Dosya>> getAllDosya(@PathVariable Long musteriId){
       return ResponseEntity.ok(fileServices.getAllMusteriDosya(musteriId));
    }

    @PutMapping("/dosya")
    public ResponseEntity<?> updateDosya(FileDTO fileDTO) throws IOException {
        return  ResponseEntity.ok(fileServices.updateFile(fileDTO));
    }
    @DeleteMapping("/dosya")
    public ResponseEntity<Void> deleteDosya(FileDTO fileDTO) throws Exception {
        fileServices.deleteFile(fileDTO);
        return null;
    }
}
