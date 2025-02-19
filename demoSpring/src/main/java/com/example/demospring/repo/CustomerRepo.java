package com.example.demospring.repo;

import com.example.demospring.model.Customer;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.SortedMap;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    ArrayList<Customer> findCustomersByName(String name);

    @Query ("Select c from Customer c where c.name = :name")
    // @Param to bind
    Customer readCustomerByNameAndAddress(@Param("name") String n);

    @Query("select c from Customer c where c.name like :name")
    ArrayList<Customer> readCustomerSortedByName(@Param("name") String n, Sort sort);

    //    @Query("select c from Customer c where c.address.street like :address")
    //    ArrayList<Customer> readAndSortByAddress(@Param("address") String a, Sort sort);

    // try to find out value of field eg frm c.address.street -> WRONG here! this is ok for JPQL mindset.
    // use underscore in method signature
    ArrayList<Customer> readByAddress_StreetLike(String street);

}
