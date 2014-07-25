package it.trim.querydsl.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="F_D_TIPO_ENTITY")
@Getter
@NoArgsConstructor
public class DecodificaTipoEntity {
    @Id
    @Enumerated(EnumType.STRING)
    @Column(name="COD_TIPO_ENTITY")
    private TipoEntity tipo;
    @Column(name="DESC_TIPO_ENTITY", nullable = false)
    private String descrizione;
    
    public DecodificaTipoEntity(TipoEntity tipo) {
        this.tipo = tipo;
    }
}
