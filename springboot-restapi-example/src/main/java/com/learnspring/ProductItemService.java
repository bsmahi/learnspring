package com.learnspring;

import java.util.List;
import java.util.Optional;

public interface ProductItemService {

    Optional<List<ProductItem>> getAllProductItems();

    Optional<ProductItem> getProductItem(Long id);

    ProductItem createProductItem(ProductItemRequest productItemRequest);

    ProductItem updateOrCreateItem(Long id, ProductItemRequest productItemRequest);

    void deleteProductItemById(Long id);
}
