package com.challenge.matomogenerator.repository;

import com.challenge.matomogenerator.data.Matomo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatomoRepository extends JpaRepository<Matomo,Long> {
    boolean existsByNameAndNamespace(String name, String namespace);
}
