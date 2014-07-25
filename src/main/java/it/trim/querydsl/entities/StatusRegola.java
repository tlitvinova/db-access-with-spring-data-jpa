package it.trim.querydsl.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="F_D_STATUS_REGOLA")
@Getter
@Setter
@IdClass(StatusRegolaKey.class)
public class StatusRegola {
    @Id
    @ManyToOne
    @JoinColumn(name = "COD_REGOLA")
    private Regola regola;

    @Id
    @ManyToOne
    @JoinColumn(name = "ID_PROC_STATUS")
    private ProcessoStatus procStatus;

    @Column(nullable=false)
    private String valore;
}