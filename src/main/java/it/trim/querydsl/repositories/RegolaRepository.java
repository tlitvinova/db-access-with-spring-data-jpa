package it.trim.querydsl.repositories;

import it.trim.querydsl.entities.QRegola;
import it.trim.querydsl.entities.Regola;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RegolaRepository extends JpaRepository<Regola,String>, QueryDslPredicateExecutor<Regola> {
}
