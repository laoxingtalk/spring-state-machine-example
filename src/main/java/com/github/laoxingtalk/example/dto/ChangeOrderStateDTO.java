package com.github.laoxingtalk.example.dto;

import lombok.Data;

@Data
public class ChangeOrderStateDTO {

    private Long orderId;
    private Integer orderEventCode;
}
