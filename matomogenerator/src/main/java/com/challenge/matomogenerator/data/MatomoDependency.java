package com.challenge.matomogenerator.data;


public class MatomoDependency {
    private  String apiVersion;
    private String kind;
    private Metadata metadata;
    private Spec spec;

    public MatomoDependency() {
        this.apiVersion = "glasskube.eu/v1alpha1";
        this.kind = "Matomo";
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
}
