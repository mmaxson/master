package com.murun.legal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Asset {
    @Id
    @GeneratedValue
    private int id;

    private String title;
    private String type;
    private byte[] assetData;

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

    public byte[] getAssetData() {
        return assetData;
    }

    public void setAssetData(byte[] assetData) {
        this.assetData = assetData;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
