/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablinchapin.tiendaliz.serviceinventory.service;

import com.pablinchapin.tiendaliz.serviceinventory.entity.ProductInventory;
import java.util.Optional;
import org.springframework.validation.annotation.Validated;

/**
 *
 * @author pvargas
 */

@Validated
public interface ProductInventoryService {
    
    Optional<ProductInventory> getProductInventoryByProductId(Long productId);
    
    Iterable<ProductInventory> getProductInventory();
    
}
