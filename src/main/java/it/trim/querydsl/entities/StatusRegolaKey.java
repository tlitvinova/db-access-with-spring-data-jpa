package it.trim.querydsl.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class StatusRegolaKey implements Serializable {
    private static final long serialVersionUID = -1896668548463913759L;
    private Regola regola;
    private ProcessoStatus procStatus;
    
    public StatusRegolaKey(Regola regola, ProcessoStatus procStatus) {
        this.regola = regola;
        this.procStatus = procStatus;
    }
}
