package com.example.schoolsystem.Repository;

import com.example.schoolsystem.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    Address findAddressesById(Integer id);
}
