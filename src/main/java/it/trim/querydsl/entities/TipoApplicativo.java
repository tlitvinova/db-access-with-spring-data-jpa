package it.trim.querydsl.entities;

import java.io.Serializable;

public interface TipoApplicativo<Codice> extends Serializable {
	public Codice getCodice();
}
