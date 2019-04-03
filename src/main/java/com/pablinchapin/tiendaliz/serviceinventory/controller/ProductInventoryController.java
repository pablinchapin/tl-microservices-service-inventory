/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablinchapin.tiendaliz.serviceinventory.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.pablinchapin.tiendaliz.serviceinventory.entity.ProductInventory;
import com.pablinchapin.tiendaliz.serviceinventory.service.ProductInventoryServiceImpl;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pvargas
 */

@RestController
@Slf4j
@RequestMapping("/inventory/api")
public class ProductInventoryController {
    
    private final ProductInventoryServiceImpl productInventoryService;

    public ProductInventoryController(ProductInventoryServiceImpl productInventoryService) {
        this.productInventoryService = productInventoryService;
    }
    
    
    @GetMapping("/all")
    @HystrixCommand
    public Iterable<ProductInventory> getInventoryAll(){
        log.info("Finding inventory for all product");
        
        return productInventoryService.getProductInventory();
    }
    
    
    @GetMapping("/product/{productId}")
    @HystrixCommand
    public ResponseEntity<ProductInventory> getInventoryByProductId(@PathVariable("productId") Long productId){
    
        log.info("Find inventory for product id: "+ productId);
        
        Optional<ProductInventory> productInventory = productInventoryService.getProductInventoryByProductId(productId);
        
        if(productInventory.isPresent()){
            return new ResponseEntity(productInventory, HttpStatus.OK);
        }else{
                return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
       
    }
    
    
}
