package com.zuppinproje.zuppinn.services;

import com.zuppinproje.zuppinn.models.Musteri;
import com.zuppinproje.zuppinn.repositories.MusteriRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusteriServices {

    @Autowired
    private MusteriRepositories musteriRepositories;

    public List<Musteri> getAllMusteri() {
        return musteriRepositories.findAll();
    }

    public Musteri saveMusteri(Musteri newMusteri) {
        return musteriRepositories.save(newMusteri);
    }

    public boolean getOneMusteri(Musteri newMusteri) {
        Optional<Musteri> optionalMusteri = musteriRepositories.findByEmail(newMusteri.getEmail());
        if(optionalMusteri.orElse(null)==null){
            return false;
        } else return true;
    }

    public Musteri updateMusteri(String email,Musteri newMusteri) {
        try {
            Optional<Musteri> optionalMusteri = musteriRepositories.findByEmail(email);
            if(optionalMusteri.orElse(null)==null){
                return null;
            }
            else {
                Musteri update = optionalMusteri.get();
                update.setMusteriAdSoyad(newMusteri.getMusteriAdSoyad());
                update.setEmail(newMusteri.getEmail());
                return musteriRepositories.save(update);
            }
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public void deleteMusteri(Long id) {
        musteriRepositories.delete(musteriRepositories.getById(id));
    }

    public Optional<Musteri> getMusteri(String email) {
       Optional<Musteri> dbMusteri= musteriRepositories.findByEmail(email);
       if (dbMusteri.isEmpty()) return null;
      else return dbMusteri;
    }
}
