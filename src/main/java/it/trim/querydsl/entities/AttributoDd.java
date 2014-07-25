package it.trim.querydsl.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "F_ATTRIBUTO_DUE_DIL")
@Getter
@Setter
public class AttributoDd {
    @Id
    private BigDecimal idAttributo;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_DD", nullable=false)
    private DueDiligence dd;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="COD_TIPO_ATTRIBUTO", nullable=false)
    private TipoAttributo tipoAttributo;
    
    /**
     * Per alcuni tipi di attributi ci danno anche questo dato, ma noi non lo elaboriamo
     */
    @Column(nullable = true)
    private String idClienteAttributo;

    @Column(nullable = false)
    private String valore;
 }