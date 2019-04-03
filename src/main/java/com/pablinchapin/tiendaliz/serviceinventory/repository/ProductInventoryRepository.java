/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablinchapin.tiendaliz.serviceinventory.repository;

import com.pablinchapin.tiendaliz.serviceinventory.entity.ProductInventory;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author pvargas
 */
public interface ProductInventoryRepository extends CrudRepository<ProductInventory, Long>{
    
    Optional<ProductInventory> findByProductId(Long productId);
    
}
