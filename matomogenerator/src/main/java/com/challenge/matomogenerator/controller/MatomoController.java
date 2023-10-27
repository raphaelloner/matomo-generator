package com.challenge.matomogenerator.controller;

import com.challenge.matomogenerator.data.Matomo;
import com.challenge.matomogenerator.data.request.MatomoRequest;
import com.challenge.matomogenerator.exception.DuplicateException;
import com.challenge.matomogenerator.service.MatomoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/matomo")
public class MatomoController {
 private final MatomoService matomoService;

    public MatomoController(MatomoService matomoService) {
        this.matomoService = matomoService;
    }

    @PostMapping
    public ResponseEntity<String> saveMatomoDependency(@RequestBody MatomoRequest body) {
        try {
            if (matomoService.dependencyAlreadyPersistence(body)) {
                throw new DuplicateException("There exist already a matomo resource in the database!");
            }
        }
        catch (DuplicateException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
        Matomo matomo = new Matomo();
        matomo.setNamespace(body.getMetadata().getNamespace());
        matomo.setName(body.getMetadata().getName());
        matomo.setHost(body.getSpec().getHost());
        System.out.println(matomoService.saveMatomoDependency(matomo));
        return  ResponseEntity.ok(matomoService.createYamlString(matomo));
    }
}
