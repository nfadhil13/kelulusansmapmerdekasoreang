package com.smapmerdeksasoreang.smapmeredekasoreang.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection= "Siswa")
public class Siswa {

    @Id
    private String nis;
    private String password;
    private String pdfLink;

    public Siswa() {
    }

    public Siswa(String nis, String password, String pdfLink) {
        this.nis = nis;
        this.password = password;
        this.pdfLink = pdfLink;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPdfLink() {
        return pdfLink;
    }

    public void setPdfLink(String pdfLink) {
        this.pdfLink = pdfLink;
    }
}
