package com.challenge.matomogenerator.controller;

import com.challenge.matomogenerator.data.MatomoData;
import com.challenge.matomogenerator.data.MatomoDependency;
import com.challenge.matomogenerator.data.MatomoRequest;
import com.challenge.matomogenerator.exception.DuplicateException;
import com.challenge.matomogenerator.service.MatomoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matomo")
public class MatomoController {
 private final MatomoService matomoService;

    public MatomoController(MatomoService matomoService) {
        this.matomoService = matomoService;
    }

    @PostMapping
    public ResponseEntity<String> saveMatomoDependency(@RequestBody MatomoRequest matomoRequest) {
        try {
            if (matomoService.dependencyAlreadyPersistence(matomoRequest)) {
                throw new DuplicateException("There exist already a matomo resource in the database!");
            }
        }
        catch (DuplicateException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
        MatomoData matomoData =  matomoService.saveMatomo(matomoService.convertRequestToData(matomoRequest));

        return  ResponseEntity.ok(matomoService.convertDataToYamlOutput(matomoData));
    }
    @GetMapping()
    public List<MatomoDependency> getAllMatomoDependencies(){
        return matomoService.getAllDependencies();
    }

}
