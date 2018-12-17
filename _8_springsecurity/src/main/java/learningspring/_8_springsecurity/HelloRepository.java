package learningspring._8_springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class HelloRepository {

    @Autowired
    private EntityManager entityManager;

    public List<Hello> getAll() {
        return entityManager
                .createQuery("from Hello", Hello.class)
                .getResultList();
    }

    public Hello save(Hello hello) {
        entityManager.persist(hello);

        return hello;
    }

    public Hello findById(Long id) {
        return entityManager.find(Hello.class, id);
    }
}
