package com.challenge.matomogenerator.data;

public class MatomoRequest {
    private Metadata metadata;
    private Spec spec;

    public MatomoRequest(Metadata metadata, Spec spec) {
        this.metadata = metadata;
        this.spec = spec;
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
