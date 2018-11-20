package com.sit.swprocess.DogeCommerce.Order;

import com.sit.swprocess.DogeCommerce.Address.ShipmentAddress;
import com.sit.swprocess.DogeCommerce.Address.ShipmentAddressService;
import com.sit.swprocess.DogeCommerce.OrderDetail.OrderDetail;
import com.sit.swprocess.DogeCommerce.OrderDetail.OrderDetailService;
import com.sit.swprocess.DogeCommerce.Payment.Payment;
import com.sit.swprocess.DogeCommerce.Payment.OmisePaymentService;
import com.sit.swprocess.DogeCommerce.Product.Product;
import com.sit.swprocess.DogeCommerce.Product.ProductService;
import com.sit.swprocess.DogeCommerce.Shipment.Shipment;
import com.sit.swprocess.DogeCommerce.Shipment.ShipmentMethod;
import com.sit.swprocess.DogeCommerce.Shipment.ShipmentMethodService;
import com.sit.swprocess.DogeCommerce.Shipment.ShipmentService;
import com.sit.swprocess.DogeCommerce.User.User;
import com.sit.swprocess.DogeCommerce.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
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

    @Autowired
    OrderDetailService orderDetailService;

    @Autowired
    ProductService productService;
    public Optional<Order> getOrderByOrderId(Long orderId) {
        return orderRepository.findById(orderId);
    }

    public List<Order> getOrdersByUserId(Long userId) {
        User user = userService.getUserById(userId).get();
        return orderRepository.findByBuyer(user);
    }

    public Order createOrder(Long userId, Map<String, Object> jsonOrder) {
        List<Map<String, Object>> inputOrderDetails = (List<Map<String, Object>>) jsonOrder.get("orderDetails");

        Order savingOrder = new Order();

        List<OrderDetail> orderDetails = new LinkedList<OrderDetail>();

        for(Map<String, Object> inputOrderDetail: inputOrderDetails) {
            Long productId = Long.parseLong(Integer.toString((int) inputOrderDetail.get("productId")));
            int quantity = (int) inputOrderDetail.get("quantity");

            Product product = productService.getProductById(productId);

            OrderDetail orderDetail = new OrderDetail();

            orderDetail.setPriceEach(product.getPrice());
            orderDetail.setProduct(product);
            orderDetail.setQuantity(quantity);
            orderDetail.setOrder(savingOrder);

            orderDetails.add(orderDetail);
        }


        User buyer = userService.getUserById(userId).get();
        Payment payment = null;
        Long shipmentMethodId = Long.parseLong((String) jsonOrder.get("shipmentMethodId"));
        ShipmentMethod shipmentMethod = shipmentMethodService.getShipmentMethodByShipmentMethodId(shipmentMethodId);
        ShipmentAddress shipmentAddress = shipmentAddressService.saveShipmentAddress(this.makeShipmentAddressModelFromMap((Map<String, Object>)jsonOrder.get("shipmentAddress")));

        Shipment shipment = new Shipment(40.0, null, shipmentAddress, shipmentMethod);

        savingOrder.setPayment(payment);
        savingOrder.setOrderDetails(orderDetails);
        savingOrder.setShipment(shipment);
        savingOrder.setBuyer(buyer);
        savingOrder.setStatus("pending");

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
