package it.trim.querydsl.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="F_DECISION")
@Getter
@Setter
@IdClass(DecisionKey.class)
public class Decision {

	@Id
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_DD", nullable=false)
	private DueDiligence dd;
	
	@Id
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="COD_REGOLA", nullable=false)
    private Regola regola;

	@Column(name="valDecision", nullable=false)
    private String valore;
}