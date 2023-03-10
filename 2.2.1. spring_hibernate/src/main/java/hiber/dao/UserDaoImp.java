package hiber.dao;

import hiber.model.User;
import jakarta.persistence.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.TypedQuery;


import java.util.List;

@Repository
public class UserDaoImp implements UserDao {


   private SessionFactory sessionFactory;

   @Autowired
   public UserDaoImp(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
   }

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public User getUserCar(String model, int series) {

      Query query = sessionFactory.getCurrentSession()
              .createQuery("FROM User AS u WHERE u.car.model = :model AND u.car.series = :series ");
      query.setParameter("model",model);
      query.setParameter("series",series);
      User user = (User) query.getSingleResult();
      return user;
   }

}