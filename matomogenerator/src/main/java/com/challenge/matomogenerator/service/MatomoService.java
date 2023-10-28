package com.challenge.matomogenerator.service;

import com.challenge.matomogenerator.data.MatomoDatabase;
import com.challenge.matomogenerator.data.MatomoDependency;
import com.challenge.matomogenerator.data.MatomoRequest;
import org.yaml.snakeyaml.Yaml;

import java.util.List;


public interface MatomoService {
MatomoDatabase saveDependency(MatomoDatabase matomoDatabase);
boolean dependencyAlreadyPersistence(MatomoRequest body);
String createYamlOutputString(MatomoDatabase matomoDatabase);
String createYamlString(MatomoDependency matomoDependency);
Yaml createYaml(MatomoDependency matomoDependency);
List<MatomoDependency> getAllDependencies();
MatomoDependency createMatomoDependency(MatomoDatabase matomoDatabase);
MatomoDatabase createMatomoDatabase(MatomoRequest matomoRequest);


}
