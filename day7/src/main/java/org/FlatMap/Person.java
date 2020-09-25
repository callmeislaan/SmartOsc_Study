package org.FlatMap;

import java.util.Optional;

public class Person {
    private Address address;

    public static String getProvince(Person person) {
        return Optional.ofNullable(person)
                .flatMap(person2 -> Optional.ofNullable(person2.getAddress()))
                .flatMap(address -> Optional.ofNullable(address.getProvince()))
                .flatMap(province -> Optional.ofNullable(province.getPvc()))
                .orElseThrow(() -> new ProvinceNotFound("Da loi roi"));
    }

    public Person(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
}

class ProvinceNotFound extends RuntimeException {
    public ProvinceNotFound(String messenger) {
        super(messenger);
    }
}