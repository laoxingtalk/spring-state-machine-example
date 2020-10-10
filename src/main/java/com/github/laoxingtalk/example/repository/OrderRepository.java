package com.github.laoxingtalk.example.repository;


import com.github.laoxingtalk.example.entity.OrderE;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderE, Long> {

}
