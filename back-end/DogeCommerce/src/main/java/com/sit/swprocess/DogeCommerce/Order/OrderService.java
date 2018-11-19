package com.sit.swprocess.DogeCommerce.Order;

import com.sit.swprocess.DogeCommerce.User.User;
import com.sit.swprocess.DogeCommerce.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserService userService;

    public Optional<Order> getOrderByOrderId(Long orderId) {
        return orderRepository.findById(orderId);
    }

    public List<Order> getOrdersByUserId(Long userId) {
        User user = userService.getUserById(userId);
        return orderRepository.findByBuyer(user);
    }
}
