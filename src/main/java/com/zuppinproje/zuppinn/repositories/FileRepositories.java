package com.zuppinproje.zuppinn.repositories;

import com.zuppinproje.zuppinn.models.Dosya;
import com.zuppinproje.zuppinn.models.Musteri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

@Repository
public interface FileRepositories extends JpaRepository<Dosya, Long> {
    List<Dosya> findAllByMusteriId(Long musteriId);
}
