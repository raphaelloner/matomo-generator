package com.challenge.matomogenerator.data;

import com.challenge.matomogenerator.data.request.Metadata;
import com.challenge.matomogenerator.data.request.Spec;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Value;

public class MatomoDependency {

    @Value("${matomo.dependency.apiversion}")
    private String apiVersion;
    @Value("${matomo.dependency.kind}")
    private String kind;

    private Metadata metadata;

    private Spec spec;

    public MatomoDependency(String apiVersion, String kind, Metadata metadata, Spec spec) {

        this.metadata = metadata;
        this.spec = spec;
    }

    public MatomoDependency() {
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public Spec getSpec() {
        return spec;
    }

    public void setSpec(Spec spec) {
        this.spec = spec;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }
}
