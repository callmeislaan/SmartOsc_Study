package com.practice.generic;

public class GenericClass1<T, K> {
    private T t;
    private K k;
    public GenericClass1(T t, K k) {
        this.t = t;
        this.k = k;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public K getK() {
        return k;
    }

    public void setK(K k) {
        this.k = k;
    }
}
