package com.example.registerform.service;

import com.example.registerform.dto.UserDto;
import com.example.registerform.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserServiceImpl implements UserService{

    @Override
    public UserDto save(User user) throws Exception {

            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ecommerce-service");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            if(user.getId()!=null){
                throw new Exception("You cannot Assign UserId");
            }
            entityManager.persist(user);
            entityManager.getTransaction().commit();
            entityManager.close();
            entityManagerFactory.close();

            return new UserDto(user.getName(), user.getEmail(), user.getCountry(), user.getRole());

    }

    @Override
    public UserDto update(User user) {
        return null;
    }

    @Override
    public UserDto get(Long id) {
        return null;
    }

    @Override
    public String delete(User user) {
        return null;
    }
}
