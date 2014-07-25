package it.trim.querydsl.repositories;

import com.mysema.query.types.Predicate;
import it.trim.querydsl.entities.ProcessoStatus;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface ProcessoStatusRepository extends JpaRepository<ProcessoStatus, BigDecimal>, QueryDslPredicateExecutor<ProcessoStatus>, ProcessoStatusRepositoryCustom {

}
