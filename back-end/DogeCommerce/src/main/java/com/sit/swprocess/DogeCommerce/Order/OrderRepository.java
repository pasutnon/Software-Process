package com.sit.swprocess.DogeCommerce.Order;

import com.sit.swprocess.DogeCommerce.OrderDetail.OrderDetail;
import com.sit.swprocess.DogeCommerce.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    public List<Order> findByBuyer(User buyer);
}
