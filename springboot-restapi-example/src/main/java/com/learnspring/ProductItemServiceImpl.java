package com.learnspring;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductItemServiceImpl implements ProductItemService {

    private final ProductItemRepository repository;

    public ProductItemServiceImpl(ProductItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<List<ProductItem>> getAllProductItems() {
        return Optional.of(repository.findAll());
    }

    @Override
    public Optional<ProductItem> getProductItem(Long id) {
        return repository.findById(id);
    }

    @Override
    public ProductItem createProductItem(ProductItemRequest productItemRequest) {
        ProductItem productItem = new ProductItem();
        productItem.setProductName(productItemRequest.productName());
        productItem.setProductPrice(productItemRequest.productPrice());

        return repository.save(productItem);
    }

    @Override
    public ProductItem updateOrCreateItem(Long id, ProductItemRequest productItemRequest) {
        return repository.findById(id)
                .map(item -> {
                    item.setProductName(productItemRequest.productName());
                    return repository.save(item);
                })
                .orElseGet(() -> {
                    ProductItem productItem = new ProductItem();
                    productItem.setId(id);
                    productItem.setProductName(productItemRequest.productName());
                    productItem.setProductPrice(productItemRequest.productPrice());
                    return repository.save(productItem);
                });

    }

    @Override
    public void deleteProductItemById(Long id) {
        repository.deleteById(id);
    }
}
