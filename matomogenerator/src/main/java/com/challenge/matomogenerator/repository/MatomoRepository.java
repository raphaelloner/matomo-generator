package com.challenge.matomogenerator.repository;

import com.challenge.matomogenerator.data.MatomoData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatomoRepository extends JpaRepository<MatomoData,Long> {
    boolean existsByNameAndNamespace(String name, String namespace);
}
