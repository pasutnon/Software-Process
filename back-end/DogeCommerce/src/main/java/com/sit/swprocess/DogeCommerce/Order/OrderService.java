package com.sit.swprocess.DogeCommerce.Order;

import com.sit.swprocess.DogeCommerce.Address.ShipmentAddress;
import com.sit.swprocess.DogeCommerce.Address.ShipmentAddressService;
import com.sit.swprocess.DogeCommerce.OrderDetail.OrderDetail;
import com.sit.swprocess.DogeCommerce.Payment.Payment;
import com.sit.swprocess.DogeCommerce.Payment.OmisePaymentService;
import com.sit.swprocess.DogeCommerce.Shipment.Shipment;
import com.sit.swprocess.DogeCommerce.Shipment.ShipmentMethod;
import com.sit.swprocess.DogeCommerce.Shipment.ShipmentMethodService;
import com.sit.swprocess.DogeCommerce.Shipment.ShipmentService;
import com.sit.swprocess.DogeCommerce.User.User;
import com.sit.swprocess.DogeCommerce.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserService userService;

    @Autowired
    OmisePaymentService omisePaymentService;

    @Autowired
    ShipmentService shipmentService;

    @Autowired
    ShipmentMethodService shipmentMethodService;

    @Autowired
    ShipmentAddressService shipmentAddressService;

    public Optional<Order> getOrderByOrderId(Long orderId) {
        return orderRepository.findById(orderId);
    }

    public List<Order> getOrdersByUserId(Long userId) {
        User user = userService.getUserById(userId).get();
        return orderRepository.findByBuyer(user);
    }

    public Order createOrder(Long userId, Map<String, Object> jsonOrder) {
        List<OrderDetail> orderDetails = (List<OrderDetail>) jsonOrder.get("orderDetails");
        User buyer = userService.getUserById(userId).get();
//        Payment payment = paymentService.getPaymentById(jsonOrder.get("paymentId")+"");
        Payment payment = null;
        Long shipmentMethodId = Long.parseLong(jsonOrder.get("shipmentMethodId")+"");
        ShipmentMethod shipmentMethod = shipmentMethodService.getShipmentMethodByShipmentMethodId(shipmentMethodId);
        ShipmentAddress shipmentAddress = shipmentAddressService.saveShipmentAddress(this.makeShipmentAddressModelFromMap((Map<String, Object>)jsonOrder.get("shipmentAddress")));
        Shipment shipment = new Shipment(0.0, null, shipmentAddress, shipmentMethod);
        Order savingOrder = new Order(orderDetails, payment, shipment, buyer, "pending");
        Order savedOrder = orderRepository.save(savingOrder);
        return savedOrder;
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    private ShipmentAddress makeShipmentAddressModelFromMap(Map<String, Object> mapShipmentAddress) {
        String shipmentName = (String)mapShipmentAddress.get("name");
        String shipmentAddress = (String)mapShipmentAddress.get("address");
        String shipmentDistrict = (String)mapShipmentAddress.get("district");
        String shipmentState = (String)mapShipmentAddress.get("state");
        String shipmentProvince = (String)mapShipmentAddress.get("province");
        String shipmentPostcode = (String)mapShipmentAddress.get("postcode");
        ShipmentAddress address = new ShipmentAddress(
                shipmentName,
                shipmentAddress,
                shipmentDistrict,
                shipmentState,
                shipmentProvince,
                shipmentPostcode
        );
        return address;
    }
}
