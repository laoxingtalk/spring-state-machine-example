package com.github.laoxingtalk.example.config;

import com.github.laoxingtalk.example.listener.OrderStatePersistChangeListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.recipes.persist.PersistStateMachineHandler;

@Configuration
public class OrderStatePersistConfig {

    @Autowired
    private StateMachineFactory<String, String> orderStateMachineFactory;
    @Autowired
    private OrderStatePersistChangeListener persistStateChangeListener;

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public PersistStateMachineHandler getPersistStateMachineHandler() {
        StateMachine<String,String> orderStateMachine = orderStateMachineFactory.getStateMachine();
        PersistStateMachineHandler handler = new PersistStateMachineHandler(orderStateMachine);
        handler.addPersistStateChangeListener(persistStateChangeListener);
        return handler;
    }

}