package com.example.project5.Controller;

import com.example.project5.Model.Customer;
import com.example.project5.Service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/get")
    public ResponseEntity getCustomer() {
        return ResponseEntity.status(200).body(customerService.getAllCustomers());
    }

    @PostMapping("/add")
    public ResponseEntity addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
        return ResponseEntity.status(200).body("Customer was added.");
    }

    @PutMapping("/update/{customerId}")
    public ResponseEntity updateCustomer(@RequestBody @Valid Customer customer, @PathVariable Integer customerId) {
        customerService.updateCustomer(customerId, customer);
        return ResponseEntity.status(200).body("Customer updates");
    }

    @DeleteMapping("/delete/{customerId}")
    public ResponseEntity deleteCustomer(@PathVariable Integer customerId) {
        customerService.deleteCustomer(customerId);
        return ResponseEntity.status(200).body("Customer deleted");
    }
}
