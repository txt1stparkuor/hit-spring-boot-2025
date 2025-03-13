package com.example.buoi1;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("iphone")
@Primary  // Ưu tiên sử dụng bean này khi có nhiều bean cùng loại
class IPhone implements Phone {
    @Override
    public void call() {
        System.out.println("Gọi điện bằng iPhone!");
    }
}
