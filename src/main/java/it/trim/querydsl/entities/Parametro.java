package it.trim.querydsl.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="F_D_PARAMETRO")
@Getter
@Setter
public class Parametro {
    @Id
    @Column(name="ID_PARAM")
    private BigDecimal id;
    
    @Column(name="NOME_PARAM", nullable=false)
    @Enumerated(EnumType.STRING)
    private TipoParametro tipo;
    
    @Column(name="DESC_PARAM", nullable=true)
    private String descrizione;
    
    @Column(name="VALORE_PARAM", nullable=false)
    private String valore;
}