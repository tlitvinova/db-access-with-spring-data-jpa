package it.trim.querydsl.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="F_F_CLIENTI_COLLEGATI")
@Getter
@Setter
@IdClass(ClientiCollegatiKey.class)
public class ClientiCollegati {
    @Id
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_DD", nullable=true)
    private DueDiligence dd;
    
    @Id
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_DD_COLLEGATA", nullable=true)
    private DueDiligence ddCollegata;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="COD_TIPO_COLLEG", nullable=true)
    private DecodificaTipoCollegamento decodificaTipoColleg;
    
    public TipoCollegamento getTipoCollegamento() {
        TipoCollegamento tipo = null;
        if (decodificaTipoColleg != null) {
            tipo = decodificaTipoColleg.getTipo();
        }
        return tipo;
    }
    
    public void setTipoCollegamento(TipoCollegamento tipo) {
        this.decodificaTipoColleg = new DecodificaTipoCollegamento(tipo);
    }
}