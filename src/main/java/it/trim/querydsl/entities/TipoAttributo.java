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
@Table(name = "F_D_TIPO_ATTRIBUTO")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of={"codice"})
public class TipoAttributo {
    @Id
    @Column(name="COD_TIPO_ATTRIBUTO")
    private String codice;
    @Column(name="DESC_TIPO_ATTRIBUTO", nullable = false)
    private String descrizione;
    
    public TipoAttributo(String codice) {
        this.codice = codice;
    }
}
