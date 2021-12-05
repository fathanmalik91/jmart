package com.FathanMFJmartDR.controller;

import com.FathanMFJmartDR.Algorithm;
import com.FathanMFJmartDR.dbjson.JsonTable;
import com.FathanMFJmartDR.dbjson.Serializable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface BasicGetController <T extends Serializable> {

    @GetMapping("/id")
    default T getById(int id) {
        return Algorithm.<T>find(getJsonTable(), (e) -> e.id==id);
    }




    @GetMapping("/page")
    default @ResponseBody List<T> getPage(@RequestParam(defaultValue="1") int page, @RequestParam(defaultValue="5") int pageSize){
        return Algorithm.<T>paginate(getJsonTable(),page,pageSize,e -> true);
    }
    public abstract JsonTable<T> getJsonTable();
}