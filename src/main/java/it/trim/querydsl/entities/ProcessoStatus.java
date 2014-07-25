package it.trim.querydsl.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "F_D_PROCESSO_STATUS")
@Getter
@Setter
@EqualsAndHashCode(of="idProcStatus")
@NoArgsConstructor
@NamedEntityGraph(name = "ProcessoStatus.processo", attributeNodes = @NamedAttributeNode("processo"))
public class ProcessoStatus {
    @Id
    private BigDecimal idProcStatus;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_PROCESSO", nullable=false)
    private Processo processo;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_STATUS", nullable=false)
    private DecodificaStatus status;
    
    /**
     * Definisce la regola di attribuzione dello stato
     */
    private String keyProcStatus;

    public ProcessoStatus(BigDecimal id) {
        this.idProcStatus = id;
    }
    
    public ProcessoStatus(Long id) {
        this(BigDecimal.valueOf(id));
    }
}