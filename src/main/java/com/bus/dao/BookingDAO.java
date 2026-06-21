package com.bus.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.bus.entity.Booking;
import com.bus.util.HibernateUtil;

public class BookingDAO {

    // User: Book Ticket
    public boolean addBooking(Booking booking) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        boolean success = false;

        try {
            transaction = session.beginTransaction();
            session.save(booking);
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

    // Admin: View Passengers of a particular Bus
    public List<Booking> getBookingsByBusId(int busId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Booking> bookings = null;

        try {
            String hql = "FROM Booking b JOIN FETCH b.bus JOIN FETCH b.user WHERE b.bus.id = :busId";
            Query<Booking> query = session.createQuery(hql, Booking.class);
            query.setParameter("busId", busId);
            bookings = query.list();
        } finally {
            session.close();
        }
        return bookings;
    }

    // User: My Tickets
    public List<Booking> getBookingsByUserId(int userId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Booking> bookings = null;

        try {
            String hql = "FROM Booking b JOIN FETCH b.bus JOIN FETCH b.user WHERE b.user.id = :userId";
            Query<Booking> query = session.createQuery(hql, Booking.class);
            query.setParameter("userId", userId);
            bookings = query.list();
        } finally {
            session.close();
        }
        return bookings;
    }

    // Admin: View All Bookings
    public List<Booking> getAllBookings() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Booking> bookings = null;

        try {
            String hql = "FROM Booking b JOIN FETCH b.bus JOIN FETCH b.user";
            Query<Booking> query = session.createQuery(hql, Booking.class);
            bookings = query.list();
        } finally {
            session.close();
        }
        return bookings;
    }

    // Used before cancelling, to know which bus/seat to free up
    public Booking getBookingById(int bookingId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Booking booking = null;

        try {
            booking = session.get(Booking.class, bookingId);
        } finally {
            session.close();
        }
        return booking;
    }

    // User: Cancel Ticket
    public boolean cancelBooking(int bookingId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        boolean success = false;

        try {
            transaction = session.beginTransaction();
            Booking booking = session.get(Booking.class, bookingId);
            if (booking != null) {
                session.delete(booking);
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