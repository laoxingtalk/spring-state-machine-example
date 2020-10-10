package com.github.laoxingtalk.example.config;

import com.github.laoxingtalk.example.enums.OrderStates;
import com.github.laoxingtalk.example.enums.OrderEvents;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

@Configuration
@EnableStateMachineFactory(name = "orderStateMachineFactory")
public class OrderStateMachineFactoryConfig extends StateMachineConfigurerAdapter<String, String> {

    @Override
    public void configure(StateMachineStateConfigurer<String, String> states)
            throws Exception {
        states.withStates()
                .initial(OrderStates.UNPAID.name())
                .state(OrderStates.WAITING_DELIVERY.name())
                .state(OrderStates.WAITING_FOR_RECEIVE.name())
                .state(OrderStates.RECEIVE.name())
                .state(OrderStates.NOT_RECEIVE.name());
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<String, String> transitions)
            throws Exception {
        transitions.withExternal()
                .source(OrderStates.UNPAID.name())
                .target(OrderStates.WAITING_DELIVERY.name())
                .event(OrderEvents.PAY.name())
                .and()
                .withExternal()
                .source(OrderStates.WAITING_DELIVERY.name())
                .target(OrderStates.WAITING_FOR_RECEIVE.name())
                .event(OrderEvents.DELIVERY.name())
                .and()
                .withExternal()
                .source(OrderStates.WAITING_FOR_RECEIVE.name())
                .target(OrderStates.RECEIVE.name())
                .event(OrderEvents.RECEIVE.name())
                .and()
                .withExternal()
                .source(OrderStates.WAITING_FOR_RECEIVE.name())
                .target(OrderStates.NOT_RECEIVE.name())
                .event(OrderEvents.NOT_RECEIVE.name());
    }

}