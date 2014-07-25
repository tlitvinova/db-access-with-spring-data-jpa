package it.trim.querydsl.repositories;

import it.trim.querydsl.entities.ProcessoStatus;

import java.util.List;

public interface ProcessoStatusRepositoryCustom {
    public List<ProcessoStatus> findByProcesso(String startsWith);
}
