package com.example.buoi1;

import org.springframework.stereotype.Component;

// Đánh dấu Phone là một thành phần có thể quản lý bởi Spring
@Component
interface Phone {
    void call();
}
