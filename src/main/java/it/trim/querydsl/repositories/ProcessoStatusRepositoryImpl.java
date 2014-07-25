package it.trim.querydsl.repositories;

import com.google.common.base.Strings;
import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.jpa.impl.JPAQuery;
import it.trim.querydsl.entities.ProcessoStatus;
import it.trim.querydsl.entities.QProcessoStatus;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class ProcessoStatusRepositoryImpl implements ProcessoStatusRepositoryCustom {
    @PersistenceContext private EntityManager em;

    @Override
    public List<ProcessoStatus> findByProcesso(String startsWith) {
        JPQLQuery query = new JPAQuery(em);
        query.from(QProcessoStatus.processoStatus);

        if (!Strings.isNullOrEmpty(startsWith)) {
            query.where(QProcessoStatus.processoStatus.processo().nome.startsWithIgnoreCase(startsWith));
        }

        query.leftJoin(QProcessoStatus.processoStatus.processo()).fetch();

        return query.list(QProcessoStatus.processoStatus);
    }
}
