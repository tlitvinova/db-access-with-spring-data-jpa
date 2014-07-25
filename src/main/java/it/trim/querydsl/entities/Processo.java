package it.trim.querydsl.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "F_D_PROCESSO")
@Getter
@Setter
@NoArgsConstructor
public class Processo {
    
    @Id
    private BigDecimal idProcesso;

    @Column(name="NOME_PROCESSO", nullable=false)
    private String nome;

    @Column(name="DESC_PROCESSO", nullable=true)
    private String descrizione;

    /**
     * Il nome del processo da visualizzare a video
     */
    @Column(nullable=false)
    private String macroProcesso;

    public Processo(BigDecimal idProcesso) {
        this.idProcesso = idProcesso;
    }
    
    public Processo(long idProcesso) {
        this.idProcesso = BigDecimal.valueOf(idProcesso);
    }
 }