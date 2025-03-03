package com.example.examenaccesodatossprin.Controladores;

import com.example.examenaccesodatossprin.Servicio.ItemService;
import com.example.examenaccesodatossprin.modelos.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private ItemService itemService;

    //Historia de usuario 1
    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        Item nuevoItem = itemService.crearItem(item);
        return ResponseEntity.ok(nuevoItem);
    }

    //Historia de usuario 2

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable String id) {
        try {
            itemService.deleteItem(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    //Historia de usuario 3
    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable String id) {
        Optional<Item> item = itemService.getItemById(id);
        return item.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Historia de usuario 4

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Item>> getItemsByCategoria(@PathVariable String category) {
        List<Item> items = itemService.obtenerItemPorCategoria(category);
        if (items.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(items);
    }

    //Historia de usuario 5


}
