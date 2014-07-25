package it.trim.querydsl.entities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "F_FLUSSO")
@Getter
@Setter
@EqualsAndHashCode(of="idFlusso")
@ToString
@NoArgsConstructor
public class Flusso {
    @Id
    @GeneratedValue(generator="F_GENERIC_SEQ")
    @GenericGenerator(name="F_GENERIC_SEQ", strategy="it.trim.querydsl.persistence.CustomGenerator", parameters = {
            @Parameter(name = "sequence", value = "F_SEQ_GENERIC_ID"),
    })    
    private BigDecimal idFlusso;
    
    @Column(nullable = false)
    private Date dataInizioElab;
    
    @Column(nullable = true)
    private Date dataFineElab;

    @Column(name="COD_ESITO_ELAB", nullable = true)
    @Enumerated(EnumType.STRING)
    private EsitoElab esitoElab;

    @Column(nullable = true)
    private String descEsitoElab;
    
    public Flusso(BigDecimal idFlusso) {
        this.idFlusso = idFlusso;
    }
}
