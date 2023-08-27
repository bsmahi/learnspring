package com.learnspring;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductItemController {

    private final ProductItemService service;

    public ProductItemController(ProductItemService service) {
        this.service = service;
    }

    @GetMapping("/productitems")
    public ResponseEntity<List<ProductItem>> getAllProductItems() {
        return ResponseEntity.of(service.getAllProductItems());
    }

    @GetMapping("/productitems/{id}")
    public ResponseEntity<ProductItem> getProductItemById(@PathVariable Long id) {
        return ResponseEntity.of(service.getProductItem(id));
    }

    @PostMapping("/createproductitem")
    public ResponseEntity<ProductItem> createProductItem(@RequestBody ProductItemRequest productItemRequest) {
        return new ResponseEntity<>(service.createProductItem(productItemRequest), HttpStatus.CREATED);
    }

    @DeleteMapping("/productitems/{id}")
    public void deleteProductItemById(@PathVariable Long id) {
        service.deleteProductItemById(id);
    }

    @PutMapping("/productitems/{id}")
    public ResponseEntity<ProductItem> updateProductItem(@PathVariable Long id, @RequestBody ProductItemRequest productItemRequest) {
        return new ResponseEntity<>(service.updateOrCreateItem(id, productItemRequest), HttpStatus.CREATED);
    }
}
