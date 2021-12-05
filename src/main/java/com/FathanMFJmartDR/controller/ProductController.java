package com.FathanMFJmartDR.controller;

import com.FathanMFJmartDR.*;
import com.FathanMFJmartDR.dbjson.JsonAutowired;
import org.springframework.web.bind.annotation.*;
import com.FathanMFJmartDR.dbjson.JsonTable;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController implements BasicGetController<Product> {

     @JsonAutowired(value = Product.class, filepath = "F:\\GITHUB OOP\\JMART\\src\\main\\java\\com\\FathanMFJmartDR\\account.json")
    public static JsonTable<Product> productTable;

    @Override
    public JsonTable<Product> getJsonTable() {
        return productTable;
    }


    @GetMapping("/{id}/store")
    List<Product> getProductByStore
            (
                    @PathVariable int id,
                    @RequestParam int page,
                    @RequestParam int pageSize
            )
    {
        return Algorithm.<Product>paginate(getJsonTable(),page,pageSize, p -> (p.accountId == id));
    }

    @PostMapping("/create")
    Product create
            (
                    @RequestParam int accountId,
                    @RequestParam String name,
                    @RequestParam int weight,
                    @RequestParam boolean conditionUsed,
                    @RequestParam double price,
                    @RequestParam double discount,
                    @RequestParam ProductCategory category,
                    @RequestParam byte shipmentPlans
            )
    {
        for(Account account : AccountController.accountTable){
            if(account.id == accountId && account.store != null){
                Product newProduct = new Product(accountId, name, weight, conditionUsed, price, discount, category, shipmentPlans);
                productTable.add(newProduct);
                return newProduct;
            }
        }
        return null;
    }

    @GetMapping("/getFiltered")
    List<Product> getProductByStore
            (
                    @RequestParam(defaultValue="0")  int page,
                    @RequestParam(defaultValue="5")  int pageSize,
                    @RequestParam  int accountId,
                    @RequestParam  String search,
                    @RequestParam  int minPrice,
                    @RequestParam  int maxPrice,
                    @RequestParam  ProductCategory category
            )
    {
        Predicate<Product> pred = p -> ((p.accountId == accountId) && (p.name.toLowerCase().contains(search.toLowerCase())) && (p.price >= minPrice && p.price <= maxPrice) && (p.category == category));
        return Algorithm.<Product>paginate(getJsonTable(),page,pageSize, pred);
    }

}