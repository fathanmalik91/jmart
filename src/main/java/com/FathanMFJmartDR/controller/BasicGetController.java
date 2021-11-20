package com.FathanMFJmartDR.controller;

import com.FathanMFJmartDR.Algorithm;
import com.FathanMFJmartDR.dbjson.JsonTable;
import com.FathanMFJmartDR.dbjson.Serializable;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface BasicGetController <T extends Serializable> {

    @GetMapping("/id")
    default T getById(int id) {
        return Algorithm.<T>find(getJsonTable(), (e) -> e.id==id);
    }

    JsonTable<T> getJsonTable();


    @GetMapping("/page")
    default List<T> getPage(int page, int pageSize) {
        return Algorithm.<T>paginate(getJsonTable(), page, pageSize, e->true);
    }

}