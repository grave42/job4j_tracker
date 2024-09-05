package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class HbmTracker implements Store, AutoCloseable {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public Item add(Item item) {
        Session session = null;
        try {
            session = sf.openSession();
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        Session session = null;
        boolean result = false;
        try {
            session = sf.openSession();
            session.beginTransaction();
            String hql = "UPDATE Item SET name = :name WHERE id = :id";
            Query query = session.createQuery(hql)
                    .setParameter("name", item.getName())
                    .setParameter("id", id);
            int rowsAffected = query.executeUpdate();
            session.getTransaction().commit();
            result = rowsAffected > 0;
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

    @Override
    public void delete(int id) {
        Session session = null;
        try {
            session = sf.openSession();
            session.beginTransaction();
            String hql = "DELETE FROM Item WHERE id = :id";
            Query query = session.createQuery(hql)
                    .setParameter("id", id);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Item> findAll() {
        Session session = null;
        List<Item> items;
        try {
            session = sf.openSession();
            session.beginTransaction();
            String hql = "FROM Item";
            items = session.createQuery(hql, Item.class).getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return items;
    }

    @Override
    public List<Item> findByName(String key) {
        Session session = null;
        List<Item> items;
        try {
            session = sf.openSession();
            session.beginTransaction();
            String hql = "FROM Item WHERE name = :name";
            items = session.createQuery(hql, Item.class)
                    .setParameter("name", key)
                    .getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return items;
    }

    @Override
    public Item findById(int id) {
        Session session = null;
        Item item;
        try {
            session = sf.openSession();
            session.beginTransaction();
            String hql = "FROM Item WHERE id = :id";
            item = session.createQuery(hql, Item.class)
                    .setParameter("id", id)
                    .uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return item;
    }

    @Override
    public void close() throws Exception {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
