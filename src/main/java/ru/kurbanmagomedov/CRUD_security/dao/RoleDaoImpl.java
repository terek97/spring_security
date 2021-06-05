package ru.kurbanmagomedov.CRUD_security.dao;

import org.springframework.stereotype.Repository;
import ru.kurbanmagomedov.CRUD_security.models.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Role getRoleById(Long id) {
        TypedQuery<Role> query = entityManager.createQuery(
                "select role from Role role where role.id = :id", Role.class);
        query.setParameter("id", id);

        return query.getSingleResult();
    }


    @Override
    public List<Role> getAllRoles() {
        return entityManager.createQuery("select role from Role role",
                Role.class).getResultList();
    }

    @Override
    public Role getRoleByName(String name) {
        TypedQuery<Role> query = entityManager.createQuery(
                "select role from Role role where role.role = :name", Role.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }
}
