package com.dao;

import com.entity.CongTy;
import com.entity.Customer;
import com.entity.Khoa;
import org.hibernate.Session;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class CongTyDAO extends CrudDAO<CongTy, Khoa> {

    public CongTyDAO(Session session) {
        this.session = session;
    }

    @Override
    public Optional<Set<CongTy>> selectAll() {
        return Optional.empty();
    }

    @Override
    public Optional<CongTy> selectById(Khoa id) {
        return Optional.ofNullable(session.get(CongTy.class, id));
    }
}
