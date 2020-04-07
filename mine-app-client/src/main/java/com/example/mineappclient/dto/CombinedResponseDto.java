package com.example.mineappclient.dto;

import com.example.mineappclient.entity.Car;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CombinedResponseDto<T> {
    private T lCar;
    private String instance;
}

