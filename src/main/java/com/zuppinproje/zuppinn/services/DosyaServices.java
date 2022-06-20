package com.zuppinproje.zuppinn.services;

import com.zuppinproje.zuppinn.models.Dosya;
import com.zuppinproje.zuppinn.models.Musteri;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface DosyaServices {
     Dosya saveDosya(MultipartFile file, String email) throws Exception;
}
