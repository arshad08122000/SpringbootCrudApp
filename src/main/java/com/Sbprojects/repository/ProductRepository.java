package com.Sbprojects.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Sbprojects.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
