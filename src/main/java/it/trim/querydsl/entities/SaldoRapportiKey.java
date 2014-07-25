package it.trim.querydsl.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.beans.ConstructorProperties;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class SaldoRapportiKey implements Serializable {
    private static final long serialVersionUID = -7114540561147570494L;
    private DueDiligence dueDiligence;
    private String numRapporto;
    
    @ConstructorProperties({"dueDiligence", "numRapporto"})
    public SaldoRapportiKey(DueDiligence dueDiligence, String numRapporto) {
        this.dueDiligence = dueDiligence;
        this.numRapporto = numRapporto;
    }
}