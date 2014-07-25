package it.trim.querydsl.repositories;

import com.google.common.collect.Lists;
import it.trim.querydsl.entities.QRegola;
import it.trim.querydsl.entities.Regola;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;

@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"classpath:/spring/*.xml"})
public class RegolaRepositoryTest {
    @Autowired
    private RegolaRepository repository;

    @Test
    public void testSelectAll() {
        List<Regola> regole = repository.findAll();
        MatcherAssert.assertThat(regole, hasSize(18));
    }

    @Test
    public void testSelectByCriteria() {
        final QRegola criteria = QRegola.regola;
        List<Regola> regole = Lists.newArrayList(repository.findAll(criteria.codice.startsWith("SGR_W").or(criteria.nome.containsIgnoreCase("us indicia")), criteria.descrizione.desc()));
        MatcherAssert.assertThat(regole, hasSize(7));
    }
}
