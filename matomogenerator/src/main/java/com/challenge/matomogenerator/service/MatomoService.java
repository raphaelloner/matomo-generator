package com.challenge.matomogenerator.service;

import com.challenge.matomogenerator.data.Matomo;
import com.challenge.matomogenerator.data.MatomoDependency;
import com.challenge.matomogenerator.data.request.MatomoRequest;
import org.yaml.snakeyaml.Yaml;

import java.util.List;


public interface MatomoService {
Matomo saveDependency(Matomo matomo);
boolean dependencyAlreadyPersistence(MatomoRequest body);
String createYamlString(Matomo matomo);
String createYamlOutputString(Matomo matomo);
Yaml createYaml(MatomoDependency matomoDependency);
List<MatomoDependency> getAllDependencies();
MatomoDependency createMatomoDependency(Matomo matomo);

}
