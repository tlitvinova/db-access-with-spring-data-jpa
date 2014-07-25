package it.trim.querydsl.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="F_F_TASSO_CAMBIO")
@Getter
@Setter
public class TassoCambio {
    
    @JoinColumn(name="COD_VALUTA")
    @OneToOne
    private ValutaIso4217 valuta;
    
    @Id
    private String codValuta;
    
    @Column(nullable=false)
    private Date dataValuta;

    @Column(nullable=false)
    private BigDecimal tassoEur;

}