package com.challenge.matomogenerator.service;

import com.challenge.matomogenerator.data.Matomo;
import com.challenge.matomogenerator.data.request.MatomoRequest;

import java.util.List;


public interface MatomoService {
Matomo saveDependency(Matomo matomo);
boolean dependencyAlreadyPersistence(MatomoRequest body);
String createYamlString(Matomo matomo);
List<Matomo> getAllDependencies();

}
