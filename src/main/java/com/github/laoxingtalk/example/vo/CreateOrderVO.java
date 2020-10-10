package com.github.laoxingtalk.example.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CreateOrderVO {

    @NotNull(message = "订单状态码不能为空")
    private Integer orderStateCode;
}
