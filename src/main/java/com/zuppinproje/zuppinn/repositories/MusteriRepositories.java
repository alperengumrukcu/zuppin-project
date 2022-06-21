package com.zuppinproje.zuppinn.repositories;

import com.zuppinproje.zuppinn.models.Musteri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface MusteriRepositories extends JpaRepository<Musteri,Long> {
    Optional<Musteri> findByEmail(String email);
}
