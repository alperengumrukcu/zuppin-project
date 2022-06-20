package com.zuppinproje.zuppinn.repositories;

import com.zuppinproje.zuppinn.models.Dosya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DosyaRepositories extends JpaRepository<Dosya, Long> {
}
