package com.mediaocean.model;

import java.util.ArrayList;

public class Pathway {
    private String type;
    private String id;
    Attribute AttributesObject;
    Link LinksObject;
    ArrayList< Object > relationships = new ArrayList < Object > ();


    // Getter Methods

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public Attribute getAttributes() {
        return AttributesObject;
    }

    public Link getLinks() {
        return LinksObject;
    }

    // Setter Methods

    public void setType(String type) {
        this.type = type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAttributes(Attribute attributesObject) {
        this.AttributesObject = attributesObject;
    }

    public void setLinks(Link linksObject) {
        this.LinksObject = linksObject;
    }
}