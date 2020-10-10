package com.github.laoxingtalk.example.controller;

import com.github.laoxingtalk.example.convert.OrderConverts;
import com.github.laoxingtalk.example.service.OrderService;
import com.github.laoxingtalk.example.vo.ChangeOrderStateVO;
import com.github.laoxingtalk.example.vo.CreateOrderVO;
import com.github.laoxingtalk.example.vo.ResponseResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/changeState")
    public ResponseResultVO changeState(@Valid @RequestBody ChangeOrderStateVO vo) {
        orderService.changeState(OrderConverts.toChangeOrderStateDTO(vo));
        return ResponseResultVO.ok();
    }

    @PostMapping("/create")
    public ResponseResultVO create(@Valid @RequestBody CreateOrderVO vo) {
        orderService.create(OrderConverts.toCreateOrderDTO(vo));
        return ResponseResultVO.ok();
    }
}
