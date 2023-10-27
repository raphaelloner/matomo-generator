package com.challenge.matomogenerator.service;

import com.challenge.matomogenerator.data.Matomo;
import org.yaml.snakeyaml.Yaml;

public interface MatomoService {

Matomo saveMatomoDependency(Matomo matomo);

}
