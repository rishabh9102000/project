package com.cg.orders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.orders.exceptions.IdNotFoundException;
import com.cg.orders.pojos.Orders;
import com.cg.orders.repository.OrderRepository;
import com.cg.orders.services.OrderServices;
import com.cg.orders.services.OrderServicesImpl;


@ExtendWith(MockitoExtension.class)
class OrdersApplicationTests {

	
	@Mock private OrderRepository repo;
    @InjectMocks private OrderServices services = new OrderServicesImpl() ;

    @Test
    void testToGetOrders() throws IdNotFoundException {
        int OrdersId = 232;
        Orders orders = new Orders(232,"ls",1,1);
        
        when(repo.findById(OrdersId)).thenReturn(Optional.of(orders));
        
        assertEquals("ls", services.getOrder(OrdersId).getCustomerName());
    }

}
