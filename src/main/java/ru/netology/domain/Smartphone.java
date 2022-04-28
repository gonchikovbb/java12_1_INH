package ru.netology.domain;

import java.util.Objects;

public class Smartphone extends Product {
    private String made;

    public Smartphone() {
    }

    public Smartphone(int id, String name, int price, String made) {
        super(id, name, price);
        this.made = made;
    }

    public String getMade() {
        return made;
    }

    public void setMade(String made) {
        this.made = made;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Smartphone that = (Smartphone) o;
        return Objects.equals(made, that.made);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), made);
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "made='" + made + '\'' +
                '}';
    }
}
