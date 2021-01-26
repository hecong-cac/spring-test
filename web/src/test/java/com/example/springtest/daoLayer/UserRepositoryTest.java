package com.example.springtest.daoLayer;

import com.example.springtest.dao.entity.User;
import com.example.springtest.dao.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void beforeEach() {
        entityManager.persist(new User("abc1", "1231231", null));
        entityManager.persist(new User("abc2", "1231232", null));
        entityManager.persist(new User("abc3", "1231233", null));

    }

    @Test
    void testFindUserByName() {
        User abc1 = userRepository.findUserByName("abc1");
        assertThat(abc1).isNotNull();
        assertThat(abc1.getPassword()).isEqualTo("1231231");
        assertThat(abc1.getUserId()).isEqualTo(1L);
    }

}
