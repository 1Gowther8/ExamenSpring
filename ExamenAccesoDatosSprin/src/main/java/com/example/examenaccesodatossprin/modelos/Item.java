package com.example.examenaccesodatossprin.modelos;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Items")
@Data
public class Item {
    @Id
    private String _id; // Identificador generado por MongoDB
    private String id;  // Identificador de la API
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
    private double rate;
    private int count;
}
