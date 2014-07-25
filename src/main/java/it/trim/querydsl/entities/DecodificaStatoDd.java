package it.trim.querydsl.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="F_D_STATO_DUE_DIL")
@Getter
@Setter
@NoArgsConstructor
public class DecodificaStatoDd {
    @Id
    @Enumerated(EnumType.STRING)
    @Column(name="COD_STATO_DUE_DIL")
    private StatoDd stato;

    @Column(name="NOME_STATO", nullable=false)
    private String nome;

    @Column(name="NOME_BREVE_STATO", nullable=false)
    private String nomeBreve;

    @Column(name="DESC_STATO", nullable=true)
    private String descrizione;
    
    public DecodificaStatoDd(StatoDd stato) {
        this.stato = stato;
    }
}