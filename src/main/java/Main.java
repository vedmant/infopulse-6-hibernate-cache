import entity.AddressType;
import entity.MyPerson;
import entity.MyPhone;
import entity.PhoneType;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        SessionFactory sessionFactory = (SessionFactory) Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();

        MyPhone phone1 = new MyPhone();
        phone1.setType(PhoneType.LAND_LINE);
        phone1.setNumber("123456");

        MyPhone phone2 = new MyPhone();
        phone2.setType(PhoneType.MOBILE);
        phone2.setNumber("111222");

        MyPerson person1 = new MyPerson();
        person1.setName("John");
        person1.setNickName("wild");
        person1.setSum(50);
        person1.setBalance(100);
        person1.getPhones().add(phone1);
        person1.getPhones().add(phone2);
        person1.getAddresses().put(AddressType.HOME, "33 Home st. New York");
        person1.getAddresses().put(AddressType.OFFICE, "77 Office st. New York");

        entityManager.persist(phone1);
        entityManager.persist(phone2);
        entityManager.persist(person1);

        entityManager.getTransaction().commit();
        entityManager.getTransaction().begin();

        MyPerson person2 = new MyPerson();
        person2.setName("Alice");
        person1.setNickName("rough-1");
        person2.setSum(50);
        person2.setBalance(100);
        person2.getPhones().add(phone1);
        person2.getPhones().add(phone2);
        person2.getAddresses().put(AddressType.HOME, "33 Home st. New York");
        person2.getAddresses().put(AddressType.OFFICE, "77 Office st. New York");

        entityManager.persist(person2);

        entityManager.getTransaction().commit();

        entityManager.close();
        sessionFactory.close();
    }
}
