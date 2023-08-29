package com.SpringBoot.service;

import com.SpringBoot.DAO.ServicesRepository;
import com.SpringBoot.DAO.ZipcodeRepository;
import com.SpringBoot.entities.ServiceProvider;
import com.SpringBoot.entities.Services;
import com.SpringBoot.entities.Zipcode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicesServiceIMPL implements ServicesService{
    @Autowired
    ServicesRepository servicesRepository;
    @Autowired
    ZipcodeRepository zipcodeRepository;
    @Autowired
    ServiceProviderService serviceProviderService;
    @Autowired
    ZipcodeService zipcodeService;
    @Override
    public List<Services> getServices() {
        return servicesRepository.findAll();
    }
//
    @Override
    public Services saveService(int id, Services services) {
        ServiceProvider serviceProvider = serviceProviderService.findProvider(id);

        if (serviceProvider != null) {
//            services.setServiceProviderList(new ArrayList<ServiceProvider>());
//            services.setServiceProviderList((List<ServiceProvider>) serviceProvider);
//            services.getZipcodesList().add();
            // Initialize the zipcodesList
            List<Zipcode> zipcodes = new ArrayList<>();
            for (Zipcode zipcode : services.getZipcodesList()) {
                Zipcode existingZipcode = zipcodeService.findViaZipcode(zipcode.getZipcode());
                if (existingZipcode == null) {
                    // Zipcode doesn't exist, save it
                    existingZipcode = zipcodeService.add(zipcode);
                }
                zipcodes.add(existingZipcode);
            }
            services.setZipcodesList(zipcodes);
            //new
            services.setServiceProvider(serviceProviderService.findProvider(id));
            Services obj = servicesRepository.save(services);
            List<Services> tempServiceList = serviceProviderService.findProvider(id).getServicesList();
            tempServiceList.add(obj);
            serviceProviderService.findProvider(id).setServicesList(tempServiceList);
            //new


            // Update the service provider's service list
//            List<Services> serviceProviderServices = serviceProvider.getServicesList();
//            serviceProviderServices.add(services);
//            serviceProvider.setServicesList(serviceProviderServices);

            // Save the updated service provider
//            serviceProviderService.saveServiceProvider(serviceProvider);

            return obj;
        } else {
            return null;
        }
    }
//
    @Override

    public Services getServiceById(int id) {
        return servicesRepository.findById(id).orElse(null);
    }
//
    @Override
    public List<Services> findServicesByZipCode(Integer zipCode) {

            Zipcode zipcode = zipcodeRepository.findByZipcode(zipCode);
            if (zipcode != null) {
                return zipcode.getServicesList();
            } else {
                return new ArrayList<>();
            }
        }

}
