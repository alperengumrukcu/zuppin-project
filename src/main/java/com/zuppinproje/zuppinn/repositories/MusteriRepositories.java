package com.zuppinproje.zuppinn.repositories;

import com.zuppinproje.zuppinn.models.Musteri;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MusteriRepositories extends JpaRepository<Musteri,Long> {
    Optional<Musteri> findByEmail(String email);
}
