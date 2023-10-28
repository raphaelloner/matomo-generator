package com.challenge.matomogenerator.data;

import com.challenge.matomogenerator.data.request.Metadata;
import com.challenge.matomogenerator.data.request.Spec;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class MatomoDependency {

    private String apiVersion;

    private String kind;

    private Metadata metadata;

    private Spec spec;

    public MatomoDependency(String apiVersion, String kind, Metadata metadata, Spec spec) {
        this.apiVersion = apiVersion;
        this.kind = kind;
        this.metadata = metadata;
        this.spec = spec;
    }

    public MatomoDependency() {
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
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
}
