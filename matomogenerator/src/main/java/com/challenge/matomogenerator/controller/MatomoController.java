package com.challenge.matomogenerator.controller;

import com.challenge.matomogenerator.data.Matomo;
import com.challenge.matomogenerator.service.MatomoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/matomo")
public class MatomoController {
 private final MatomoService matomoService;

    public MatomoController(MatomoService matomoService) {
        this.matomoService = matomoService;
    }

    //String yamlContent = "apiVersion: glasskube.eu/v1alpha1\n" +
    //                "kind: Matomo\n" +
    //                "metadata:\n" +
    //                "  name: " + matomo.getName() + "\n" +
    //                "  namespace: " + matomo.getNamespace() + "\n" +
    //                "spec:\n" +
    //                "  host: " + matomo.getHost();
    //        return yamlContent;


    @PostMapping
    public Optional<Matomo> savePost(@RequestBody Matomo matomo){

        return Optional.of(matomoService.saveMatomoDependency(matomo)) ;
    }
}
