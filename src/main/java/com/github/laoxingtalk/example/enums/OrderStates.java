package com.github.laoxingtalk.example.enums;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public enum OrderStates {

    UNPAID(1, "待支付"),                 // 待支付
    WAITING_DELIVERY(2, "待发货"),       // 待支付
    WAITING_FOR_RECEIVE(3, "待收货"),    // 待收货
    RECEIVE(4, "签收"),                  // 结束
    NOT_RECEIVE(5, "拒收");              // 结束

    private Integer code;
    private String value;

    OrderStates(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public static OrderStates getByCode(Integer code) {
        Optional<OrderStates> optional = Arrays.stream(OrderStates.values())
                .filter(item -> Objects.equals(item.getCode(), code)).findFirst();
        return optional.orElse(null);
    }

    public Integer getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
