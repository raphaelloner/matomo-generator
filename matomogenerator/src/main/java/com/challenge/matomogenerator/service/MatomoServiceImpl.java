package com.challenge.matomogenerator.service;

import com.challenge.matomogenerator.data.MatomoDatabase;
import com.challenge.matomogenerator.data.MatomoDependency;
import com.challenge.matomogenerator.data.MatomoRequest;
import com.challenge.matomogenerator.data.Metadata;
import com.challenge.matomogenerator.data.Spec;
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
    public MatomoDatabase saveDependency(MatomoDatabase matomoDatabase) {

        return matomoRepository.save(matomoDatabase);
    }

    @Override
    public boolean dependencyAlreadyPersistence(MatomoRequest body) {
        return matomoRepository.existsByNameAndNamespace(body.getMetadata().getName(),body.getMetadata().getNamespace());
    }

    @Override
    public String createYamlOutputString(MatomoDatabase matomoDatabase) {
        String yamlContent = "apiVersion: glasskube.eu/v1alpha1\n" +
                "kind: Matomo\n" +
                "metadata:\n" +
                "  name: " + matomoDatabase.getName() + "\n" +
                "  namespace: " + matomoDatabase.getNamespace() + "\n" +
                "spec:\n" +
                "  host: " + matomoDatabase.getHost();
        System.out.println("yamlContent = " + yamlContent);
        return  yamlContent;
    }

    @Override
    public Yaml createYaml(MatomoDependency matomoDependency) {
       Yaml yaml = new Yaml();
       yaml.dump(matomoDependency);


        return yaml;
    }

    @Override
    public List<MatomoDependency> getAllDependencies() {

        return matomoRepository.findAll().stream().map(value-> createMatomoDependency(value)).collect(Collectors.toList());

    }

    @Override
    public MatomoDependency createMatomoDependency(MatomoDatabase matomoDatabase) {
        Metadata metadata = new Metadata();
        metadata.setName(matomoDatabase.getName());
        metadata.setNamespace(matomoDatabase.getNamespace());
        Spec spec = new Spec();
        spec.setHost(matomoDatabase.getHost());
        MatomoDependency matomoDependency = new MatomoDependency();
        matomoDependency.setSpec(spec);
        matomoDependency.setMetadata(metadata);
        return matomoDependency;
    }


}