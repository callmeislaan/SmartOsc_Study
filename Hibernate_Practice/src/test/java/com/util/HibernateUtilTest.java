package com.util;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HibernateUtilTest {
    @Test
    public void itShouldGetSession() {
        Session session = HibernateUtil.getSession();
        assertThat(session).isNotNull();
    }
}
