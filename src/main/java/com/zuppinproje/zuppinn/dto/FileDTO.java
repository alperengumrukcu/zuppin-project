package com.zuppinproje.zuppinn.dto;

import lombok.Data;
import org.springframework.lang.Nullable;
import org.springframework.web.multipart.MultipartFile;

@Data
public class FileDTO {

    private Long id;
    @Nullable
    private MultipartFile file;
    @Nullable
    private String dosyaAdi;
}
