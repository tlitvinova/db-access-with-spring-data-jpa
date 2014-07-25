package it.trim.querydsl.repositories;

import com.google.common.collect.Lists;
import it.trim.querydsl.entities.ProcessoStatus;
import it.trim.querydsl.entities.QProcessoStatus;
import org.hibernate.LazyInitializationException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/*.xml"})
public class ProcessoStatusRepositoryTest {
    @Autowired private ProcessoStatusRepository repository;

    @PersistenceContext private EntityManager em;

    @Test
    public void testJoinWithProcesso() {
        List<ProcessoStatus> processoStatuses = repository.findAll();

        try {
            assertThat(processoStatuses.get(0).getProcesso().getNome(), notNullValue());
            fail("Should raise LazyInitializationException");
        } catch (LazyInitializationException ex) {

        }

        processoStatuses = repository.findByProcesso("New");
        Assert.assertThat(processoStatuses, hasSize(24));

        assertThat(processoStatuses.get(0).getProcesso().getNome(), notNullValue());
    }

}
