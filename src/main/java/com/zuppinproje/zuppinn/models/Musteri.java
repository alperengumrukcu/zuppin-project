package com.zuppinproje.zuppinn.models;

import javax.persistence.*;

@Entity
public class Musteri {

    @Id
    @GeneratedValue
    private long customer_id;
    @Column
    private String musteriAdSoyad;
    @Column
    private String email;

    public String getMusteriAdSoyad() {
        return musteriAdSoyad;
    }

    public void setMusteriAdSoyad(String musteriAdSoyad) {
        this.musteriAdSoyad = musteriAdSoyad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
