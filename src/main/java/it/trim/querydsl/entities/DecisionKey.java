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
public class DecisionKey implements Serializable {
	private static final long serialVersionUID = -3150580987024644556L;
	
	private DueDiligence dd;
    private Regola regola;

    public DecisionKey(DueDiligence dd, Regola regola) {
		this.dd = dd;
		this.regola = regola;
	}
}