package com.example.examenaccesodatossprin.Servicio;

import com.example.examenaccesodatossprin.modelos.Item;
import com.example.examenaccesodatossprin.Repositorios.ItemRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepositorio itemRepositorio;


    public Optional<Item> getItemById(String id) {
        return itemRepositorio.findById(id);
    }

    public Item crearItem(Item item) {
        return itemRepositorio.save(item);
    }


    public void deleteItem(String id) {
        itemRepositorio.deleteById(id);
    }

    public List<Item> obtenerItemPorCategoria(String category) {
        return itemRepositorio.findByCategory(category);
    }


}
