package com.epam.hackathon.emotional.help.repository;

import com.epam.hackathon.emotional.help.model.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    Optional<ApplicationUser> findByUsername(String username);

    @Transactional
    @Modifying
    @Query("update ApplicationUser a set a.uuid = ?1 where a.username = ?2")
    void updateUuidByUsername(String uuid, String username);

    @Transactional
    @Modifying
    @Query("update ApplicationUser a set a.uuid = ?1 where a.uuid = ?2")
    void updateUuidByUuid(String uuidToFind, String uuid);

    boolean existsByUuid(String uuid);

}
