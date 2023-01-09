package org.acme;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.arc.Unremovable;

@ApplicationScoped
@Unremovable
public class OrderService {

    private final AtomicInteger counter = new AtomicInteger();

    private final Random amount = new Random();
    
    public String createOrder(Order order){
		  return "order: "+order.getId();
    }

    public Order generateOrder() {
        Order order = new Order();
        order.setId(counter.incrementAndGet());
        order.setItem(counter.get() % 2 == 0 ? "Camel" : "ActiveMQ");
        order.setAmount(amount.nextInt(10) + 1);
        order.setDescription(counter.get() % 2 == 0 ? "Camel in Action" : "ActiveMQ in Action");
        return order;
    }

}
