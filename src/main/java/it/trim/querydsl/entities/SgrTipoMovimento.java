package it.trim.querydsl.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "F_SGR_TIPO_MOVIMENTO")
@Getter
@Setter
@NoArgsConstructor
public class SgrTipoMovimento {

    @Id
    @Column(name = "COD_TIPO_MOV")
    private String codice;

    @Column(name = "DESC_TIPO_MOV", nullable = false)
    private String descrizione;

    public SgrTipoMovimento(String codice) {
        this.codice = codice;
    }

}
