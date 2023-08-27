package com.learnspring;

import java.math.BigDecimal;

public record ProductItemRequest(String productName, BigDecimal productPrice) {
}
