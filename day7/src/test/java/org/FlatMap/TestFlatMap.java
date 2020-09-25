package org.FlatMap;


import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestFlatMap {
    @Test
    public void shouldReturnProvinceWhenProvided() {
        Person person = new Person(new Address(new Province("Ha Noi")));
        assertThat(Person.getProvince(person)).isEqualTo("Ha Noi");
    }

    @Test
    public void shoudReturnThrowProvinceNotFoundWhenProvided() {
        Person person = new Person(new Address());
        Exception exception = assertThrows(ProvinceNotFound.class, () -> Person.getProvince(null));
        String exceptedMessenger = "Da loi roi";
        String actualMessenger = exception.getMessage();
        assertTrue(actualMessenger.contains(exceptedMessenger));
    }

    @Test
    public void shoudReturnThrowProvinceNotFoundWhenProvided1() {
        Person person = new Person(new Address());
        Exception exception = assertThrows(ProvinceNotFound.class, () -> Person.getProvince(new Person(null)));
        String exceptedMessenger = "Da loi roi";
        String actualMessenger = exception.getMessage();
        assertTrue(actualMessenger.contains(exceptedMessenger));
    }

    @Test
    public void shouldReturnThrowProvinceNotFoundWhenProvided2() {
        Person person = new Person(new Address());
        Exception exception = assertThrows(ProvinceNotFound.class, () -> Person.getProvince(new Person(new Address(null))));
        String exceptedMessenger = "Da loi roi";
        String actualMessenger = exception.getMessage();
        assertTrue(actualMessenger.contains(exceptedMessenger));
    }

}
