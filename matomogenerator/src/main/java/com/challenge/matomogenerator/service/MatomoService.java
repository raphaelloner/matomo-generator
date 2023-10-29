package com.challenge.matomogenerator.service;

import com.challenge.matomogenerator.data.*;
import org.yaml.snakeyaml.Yaml;

import java.util.List;


public interface MatomoService {
MatomoData saveMatomo(MatomoData matomoData);
List<MatomoDependency> getAllDependencies();
boolean dependencyAlreadyPersistence(MatomoRequest body);
String convertDataToYamlOutput(MatomoData matomoData);
String convertDependencyToYamlstring(MatomoDependency matomoDependency);
MatomoDependency convertDataToDependency(MatomoData matomoData);
MatomoData convertRequestToData(MatomoRequest matomoRequest);
Metadata createMetadata(MatomoData matomoData);
Spec createSpec(MatomoData matomoData);


}
