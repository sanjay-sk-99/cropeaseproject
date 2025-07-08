package com.example.CropEase.controller;

import com.example.CropEase.model.Orders;
import com.example.CropEase.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "http://localhost:5500") // Allow frontend access (optional)
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @GetMapping
    public List<Orders> getAllOrders() {
        return ordersService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Optional<Orders> getOrderById(@PathVariable Long id) {
        return ordersService.getOrderById(id);
    }

    @PostMapping
    public Orders createOrder(@RequestBody Orders order) {
        return ordersService.createOrder(order);
    }

    @PutMapping("/{id}")
    public Orders updateOrder(@PathVariable Long id, @RequestBody Orders order) {
        return ordersService.updateOrder(id, order);
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Long id) {
        boolean deleted = ordersService.deleteOrder(id);
        return deleted ? "Order deleted successfully." : "Order not found.";
    }
    @GetMapping("/user/{userId}")
    public List<Orders> getOrdersByUserId(@PathVariable Long userId) {
        return ordersService.getOrdersByUserId(userId);
    }

    @GetMapping("/seller/{sellerId}")
    public List<Orders> getOrdersBySellerId(@PathVariable Long sellerId) {
        return ordersService.getOrdersBySellerId(sellerId);
    }
}
