package com.example.nerme.alabdallah;

public class Model {
    private String mModelId;
    private String Name;
    private String size;
    private String company;

    public Model() {
    }

    public Model(String mModelId, String name, String company, String size) {
        this.mModelId = mModelId;
        Name = name;
        this.size = size;
        this.company = company;
    }

    public String getmModelId() {
        return mModelId;
    }

    public void setmModelId(String mModelId) {
        this.mModelId = mModelId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
