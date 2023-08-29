package com.SpringBoot.service;

import com.SpringBoot.DAO.ServiceConsumerRepository;
import com.SpringBoot.DAO.ServiceProviderRepository;
import com.SpringBoot.DAO.UserRepository;
import com.SpringBoot.entities.ServiceConsumer;
import com.SpringBoot.entities.ServiceProvider;
import com.SpringBoot.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceIMPL implements UserService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    ServiceConsumerRepository serviceConsumerRepository;
    @Autowired
    ServiceProviderRepository serviceProviderRepository;

    @Override
    public User register(User user) throws Exception {
        User obj = userRepository.findByEmail(user.getEmail());
        ServiceConsumer serviceConsumer = new ServiceConsumer();
        serviceConsumer.setUser(user);
        ServiceProvider serviceProvider = new ServiceProvider();
        if (obj != null) {
            throw new Exception("service provider already exist");
        }
        User returnValue = userRepository.save(user);
        if(Objects.equals(user.getRole(), "consumer")){
            System.out.println("consumer is working");
            serviceConsumerRepository.save(serviceConsumer);
        } else if (Objects.equals(user.getRole(), "provider")) {
            serviceProvider.setUser(user);
            serviceConsumerRepository.save(serviceConsumer);
            serviceProviderRepository.save(serviceProvider);
        }
        return returnValue;
    }

    @Override
    public User login(User user) throws Exception {
        User obj= userRepository.findByEmail(user.getEmail());
            if(obj==null) {
                throw new Exception("User didn't exists");
            }
            else if(!user.getPassword().equals(obj.getPassword())) {
                throw new Exception("Bad credentials");
            }

            return obj;
    }

    @Override
    public User getUser(int id) {
        return userRepository.findById(id).orElse(null);
    }


}
