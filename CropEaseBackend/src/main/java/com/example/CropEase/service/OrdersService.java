package com.example.CropEase.service;

import com.example.CropEase.model.Orders;
import com.example.CropEase.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    public Optional<Orders> getOrderById(Long id) {
        return ordersRepository.findById(id);
    }

    public Orders createOrder(Orders order) {
        return ordersRepository.save(order);
    }

    public Orders updateOrder(Long id, Orders updatedOrder) {
        return ordersRepository.findById(id).map(order -> {
            order.setOrderStatus(updatedOrder.getOrderStatus());
            order.setVerifyStatus(updatedOrder.getVerifyStatus());
            order.setUserEmail(updatedOrder.getUserEmail());
            order.setUserPhoneNo(updatedOrder.getUserPhoneNo());
            order.setUserName(updatedOrder.getUserName());
            order.setUserId(updatedOrder.getUserId());
            order.setSellerEmail(updatedOrder.getSellerEmail());
            order.setSellerPhoneNo(updatedOrder.getSellerPhoneNo());
            order.setSellerName(updatedOrder.getSellerName());
            order.setSellerId(updatedOrder.getSellerId());
            order.setMachineTitle(updatedOrder.getMachineTitle());
            order.setRegionName(updatedOrder.getRegionName());
            order.setMachineId(updatedOrder.getMachineId());
            order.setMachineName(updatedOrder.getMachineName());
            order.setTotalPrice(updatedOrder.getTotalPrice());
            return ordersRepository.save(order);
        }).orElse(null);
    }

    public boolean deleteOrder(Long id) {
        if (ordersRepository.existsById(id)) {
            ordersRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Orders> getOrdersByUserId(Long userId) {
        return ordersRepository.findByUserId(userId);
    }

    public List<Orders> getOrdersBySellerId(Long sellerId) {
        return ordersRepository.findBySellerId(sellerId);
    }
}
