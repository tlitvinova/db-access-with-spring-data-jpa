package it.trim.querydsl.entities;

import it.trim.querydsl.persistence.SiNoType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="F_D_PAESE_ISO_3166")
@Getter
@Setter
@TypeDef(name="si_no", typeClass = SiNoType.class, defaultForType=Boolean.class)
public class PaeseIso3166 {
    @Id
    @Column(name="COD_PAESE")
    private String codice;
    
    @Column(name="DESC_PAESE", nullable = false)
    private String descrizione;
    
    @Type(type="si_no")
    @Column(name="FLAG_IGA", nullable = false)
    private boolean flagIga;
    
    @Column(name="COD_UIC")
    private String codUic;
}