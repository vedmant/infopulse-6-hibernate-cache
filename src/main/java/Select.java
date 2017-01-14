import entity.AddressType;
import entity.MyPerson;
import entity.MyPhone;
import entity.PhoneType;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class Select {

    public static void main(String[] args) {
        SessionFactory sessionFactory = (SessionFactory) Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();

        List<MyPerson> persons = entityManager.createQuery("from entity.MyPerson", MyPerson.class).getResultList();

        persons.forEach(person -> System.out.println(person.getName()));

        entityManager.getTransaction().commit();
        entityManager.close();
        sessionFactory.close();
    }
}
