package com.murun.addr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by mark on 4/1/16.
 */
@Entity
public class Document {
    @Id
    @GeneratedValue
    private int id;

    private String title;
    private String type;
    private byte[] documentObject;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getDocumentObject() {
        return documentObject;
    }

    public void setDocumentObject(byte[] documentObject) {
        this.documentObject = documentObject;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
