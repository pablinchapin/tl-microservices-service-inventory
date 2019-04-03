/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablinchapin.tiendaliz.serviceinventory.service;

import com.pablinchapin.tiendaliz.serviceinventory.entity.ProductInventory;
import com.pablinchapin.tiendaliz.serviceinventory.repository.ProductInventoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pvargas
 */

@Service
public class ProductInventoryServiceImpl implements ProductInventoryService{

    @Autowired
    private ProductInventoryRepository productInventoryRepository;
    
    
    @Override
    public Iterable<ProductInventory> getProductInventory() {
        return productInventoryRepository.findAll();
    }
        
    
    @Override
    public Optional<ProductInventory> getProductInventoryByProductId(Long productId) {
        return productInventoryRepository.findByProductId(productId);
    }

}
