package com.challenge.matomogenerator.data.request;

public class RequestMatomo {
    private Metadata metadata;
    private Spec spec;

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
