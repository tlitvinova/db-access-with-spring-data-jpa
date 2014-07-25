package it.trim.querydsl.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="F_D_TIPO_COLLEGAMENTO")
@Getter
@Setter
@NoArgsConstructor
public class DecodificaTipoCollegamento {
    @Id
    @Column(name="COD_TIPO_COLLEG")
    @Enumerated(EnumType.STRING)
    private TipoCollegamento tipo;
    
    @Column(name="DESC_TIPO_COLLEG", nullable = false)
    private String descrizione;
    
    public DecodificaTipoCollegamento(TipoCollegamento tipo) {
        this.tipo = tipo;
    }
    
    @Override
    public String toString() {
        return "DecodificaTipoCollegamento [" + tipo + "]";
    }
}