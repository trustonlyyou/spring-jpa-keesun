package me.whiteship.whiteship_jpa;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager; // JPA 핵심 ex) ApplicationContext


    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();
        account.setUsername("whiteship");
        account.setPassword("hibernate");

        Session session = entityManager.unwrap(Session.class);
        session.save(account); // 이렇게도 저장 가능
//        entityManager.persist(account);
    }
}
