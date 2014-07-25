package it.trim.querydsl.entities;

public enum TipoCollegamento {
    CGO,
    BO,
    DEL,
    TIT;

	public boolean in(TipoCollegamento... tipi) {
		boolean in = false;
		for (TipoCollegamento tipo : tipi) {
			if (this == tipo) {
				in = true;
				break;
			}
		}
		return in;
	}
}
