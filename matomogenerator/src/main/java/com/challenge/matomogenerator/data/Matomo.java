package com.challenge.matomogenerator.data;

import jakarta.persistence.*;

@Entity
@Table(name = "matomo")
public class Matomo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matomo_id")
    private Long id;
    @Column(name="matomo_namespace")
    private String namespace;
    @Column(name = "matomo_name")
    private String name;
    @Column(name = "matomo_host")
    private String host;

    public Matomo( String namespace, String name, String host) {

        this.namespace = namespace;
        this.name = name;
        this.host = host;
    }

    public Matomo() {
    }

    public String getNamespace() {return namespace;}

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
