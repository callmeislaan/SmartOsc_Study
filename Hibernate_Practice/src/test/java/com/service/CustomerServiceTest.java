package com.service;

import com.entity.Customer;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

public class CustomerServiceTest {
    @Test
    public void itShouldInsertCustomerReturnCustomerThatInserted() {
        Customer customer = new Customer();
        customer.setName("Yasoa");
        Customer customerResult = new CustomerService().insert(customer);
        assertEquals(customerResult, customer);
    }

    @Test
    public void itShouldSelectAllCustomerReturnAllCustomer() {
        Set<Customer> customerSet= new CustomerService().selectAll();
        assertTrue(customerSet.size() > 0);
    }

    @Test
    public void itShouldSelectCustomerByIdReturnCustomer() {
        Long id = 2L;
        Customer customer = new CustomerService().selectById(id);
        assertThat(customer).isNotNull();
    }

    @Test
    public void itShouldSelectCustomerByIdThrowTExeption() {
        Long id = 1L;
        String actualMessenger = assertThrows(CrudService.TException.class, 
                () -> new CustomerService().selectById(id)).getMessage();
        String messenger = "select by id field!";
        assertEquals(messenger, actualMessenger);
    }

    @Test
    public void itShouldDeleteCustomerByIdThatReturnTrue() {
        Long id = 2L;
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName("Doraemon");
        boolean result = new CustomerService().delete(customer);
        assertTrue(result);
    }

    @Test
    public void itShouldDeleteCustomerByIdThrowTExeption() {
        Long id = 2L;
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName("Doraemon");
        String actualMessenger =
                assertThrows(CrudService.TException.class,
                        () -> new CustomerService().delete(customer)).getMessage();
        String messenger = "delete field!";
        assertEquals(actualMessenger, messenger);
    }

    @Test
    public void itShouldUpdateCustomerThatReturnCustomerUpdated() {
        CustomerService customerService = new CustomerService();
        Customer customer = customerService.selectById(3L);
        customer.setName("Doraemon");
        Customer customerResult = customerService.update(customer);
        assertEquals(customer, customerResult);
    }

    @Test void itShouldUpdateCustomerThrowTExeption() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("updated");
        String actualMessenger = assertThrows(CrudService.TException.class,
                () -> new CustomerService().update(customer)).getMessage();
        String messenger = "update field!";
        assertEquals(messenger, actualMessenger);
    }
}
