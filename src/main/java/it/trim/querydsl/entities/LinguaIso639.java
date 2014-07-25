package it.trim.querydsl.entities;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="F_D_LINGUA_ISO_639")
@Getter
public class LinguaIso639 {
    @Id
    @Column(name="COD_LINGUA")
    private String codice;

    @Column(name="DESC_LINGUA", nullable = false)
    private String descrizione;
}
