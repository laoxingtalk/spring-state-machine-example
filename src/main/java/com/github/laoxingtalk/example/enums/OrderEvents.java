package com.github.laoxingtalk.example.enums;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public enum OrderEvents {

    PAY(1, "支付"),
    DELIVERY(2, "发货"),
    RECEIVE(3, "收货"),
    NOT_RECEIVE(4, "拒收货");

    private Integer code;
    private String value;

    OrderEvents(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public static OrderEvents getByCode(Integer code) {
        Optional<OrderEvents> optional = Arrays.stream(OrderEvents.values())
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
