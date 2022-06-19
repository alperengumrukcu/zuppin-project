package com.zuppinproje.zuppinn.controllers;

import com.zuppinproje.zuppinn.models.Musteri;
import com.zuppinproje.zuppinn.services.MusteriServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MusteriControllers {

    @Autowired
    private MusteriServices musteriServices;

    @GetMapping("/musteriler")
    public ResponseEntity<List<Musteri>> getAllMusteri() throws Exception {
        if(musteriServices.getAllMusteri() == null){
            throw new Exception("Müşteriler bulunamadı");
        }
        else return ResponseEntity.ok(musteriServices.getAllMusteri());
    }

    @PostMapping("/musteri")
    public ResponseEntity<Musteri> saveMusteri(@RequestBody Musteri newMusteri) throws Exception {
       if (!musteriServices.getOneMusteri(newMusteri)){
           Musteri savedMusteri = musteriServices.saveMusteri(newMusteri);
           return ResponseEntity.ok(savedMusteri);
       }
        else throw new Exception("Bu müşteri zaten kayıtlı");
    }

    @PutMapping("/musteri")
    public ResponseEntity<Musteri> updateMusteri(@RequestParam String email,@RequestBody Musteri newMusteri) throws Exception {
        Musteri updatedMusteri = musteriServices.updateMusteri(email,newMusteri);
        if(updatedMusteri == null){
            throw new Exception("Kullanıcı bulunamadı");
        }
        else{
            return ResponseEntity.ok(updatedMusteri);
        }
    }
    @DeleteMapping("/musteri/{id}")
    public ResponseEntity<Void> deleteMusteri(@PathVariable Long id){
        musteriServices.deleteMusteri(id);
        return null;
    }
}
