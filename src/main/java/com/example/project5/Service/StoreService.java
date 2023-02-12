package com.example.project5.Service;

import com.example.project5.Exception.APIException;
import com.example.project5.Model.Book;
import com.example.project5.Model.Customer;
import com.example.project5.Model.Store;
import com.example.project5.Repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StoreService {

    private StoreRepository storeRepository;
    private CustomerService customerService;


    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    public Store getStoreBy(Integer storeId) {
        Store store = storeRepository.findById(storeId).orElse(null);
        if (store == null)
            throw new APIException("Store not found");
        return store;
    }

    public void addStore(Store store) {
        storeRepository.save(store);
    }

    public void updateStore(Integer storeId, Store store) {
        Store storedStore = storeRepository.findById(storeId).orElse(null);

        if (storedStore == null)
            throw new APIException("Store not found");

        storedStore.setName(store.getName());
        storeRepository.save(storedStore);
    }

    public void deleteStore(Integer storeId) {
        Store store = storeRepository.findById(storeId).orElse(null);
        if (store == null)
            throw new APIException("Store not found");

        storeRepository.deleteById(storeId);
    }

    public List<Book> getAllBooksForStore(Integer storeId) {
        Store store = getStoreBy(storeId);
        return store.getBooks();
    }

    public List<Customer> getAllCustomersForStore(Integer storeId) {
        Store store = getStoreBy(storeId);
        return store.getCustomers();
    }

    public void addCustomerToAStore(Integer storeId, Integer customerId) {
        Store store = getStoreBy(storeId);
        Customer customer = customerService.getCustomerBy(customerId);

        store.getCustomers().add(customer);
        customer.getStores().add(store);
        addStore(store);
        customerService.addCustomer(customer);
    }
}
