package it.trim.querydsl.entities;

import java.math.BigDecimal;

public enum Status implements TipoApplicativo<BigDecimal> {
	EXEMPT_BENEFICIAL_OWNER(28), 
	US(7), 
	NON_REPORTABLE(8), 
	NON_US(6), 
	NPFFI(24), 
	PFFI(25),
	SGR_OWNER_DOCUMENTED_FI(100),
	SGR_PASSIVE_NFFE(101),
	NON_US_PERSON(102),
	SPECIFIED_US_PERSON(103);

    private BigDecimal codice;

    private Status(int codice) {
        this.codice = BigDecimal.valueOf(codice);
    }

    public BigDecimal getCodice() {
        return codice;
    }
}
