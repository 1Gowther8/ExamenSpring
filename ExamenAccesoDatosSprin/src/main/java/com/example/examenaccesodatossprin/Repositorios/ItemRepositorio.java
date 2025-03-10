package com.example.examenaccesodatossprin.Repositorios;

import com.example.examenaccesodatossprin.modelos.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepositorio extends MongoRepository<Item, String> {
    List<Item> findByCategory(String category);
    int countByRateGreaterThan(double rate);

}
