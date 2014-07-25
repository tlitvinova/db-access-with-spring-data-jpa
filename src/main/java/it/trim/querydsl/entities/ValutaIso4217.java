package it.trim.querydsl.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="F_D_VALUTA_ISO_4217")
@Getter
@Setter
@EqualsAndHashCode(of="codice")
@NoArgsConstructor
public class ValutaIso4217 implements Serializable {
    private static final long serialVersionUID = 1956008850702589883L;

    @Id
    @Column(name="COD_VALUTA")
    private String codice;
    
    @Column(name="DESC_VALUTA", nullable=false)
    private String descrizione;

    public ValutaIso4217(String codice) {
        this.codice = codice;
    }
}
