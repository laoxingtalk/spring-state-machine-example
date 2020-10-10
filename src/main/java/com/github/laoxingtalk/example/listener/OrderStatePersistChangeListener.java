package com.github.laoxingtalk.example.listener;

import com.github.laoxingtalk.example.entity.OrderE;
import com.github.laoxingtalk.example.enums.OrderStates;
import com.github.laoxingtalk.example.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.recipes.persist.PersistStateMachineHandler;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.transition.Transition;
import org.springframework.stereotype.Component;

@Component
public class OrderStatePersistChangeListener implements PersistStateMachineHandler.PersistStateChangeListener {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void onPersist(State<String, String> state, Message<String> message, Transition<String, String> transition, StateMachine<String, String> stateMachine) {
        if (message != null && message.getHeaders().containsKey("order")) {
            OrderE orderE = message.getHeaders().get("order", OrderE.class);
            String orderStateName = state.getId();
            OrderStates orderStates = OrderStates.valueOf(orderStateName);
            orderE.setOrderState(orderStates.getCode());
            orderRepository.save(orderE);
        }
    }
}
