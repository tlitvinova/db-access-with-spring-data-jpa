package it.trim.querydsl.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "F_D_PROFILO")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Profilo {
    @Id
    @Column(name="COD_PROFILO", nullable=false)
    private String codice;
    @Column(name="DESC_BREVE_PROFILO", nullable=false)
    private String descBreve;
    @Column(name="DESC_ESTESA_PROFILO", nullable=true)
    private String descEstesa;
}
