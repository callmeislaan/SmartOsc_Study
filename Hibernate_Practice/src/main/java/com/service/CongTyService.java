package com.service;

import com.dao.CongTyDAO;
import com.util.HibernateUtil;

public class CongTyService extends CrudService{
    public CongTyService() {
        this.session = HibernateUtil.getSession();
        this.crudDAO = new CongTyDAO(session);
    }
}
