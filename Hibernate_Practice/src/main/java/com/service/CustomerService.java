package com.service;

import com.dao.CustomerDAO;
import com.entity.Customer;
import com.util.HibernateUtil;

public class CustomerService extends CrudService<Customer> {

    public CustomerService() {
        this.session = HibernateUtil.getSession();
        this.crudDAO = new CustomerDAO(session);
    }
}
