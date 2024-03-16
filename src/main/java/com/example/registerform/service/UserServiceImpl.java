package com.example.registerform.service;

import com.example.registerform.dto.UserDto;
import com.example.registerform.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Objects;

public class UserServiceImpl implements UserService {

    @Override
    public UserDto save(User user) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ecommerce-service");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        if (user.getId() != null) {
            throw new RuntimeException("You cannot Assign UserId");
        }
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

        return new UserDto(user.getName(), user.getEmail(), user.getCountry(), user.getRole());

    }

    @Override
    public UserDto update(User user) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ecommerce-service");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(user);

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

        return new UserDto(user.getName(), user.getEmail(), user.getCountry(), user.getRole());

    }

    @Override
    public UserDto get(Long id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ecommerce-service");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        User user = entityManager.find(User.class, id);

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

        return new UserDto(user.getName(), user.getEmail(), user.getCountry(), user.getRole());
    }

    @Override
    public String delete(User user) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ecommerce-service");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        User userToBeDeleted = entityManager.find(User.class, user.getId());

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

        if (!Objects.equals(userToBeDeleted.getId(), user.getId()) ||
                !Objects.equals(userToBeDeleted.getName(), user.getName()) ||
                !Objects.equals(userToBeDeleted.getCountry(), user.getCountry()) ||
                !Objects.equals(userToBeDeleted.getEmail(), user.getEmail()) ||
                !Objects.equals(userToBeDeleted.getPassword(), user.getPassword()) ||
                userToBeDeleted.getRole() != user.getRole()
        ) {
            throw new RuntimeException("Mismatch User Information");
        }
        entityManager.remove(user);

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

        return "User deleted with id" + user.getId();
    }
}
