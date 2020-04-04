package com.mycompany.app.dao;

import com.mycompany.app.utils.DBHelper;
import org.hibernate.*;
import com.mycompany.app.model.User;

import java.util.List;
import java.util.Queue;

public class UserHibernateDao implements UserDao {

    private SessionFactory sessionFactory;

    public UserHibernateDao() {
        this.sessionFactory = DBHelper.getSessionFactory();
    }

    //methods
    public void addUser(User user) {
        //example function
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }


    public int deleteUserById(long id) {
        //example hql
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("delete User where id = :id");
        q.setParameter("id", id);
        int i = q.executeUpdate();
        transaction.commit();
        session.close();
        return i;
    }

    public void editUser(long id, String new_name, String new_basic_language) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        User user = new User();
        user.setId(id);
        user.setName(new_name);
        user.setBasic_language(new_basic_language);
        session.update(user);
        tx.commit();
        session.close();
    }

    public User getUserById(long id) throws HibernateException {
        Session session = sessionFactory.openSession();
        return (User) session.get(User.class, id);
    }

    public List<User> getAllUsers() throws HibernateException {
        String hql = "FROM User";
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<User> AllUsers = session.createQuery(hql).list();
        tx.commit();
        session.close();
        return AllUsers;
    }

    public void createTable() {
        System.out.println("this dummy");
    }

    public boolean ifUserExist(String name, String password) {  //вернуть не буль, а просто результат выборки?
        String hql = "FROM User WHERE name = :name AND password = :password";
        Session session = sessionFactory.openSession();
        Query q = session.createQuery(hql);
        q.setParameter("name", name);
        q.setParameter("password", password);
        List list = q.list();
        session.close();
        if(list.size() > 0) {
            return true;
        }
        else {
            return false;
        }
    }


    public String ifUserAdmin(String name, String password) {
        String hql = "FROM User where name = :name AND password = :password";
        Session session = sessionFactory.openSession();
        Query q = session.createQuery(hql);
        q.setParameter("name", name);
        q.setParameter("password", password);
        List list = q.list();
        User user = (User)list.get(0);
        return user.getRole();
    }

    public User getUserByName(String name, String password) {
        Session session = sessionFactory.openSession();
        return (User) session.get(User.class, name);
    }
}
