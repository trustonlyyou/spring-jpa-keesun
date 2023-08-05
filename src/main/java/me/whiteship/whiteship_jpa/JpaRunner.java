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

        Study study = new Study();
        study.setName("Sping Data Jpa");
//        study.setOwner(account);


        // 반드시 한 묶음
//        account.getStudies().add(study);
//        study.setOwner(account);

        // 백기선이였으면 이렇게 메소드를 하나 따서 할 것이다.
        account.addStudy(study);

        Session session = entityManager.unwrap(Session.class);
        session.save(account); // 이렇게도 저장 가능
        session.save(study);
//        entityManager.persist(account);
    }
}
