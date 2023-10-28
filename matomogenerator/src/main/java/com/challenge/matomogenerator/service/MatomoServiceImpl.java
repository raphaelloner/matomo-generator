package com.challenge.matomogenerator.service;

import com.challenge.matomogenerator.data.Matomo;
import com.challenge.matomogenerator.data.MatomoDependency;
import com.challenge.matomogenerator.data.request.MatomoRequest;
import com.challenge.matomogenerator.data.request.Metadata;
import com.challenge.matomogenerator.data.request.Spec;
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
    public Matomo saveDependency(Matomo matomo) {

        return matomoRepository.save(matomo);
    }

    @Override
    public boolean dependencyAlreadyPersistence(MatomoRequest body) {
        return matomoRepository.existsByNameAndNamespace(body.getMetadata().getName(),body.getMetadata().getNamespace());
    }

    @Override
    public String createYamlOutputString(Matomo matomo) {
        String yamlContent = "apiVersion: glasskube.eu/v1alpha1\n" +
                "kind: Matomo\n" +
                "metadata:\n" +
                "  name: " + matomo.getName() + "\n" +
                "  namespace: " + matomo.getNamespace() + "\n" +
                "spec:\n" +
                "  host: " + matomo.getHost();
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
    public MatomoDependency createMatomoDependency(Matomo matomo) {
        Metadata metadata = new Metadata();
        metadata.setName(matomo.getName());
        metadata.setNamespace(matomo.getNamespace());
        Spec spec = new Spec();
        spec.setHost(matomo.getHost());
        MatomoDependency matomoDependency = new MatomoDependency();
        matomoDependency.setSpec(spec);
        matomoDependency.setMetadata(metadata);

        return matomoDependency;
    }


}