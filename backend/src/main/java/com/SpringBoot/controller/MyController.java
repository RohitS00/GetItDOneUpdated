package com.SpringBoot.controller;

import com.SpringBoot.DTO.ServiceConsumerDTO;
import com.SpringBoot.entities.ServiceConsumer;
import com.SpringBoot.entities.ServiceProvider;
import com.SpringBoot.entities.Services;
import com.SpringBoot.entities.User;
import com.SpringBoot.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class MyController {
    @Autowired
    ServiceConsumerService serviceConsumerService;
//
    @Autowired
    ServicesService servicesService;
//
    @Autowired
    ServiceProviderService serviceProviderService;
    @Autowired
    UserService userService;
    @Autowired
    ZipcodeService zipcodeService;
    @GetMapping("/")
    public List<Services> getAllServices(){
        return servicesService.getServices();
    }
    @PostMapping("/addService/{SPid}")
    public Services addService(@PathVariable("SPid") int id, @RequestBody Services services) {
        return servicesService.saveService(id,services);
    }
    @PostMapping("/registerUser")
    public User registerUser(@RequestBody User user) throws Exception {
        return userService.register(user);
    }
    @PostMapping("/loginUser")
    public User loginUser(@RequestBody User user) throws Exception {
        return userService.login(user);
    }

    @GetMapping("/{SCid}/selectService/{serviceId}")
    public void selectService(@PathVariable("serviceId") int id,@PathVariable("SCid") int SCId) {
        serviceConsumerService.selectPrefferedService(SCId,id);
    }
    @GetMapping("fetchServiceConsumer/{SCid}")
    public ServiceConsumer getConsumer(@PathVariable("SCid") int id) {
        return serviceConsumerService.getServiceConsumer(id);
    }
    @GetMapping("/fetchServiceByZipcode/{zipCode}")
    public List<Services> findServiceByZipcode(@PathVariable("zipCode") Integer zipCode) {
        return servicesService.findServicesByZipCode(zipCode);
    }
    @GetMapping("/{serviceId}")
    public ResponseEntity<Services> getServiceById(@PathVariable("serviceId") int serviceId) {
        Services service = servicesService.getServiceById(serviceId);
        if (service != null) {
            return ResponseEntity.ok(service);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/serviceProvider/{providerId}/serviceConsumers")
    public List<ServiceConsumerDTO> getServiceConsumersByProviderId(@PathVariable int providerId) {
        ServiceProvider serviceProvider = serviceProviderService.findProvider(providerId);

        if (serviceProvider == null) {
            // Handle the case where the service provider is not found
            return new ArrayList<>();
        }

        List<ServiceConsumerDTO> serviceConsumerDTOs = new ArrayList<>();
        for (Services service : serviceProvider.getServicesList()) {
            for (ServiceConsumer serviceConsumer : service.getServiceConsumerList()) {
                User user = serviceConsumer.getUser();
                ServiceConsumerDTO dto = new ServiceConsumerDTO();
                dto.setName(user.getName());
                dto.setEmail(user.getEmail());
                dto.setServiceTitle(service.getTitle());
                dto.setServiceDescription(service.getDescription());

                serviceConsumerDTOs.add(dto);
            }
        }

        return serviceConsumerDTOs;
    }
    }
