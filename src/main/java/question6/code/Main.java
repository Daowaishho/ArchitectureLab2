package question6.code;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            Customer shallowCloneCustomerA = new ShallowCloneCustomer();
            Address addressA = new Address();
            shallowCloneCustomerA.setAddress(addressA);
            Customer shallowCloneCustomerB = shallowCloneCustomerA.clone();
            System.out.println("浅克隆的Customer是否相同?\n"+(shallowCloneCustomerA == shallowCloneCustomerB));
            System.out.println("浅克隆的Address是否相同?\n"+(shallowCloneCustomerA.getAddress() == shallowCloneCustomerB.getAddress()));
            Customer deepCloneCustomerA = new DeepCloneCustomer();
            Address addressB = new Address();
            deepCloneCustomerA.setAddress(addressB);
            Customer deepCloneCustomerB = deepCloneCustomerA.clone();
            System.out.println("深克隆的Customer是否相同?\n"+(deepCloneCustomerA == deepCloneCustomerB));
            System.out.println("深克隆的Address是否相同?\n"+(deepCloneCustomerA.getAddress() == deepCloneCustomerB.getAddress()));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

class Address implements Serializable{

}

abstract class Customer implements Serializable{
    protected Address address;

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return this.address;
    }
    public abstract Customer clone();
}

class DeepCloneCustomer extends Customer implements Serializable {
    @Override
    public Customer clone() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(this);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            return (DeepCloneCustomer)objectInputStream.readObject();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

class ShallowCloneCustomer extends Customer{
    @Override
    public Customer clone() {
        Customer customer = new ShallowCloneCustomer();
        customer.setAddress(this.address);
        return customer;
    }
}