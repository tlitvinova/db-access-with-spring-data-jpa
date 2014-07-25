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
public class ClientiCollegatiKey implements Serializable {
    private static final long serialVersionUID = -1940170555063696316L;
    
    private DueDiligence dd;
    private DueDiligence ddCollegata;

    public ClientiCollegatiKey(DueDiligence dd, DueDiligence ddCollegata) {
        this.dd = dd;
        this.ddCollegata = ddCollegata;
    }
}