package com.bus.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.bus.entity.Bus;
import com.bus.util.HibernateUtil;

public class BusDAO {

    // Admin: Add Bus
    public boolean addBus(Bus bus) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        boolean success = false;

        try {
            transaction = session.beginTransaction();
            session.save(bus);
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

    // Used by both Admin and User: View All Buses
    public List<Bus> getAllBuses() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Bus> buses = null;

        try {
            String hql = "FROM Bus";
            Query<Bus> query = session.createQuery(hql, Bus.class);
            buses = query.list();
        } finally {
            session.close();
        }
        return buses;
    }

    // Used when booking/cancelling a ticket, or showing the booking form
    public Bus getBusById(int busId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Bus bus = null;

        try {
            bus = session.get(Bus.class, busId);
        } finally {
            session.close();
        }
        return bus;
    }

    // Admin: Delete Bus
    public boolean deleteBus(int busId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        boolean success = false;

        try {
            transaction = session.beginTransaction();
            Bus bus = session.get(Bus.class, busId);
            if (bus != null) {
                session.delete(bus);
                success = true;
            }
            transaction.commit();
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

    // Used after booking (decrement) or cancelling (increment) a seat
    public boolean updateAvailableSeats(int busId, int newAvailableSeats) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        boolean success = false;

        try {
            transaction = session.beginTransaction();
            Bus bus = session.get(Bus.class, busId);
            if (bus != null) {
                bus.setAvailableSeats(newAvailableSeats);
                session.update(bus);
                success = true;
            }
            transaction.commit();
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
}
