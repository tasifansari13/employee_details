package com.spring.demo.employeedetails.services;

import com.spring.demo.employeedetails.dto.AddressDto;
import com.spring.demo.employeedetails.dto.EmployeeDto;
import com.spring.demo.employeedetails.entity.AddressEntity;
import com.spring.demo.employeedetails.entity.EmployeeEntity;
import com.spring.demo.employeedetails.repository.AddressRepository;
import com.spring.demo.employeedetails.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;

    @Autowired
    AddressRepository addressRepository;

    public List<EmployeeEntity> getAllEmployees() {
        List<EmployeeEntity> employeeList = repository.findAll();

        if (employeeList.size() > 0) {
            return employeeList;
        } else {
            return new ArrayList<EmployeeEntity>();
        }
    }

    public EmployeeDto getEmployeeById(Long id) throws Exception {


        AddressEntity addressEntity = addressRepository.findById(id).get();

        AddressDto addressDto = AddressDto.builder().id(addressEntity.getId()).city(addressEntity.getCity()).pinCode(addressEntity.getPinCode()).build();

        EmployeeDto employeeDto = EmployeeDto.builder().id(addressEntity.getEmployeeEntity().getId()).firstName(addressEntity.getEmployeeEntity().getFirstName())
                .lastName(addressEntity.getEmployeeEntity().getLastName()).addressDto(addressDto).build();


        return employeeDto;

    }

    public void createOrUpdateEmployee(EmployeeEntity entity) throws Exception {


        repository.save(entity);


    }

    public void deleteEmployeeById(Long id) throws Exception {
        Optional<EmployeeEntity> employee = repository.findById(id);

        if (employee.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new Exception("No employee record exist for given id");
        }
    }

    public EmployeeEntity findDetailsByFirstName(String firstName) {


        return repository.findByFirstName(firstName);

    }

    public AddressDto getEmployeeByAddressId(Long id) {

        EmployeeEntity employeeEntity = repository.findById(id).get();

        EmployeeDto employeeDto = EmployeeDto.builder().id(employeeEntity.getId()).firstName(employeeEntity.getFirstName()).lastName(employeeEntity.getLastName()).build();

        AddressDto addressDto = AddressDto.builder().id(employeeEntity.getAddressEntity().getId()).pinCode(employeeEntity.getAddressEntity().getPinCode())
                .city(employeeEntity.getAddressEntity().getCity()).employeeDto(employeeDto).build();


        return addressDto;
    }

}
