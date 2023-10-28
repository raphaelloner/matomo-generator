package com.challenge.matomogenerator.repository;

import com.challenge.matomogenerator.data.MatomoDatabase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatomoRepository extends JpaRepository<MatomoDatabase,Long> {
    boolean existsByNameAndNamespace(String name, String namespace);
}
