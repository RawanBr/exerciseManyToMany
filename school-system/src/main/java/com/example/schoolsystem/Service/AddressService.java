package com.example.schoolsystem.Service;

import com.example.schoolsystem.Api.ApiException;
import com.example.schoolsystem.DTO.AddressDTO;
import com.example.schoolsystem.Model.Address;
import com.example.schoolsystem.Model.Teacher;
import com.example.schoolsystem.Repository.AddressRepository;
import com.example.schoolsystem.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public List<Address> getAddresses () {
        if (addressRepository.findAll().isEmpty()) {
            throw new ApiException("No addresses yet");
        }
        return addressRepository.findAll();
    }


    public void addAddress (AddressDTO addressDTO) {
        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacherId());
        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }

        Address address = new Address(null, addressDTO.getArea(),addressDTO.getStreet(),addressDTO.getBuildingNumber(),teacher);
        addressRepository.save(address);
    }


    public void updateAddress (AddressDTO addressDTO) {
        Address oldaddress = addressRepository.findAddressesById(addressDTO.getTeacherId());
        if (oldaddress == null) {
            throw new ApiException("Address not found");
        }

        oldaddress.setArea(addressDTO.getArea());
        oldaddress.setBuildingNumber(addressDTO.getBuildingNumber());
        oldaddress.setStreet(addressDTO.getStreet());

        addressRepository.save(oldaddress);
    }


    public void deleteAddress (Integer addressId) {
        Address address = addressRepository.findAddressesById(addressId);
        if (address == null) {
            throw new ApiException("Address not found");
        }
        addressRepository.delete(address);
    }

}
