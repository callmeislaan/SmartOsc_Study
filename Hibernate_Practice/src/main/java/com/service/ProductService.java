package com.service;

import com.dao.ProductDAO;
import com.entity.Product;
import com.util.HibernateUtil;

public class ProductService extends CrudService<Product> {

    public ProductService() {
        this.session = HibernateUtil.getSession();
        this.crudDAO = new ProductDAO(session);
    }
}
