package com.FathanMFJmartDR.controller;

import com.FathanMFJmartDR.Algorithm;
import com.FathanMFJmartDR.Coupon;
import com.FathanMFJmartDR.Treasury;
import com.FathanMFJmartDR.dbjson.JsonAutowired;
import com.FathanMFJmartDR.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coupon")
public class CouponController implements BasicGetController<Coupon>{
    @JsonAutowired(value = Coupon.class, filepath = "coupon.json")
    public static JsonTable<Coupon> couponTable;

    @GetMapping("/{id}/isUsed")
    boolean isUsed
            (
                    @PathVariable int id
            )
    {
        Coupon coupon = Algorithm.<Coupon>find(couponTable, obj -> obj.id == id);
        if(coupon == null) return false;
        return coupon.isUsed();
    }

    @GetMapping("/{id}/canApply")
    boolean canApply
            (
                    @PathVariable int id,
                    @RequestParam double price,
                    @RequestParam double discount
            )
    {

        Coupon coupon = Algorithm.<Coupon>find(couponTable, obj -> obj.id == id);
        if(coupon == null) return false;
        return coupon.canApply(new Treasury(price, discount));
    }

    @GetMapping("/getAvailable")
    List<Coupon> getAvailable
            (
                    @RequestParam(defaultValue = "0") int page,
                    @RequestParam(defaultValue = "0") int pageSize
            )
    {
        return Algorithm.<Coupon>paginate(couponTable, page, pageSize, obj -> !obj.isUsed());
    }
    @Override
    public JsonTable<Coupon> getJsonTable() { return couponTable; }
}