package com.njProjectServer.repository;

import com.njProjectServer.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfilesRepository extends JpaRepository<UserProfile, Integer> {
}
