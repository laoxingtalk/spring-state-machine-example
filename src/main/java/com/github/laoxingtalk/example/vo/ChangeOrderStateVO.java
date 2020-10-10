package com.github.laoxingtalk.example.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ChangeOrderStateVO {

    @NotNull(message = "订单号不能为空")
    private Long orderId;
    @NotNull(message = "订单事件码不能为空")
    private Integer orderEventCode;
}
