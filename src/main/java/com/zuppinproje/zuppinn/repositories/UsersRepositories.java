package com.zuppinproje.zuppinn.repositories;

import com.zuppinproje.zuppinn.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepositories extends JpaRepository<Users, Long> {
}
