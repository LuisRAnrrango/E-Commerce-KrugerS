package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Controller.Model.Discount;
@Repository
public interface DiscountRepository extends JpaRepository<Discount, Integer>{
    List<Discount> findByName (String name);

}
