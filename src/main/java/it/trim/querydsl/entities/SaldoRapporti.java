package it.trim.querydsl.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@IdClass(SaldoRapportiKey.class)
@Entity
@Table(name = "F_F_SALDO_RAPPORTI")
@Getter
@Setter
public class SaldoRapporti {

    @Id
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "ID_DD")
    private DueDiligence dueDiligence;

    @Id
    private String numRapporto;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "COD_VALUTA", nullable=false)
    private ValutaIso4217 valuta;
    
    @Column(nullable=false)
    private BigDecimal saldoRapporto;

    @Column(nullable=false)
    private Date dataSaldo;
    
    /**
     * Codice tipo prodotto.
     * Non abbiamo l'anagrafica dei tipi prodotto in generale ma solo di quelli rilevanti che quindi non contiene tutti i codici
     */
    @Column(nullable=false)
    private String codTipoProd;
}