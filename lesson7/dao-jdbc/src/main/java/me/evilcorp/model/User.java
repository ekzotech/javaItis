package me.evilcorp.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ekzotech on 29.11.16.
 */
public class User implements Serializable {
    private final int id;
    private final String name;
    private final int age;
    private final String city;

    private List<Car> cars;

    public User(User user) {
        this(user.getId(),user.getName(),user.getAge(),user.getCity());
    }

    public User(String name, int age, String city) {
        this(0,name,age,city);
    }

    public User(int id, String name, int age, String city) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public List<Car> getCars() {
        return cars;
    }

    public boolean isNew() { return this.id == 0; }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        User user = (User) o;
//
//        if (id != user.id) return false;
//        if (age != user.age) return false;
//        if (!name.equals(user.name)) return false;
//        if (!city.equals(user.city)) return false;
//        return cars.equals(user.cars);
//
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (age != user.age) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return !(city !=null ? !city.equals(user.city) : user.city != null);
//        return cars.equals(user.cars);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + age;
        result = 31 * result + city.hashCode();
        result = 31 * result + cars.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", cars=" + cars +
                '}';
    }
}
