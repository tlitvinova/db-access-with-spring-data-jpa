package it.trim.querydsl.entities;

import it.trim.querydsl.persistence.SiNoType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="F_D_TIPO_INDUSTRIA_SAE")
@Getter
@Setter
@NoArgsConstructor
@TypeDef(name = "si_no", typeClass = SiNoType.class, defaultForType = Boolean.class)
public class TipoIndustriaSae {
    @Id
    @Column(name="COD_TIPO_INDUSTRIA")
    private String codice;
    
    @Column(name="DESC_TIPO_INDUSTRIA", nullable=false)
    private String descrizione;
    
    @Type(type = "si_no")
    @Column(name="FLAG_FFI", nullable=false)
    private boolean flagFfi;

    @Type(type = "si_no")
    @Column(name="FLAG_EX_BO", nullable=false)
    private boolean flagExBo;
    
    @Type(type = "si_no")
    @Column(name="FLAG_PASSIVE", nullable=false)
    private boolean flagPassive;
    
    public TipoIndustriaSae(String codice) {
        this.codice = codice;
    }
}
