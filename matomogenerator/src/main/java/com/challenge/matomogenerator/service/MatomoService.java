package com.challenge.matomogenerator.service;

import com.challenge.matomogenerator.data.Matomo;
import com.challenge.matomogenerator.data.request.MatomoRequest;


public interface MatomoService {

Matomo saveMatomoDependency(Matomo matomo);
boolean dependencyAlreadyPersistence(MatomoRequest body);

String createYamlString(Matomo matomo);
}
