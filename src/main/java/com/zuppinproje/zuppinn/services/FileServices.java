package com.zuppinproje.zuppinn.services;

import com.zuppinproje.zuppinn.dto.FileDTO;
import com.zuppinproje.zuppinn.models.Dosya;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileServices {
     Dosya saveDosya(MultipartFile file, String email) throws Exception;
    List<Dosya> getAllMusteriDosya(Long musteriId);
    boolean updateFile(FileDTO filedto) throws IOException;
    boolean deleteFile(FileDTO fileDTO) throws Exception;
}
