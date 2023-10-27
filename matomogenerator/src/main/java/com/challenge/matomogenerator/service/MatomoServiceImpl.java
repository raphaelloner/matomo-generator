package com.challenge.matomogenerator.service;

import com.challenge.matomogenerator.data.Matomo;
import com.challenge.matomogenerator.data.request.MatomoRequest;
import com.challenge.matomogenerator.repository.MatomoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public String createYamlString(Matomo matomo) {

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
    public List<Matomo> getAllDependencies() {
        return null;
    }


}
