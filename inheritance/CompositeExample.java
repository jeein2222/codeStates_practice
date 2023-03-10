package codeStates.inheritance;
//포함관계

 class Employee{
    int id;
    String name;
    Address address;

     public Employee(int id, String name, Address address) {
         this.id = id;
         this.name = name;
         this.address = address;
     }

     void showInfo(){
         System.out.println(id + " " + name);
         System.out.println(address.city+" "+address.country);
     }
 }

class Address{
     String city, country;

    public Address(String city, String country) {
        this.city = city;
        this.country = country;
    }
}


public class CompositeExample {
    public static void main(String[] args) {
        Address address1 = new Address("서울", "한국");
        Address address2 = new Address("도쿄", "일본");

        Employee e1 = new Employee(1, "Amy", address1);
        Employee e2 = new Employee(2, "Jame", address2);

        e1.showInfo();
        e2.showInfo();

        /*
            1 Amy
            서울 한국
            2 Jame
            도쿄 일본
         */
    }
}
