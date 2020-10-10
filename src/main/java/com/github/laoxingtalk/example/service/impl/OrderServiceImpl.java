package com.github.laoxingtalk.example.service.impl;

import com.github.laoxingtalk.example.dto.ChangeOrderStateDTO;
import com.github.laoxingtalk.example.dto.CreateOrderDTO;
import com.github.laoxingtalk.example.entity.OrderE;
import com.github.laoxingtalk.example.enums.OrderStates;
import com.github.laoxingtalk.example.exception.OrderBizException;
import com.github.laoxingtalk.example.repository.OrderRepository;
import com.github.laoxingtalk.example.enums.OrderEvents;
import com.github.laoxingtalk.example.service.OrderService;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.recipes.persist.PersistStateMachineHandler;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ObjectFactory<PersistStateMachineHandler> objectFactory;

    @Override
    public void changeState(ChangeOrderStateDTO changeOrderStateDTO) {
        Optional<OrderE> optional = orderRepository.findById(changeOrderStateDTO.getOrderId());
        if (!optional.isPresent()) {
            throw new OrderBizException("没有找到订单");
        }
        OrderE orderE = optional.get();
        Integer orderState = orderE.getOrderState();
        if (orderState == null) {
            throw new OrderBizException("订单状态为空");
        }
        OrderStates orderStates = OrderStates.getByCode(orderState);
        if (orderStates == null) {
            throw new OrderBizException("未知的状态");
        }
        OrderEvents orderEvents = OrderEvents.getByCode(changeOrderStateDTO.getOrderEventCode());
        if (orderEvents == null) {
            throw new OrderBizException("未知的事件");
        }
        Message<String> message = MessageBuilder.withPayload(orderEvents.name()).setHeader("order", orderE).build();
        PersistStateMachineHandler persistStateMachineHandler = objectFactory.getObject();
        boolean isChanged = persistStateMachineHandler.handleEventWithState(message, orderStates.name());
        if (!isChanged) {
            throw new OrderBizException("变更失败");
        }
    }

    @Override
    public void create(CreateOrderDTO createOrderDTO) {
        OrderE orderE = new OrderE();
        orderE.setOrderState(createOrderDTO.getOrderStateCode());
        orderRepository.save(orderE);
    }

}
