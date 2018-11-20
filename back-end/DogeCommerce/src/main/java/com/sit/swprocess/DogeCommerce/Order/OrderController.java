package com.sit.swprocess.DogeCommerce.Order;

import com.sit.swprocess.DogeCommerce.OrderDetail.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/orders")
@CrossOrigin
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Order>> getOrdersByUserId(@PathVariable Long userId) {
        List<Order> orders = orderService.getOrdersByUserId(userId);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderByOrderId(@PathVariable Long orderId) {
        Optional<Order> order = orderService.getOrderByOrderId(orderId);
        if(order.isPresent() == false) {
            throw new EntityNotFoundException();
        }
        return new ResponseEntity<Order>(order.get(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Order> createOrderByUserId(@RequestBody Map<String, Object> jsonBody) {
        Long userId = Long.parseLong((String) jsonBody.get("buyerId"));
        Order order = orderService.createOrder(userId, jsonBody);
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }
}
