package com.bus.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.bus.entity.User;
import com.bus.util.HibernateUtil;

public class UserDAO {

    // Used during Registration
    public boolean registerUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        boolean success = false;

        try {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            success = true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return success;
    }

    // Used during Login - returns the matching User, or null if not found
    public User getUserByEmailAndPassword(String email, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        User user = null;

        try {
            String hql = "FROM User WHERE email = :email AND password = :password";
            Query<User> query = session.createQuery(hql, User.class);
            query.setParameter("email", email);
            query.setParameter("password", password);

            List<User> results = query.list();
            if (!results.isEmpty()) {
                user = results.get(0);
            }
        } finally {
            session.close();
        }
        return user;
    }

    // Used during Registration - to check if email is already taken
    public boolean emailExists(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean exists = false;

        try {
            String hql = "FROM User WHERE email = :email";
            Query<User> query = session.createQuery(hql, User.class);
            query.setParameter("email", email);

            exists = !query.list().isEmpty();
        } finally {
            session.close();
        }
        return exists;
    }
}