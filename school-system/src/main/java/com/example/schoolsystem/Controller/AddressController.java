package com.example.schoolsystem.Controller;

import com.example.schoolsystem.Api.ApiResponse;
import com.example.schoolsystem.DTO.AddressDTO;
import com.example.schoolsystem.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;


    @GetMapping("/get")
    public ResponseEntity<?> getAddresses () {
        return ResponseEntity.status(200).body(addressService.getAddresses());
    }


    @PostMapping("/add")
    public ResponseEntity<?> addAddress (@RequestBody @Valid AddressDTO addressDTO) {
        addressService.addAddress(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Address added successfully"));
    }


    @PutMapping("/update")
    public ResponseEntity<?> updateAddress (@RequestBody @Valid AddressDTO addressDTO) {
        addressService.updateAddress(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Address updated successfully"));
    }


    @DeleteMapping("delete/{addressId}")
    public ResponseEntity<?> deleteAddress (@PathVariable Integer addressId) {
        addressService.deleteAddress(addressId);
        return ResponseEntity.status(200).body(new ApiResponse("Address deleted successfully"));
    }
}
