package it.trim.querydsl.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="F_F_TIPO_PROD_RILEVANTE")
@Getter
@Setter
public class TipoProdRilevante {
    @Id
    @Column(name="COD_TIPO_PROD")
    private String codice;
    
    @Column(name="DESC_TIPO_PROD", nullable=true)
    private String descrizione;
    
    @Column(name="COD_LE", nullable=false)
    private String codiceLegalEntity;
    
    @Column(nullable=false)
    private Date dataAcquisizione;
}