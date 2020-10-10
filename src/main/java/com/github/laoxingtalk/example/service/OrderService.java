package com.github.laoxingtalk.example.service;

import com.github.laoxingtalk.example.dto.ChangeOrderStateDTO;
import com.github.laoxingtalk.example.dto.CreateOrderDTO;

public interface OrderService {

    void changeState(ChangeOrderStateDTO changeOrderStateDTO);

    void create(CreateOrderDTO createOrderDTO);
}
