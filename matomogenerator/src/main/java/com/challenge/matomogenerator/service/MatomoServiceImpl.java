package com.challenge.matomogenerator.service;

import com.challenge.matomogenerator.data.Matomo;
import com.challenge.matomogenerator.repository.MatomoRepository;
import org.springframework.stereotype.Service;

@Service
public class MatomoServiceImpl implements MatomoService {

private final MatomoRepository matomoRepository;

    public MatomoServiceImpl(MatomoRepository matomoRepository) {
        this.matomoRepository = matomoRepository;
    }

    @Override
    public Matomo saveMatomoDependency(Matomo matomo) {

        return matomoRepository.save(matomo);
    }


}
