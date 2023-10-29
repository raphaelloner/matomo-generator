package com.challenge.matomogenerator.service;

import com.challenge.matomogenerator.data.*;
import com.challenge.matomogenerator.data.MatomoData;
import com.challenge.matomogenerator.repository.MatomoRepository;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.Yaml;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatomoServiceImpl implements MatomoService {

private final MatomoRepository matomoRepository;

    public MatomoServiceImpl(MatomoRepository matomoRepository) {
        this.matomoRepository = matomoRepository;
    }

    @Override
    public MatomoData saveMatomo(MatomoData matomoData) {

        return matomoRepository.save(matomoData);
    }

    @Override
    public boolean dependencyAlreadyPersistence(MatomoRequest body) {
        return matomoRepository.existsByNameAndNamespace(body.getMetadata().getName(),body.getMetadata().getNamespace());
    }

    @Override
    public String convertDataToYamlOutput(MatomoData matomoData) {
        MatomoDependency matomoDependency = convertDataToDependency(matomoData);
        return  convertDependencyToYamlstring(matomoDependency);
    }

    @Override
    public String convertDependencyToYamlstring(MatomoDependency matomoDependency) {
        Yaml yaml = new Yaml();
        return yaml.dumpAsMap(matomoDependency);
    }

    @Override
    public List<MatomoDependency> getAllDependencies() {
        return matomoRepository.findAll().stream().map(this::convertDataToDependency).collect(Collectors.toList());
    }

    @Override
    public MatomoDependency convertDataToDependency(MatomoData matomoData) {
        MatomoDependency matomoDependency = new MatomoDependency();
        Metadata metadata = createMetadata(matomoData);
        Spec spec = createSpec(matomoData);
        matomoDependency.setSpec(spec);
        matomoDependency.setMetadata(metadata);

        return matomoDependency;
    }

    @Override
    public MatomoData convertRequestToData(MatomoRequest matomoRequest) {
        MatomoData matomoData = new MatomoData();
        matomoData.setNamespace(matomoRequest.getMetadata().getNamespace());
        matomoData.setName(matomoRequest.getMetadata().getName());
        matomoData.setHost(matomoRequest.getSpec().getHost());
        return matomoData;
    }
    @Override
    public Metadata createMetadata(MatomoData matomoData) {
        Metadata metadata = new Metadata();
        metadata.setName(matomoData.getName());
        metadata.setNamespace(matomoData.getNamespace());

        return metadata;
    }
    @Override
    public Spec createSpec(MatomoData matomoData) {
        Spec spec = new Spec();
        spec.setHost(matomoData.getHost());
        return spec;
    }


}