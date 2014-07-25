package it.trim.querydsl.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "F_D_REGOLA")
@Getter
@Setter
@EqualsAndHashCode(of="codice")
@NoArgsConstructor
public class Regola {
    @Id
    @Column(name="COD_REGOLA")
    private String codice;
    @Column(name="DESC_REGOLA", nullable=true)
    private String descrizione;
    @Column(name="NOME_REGOLA", nullable=true)
    private String nome;
    
    public Regola(String codice) {
        this.codice = codice;
    }
}