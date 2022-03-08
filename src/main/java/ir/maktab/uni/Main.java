package ir.maktab.uni;

import ir.maktab.uni.entity.Address;
import ir.maktab.uni.repository.AddressRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AddressRepository addressRepository=new AddressRepository();
        Address address=new Address(0,"123123","adasd",
                "asdasd","asdasdas","asdasdasd");
        Address save = addressRepository.save(address);
        System.out.println(save.getId());
        List<Address> all = addressRepository.findAll(Address.class);
        all.forEach(System.out::println);
        address.setCity("esfahan");
        addressRepository.update(address);
    }
}
