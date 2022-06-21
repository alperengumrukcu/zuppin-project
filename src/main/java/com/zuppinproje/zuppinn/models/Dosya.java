package com.zuppinproje.zuppinn.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Dosya {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String dosyaAdi;
    @Column
    private byte[] data;
    @ManyToOne
    @JoinColumn(insertable = false,updatable = false)
    private Musteri musteri;

    @Column(name = "musteri_customer_id")
    private Long musteriId;
}
