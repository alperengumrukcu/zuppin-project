package com.zuppinproje.zuppinn.repositories;

import com.zuppinproje.zuppinn.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepositories extends JpaRepository<Users, Long> {
}
