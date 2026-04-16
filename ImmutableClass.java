package JavaNotes;

public final class ImmutableClass {
    /*
     * This class shows how we can create a class which is once initialized its value will not change.
     * class should be final so no class can extend it
     */

    private final String name;
    private final int age;
    private final Address address;

    /*
    All fields should be private and final.
    Do not allow setter for fields.
    Mutable object refs should perform deep copy in constructor,
    and return a copy rather than actual ref in getter
     */

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return new Address(address.getCity(), address.getState());
    }

    @Override
    public String toString() {
        return "ImmutableClass{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address.toString() +
                '}';
    }

    public ImmutableClass(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = new Address(address.getCity(), address.getState());
    }
}

class Address {
    private String city;
    private String state;

    public Address(String city, String state) {
        this.city = city;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }
}
