package ru.kurbanmagomedov.CRUD_security.dao;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import ru.kurbanmagomedov.CRUD_security.models.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUserById(Long id) {
        TypedQuery<User> query = entityManager.createQuery(
                "select user  from User user where user.id = :id", User.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void setUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void removeUser(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }


    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select user from User user",
                User.class).getResultList();
    }

    @Override
    public User loadUserByUsername(String s) throws UsernameNotFoundException {
        TypedQuery<User> query = entityManager.createQuery(
                "select user  from User user where user.username = :name", User.class);
        query.setParameter("name", s);
        return query.getSingleResult();
    }
}
