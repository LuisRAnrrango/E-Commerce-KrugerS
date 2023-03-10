package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Controller.Model.Discount;
import com.example.demo.Service.DiscountService;

@RestController
@RequestMapping("/discount")
public class DiscountController {

    @Autowired
    private DiscountService discountService;


    @GetMapping
    public ResponseEntity<List<Discount>> findAll(){
        List<Discount> categorys = discountService.findAll();
        if(categorys.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(categorys);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Discount>> getById(@PathVariable("id") Integer id){
        Optional<Discount> category = discountService.findDiscountByid(id);
        if(category==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(category);
    }


    @PostMapping("/save")
    public ResponseEntity<Discount> save(@RequestBody Discount discount){

        Discount categoryNew = discountService.save(discount);
        return ResponseEntity.ok(categoryNew);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public void delete(@PathVariable Integer id) {
        discountService.delete(id);
    }


}
