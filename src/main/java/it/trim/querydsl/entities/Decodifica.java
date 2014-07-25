package it.trim.querydsl.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

@Getter
@Setter
@MappedSuperclass
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@EqualsAndHashCode(of={"tipo"})
public abstract class Decodifica<Codice extends Serializable, Tipo extends TipoApplicativo<Codice>> implements Comparable<Decodifica<Codice, Tipo>>{
	@Transient
    protected Tipo tipo;

	@Id
	@Column
	protected Codice codice;
	
	@Getter
	@Column
	private String nome;
	
	@Getter
	@Column
	private String descrizione;
	
	public Decodifica() {
	}

	public Decodifica(Tipo tipo) {
	    this.tipo = tipo;
		this.codice = tipo != null ? tipo.getCodice() : null;
	}
	
	public Decodifica(Tipo tipo, String descrizione) {
		this(tipo);
		this.descrizione = descrizione;
	}
	
	public Tipo getTipo() {
        if (tipo == null) {
            @SuppressWarnings("unchecked")
            Type tipoType = Decodifica.getTipo((Class<? extends Decodifica<Codice, Tipo>>) getClass());

            try {
                Method findByCodeMethod = ((Class<?>) tipoType).getMethod("values");
                @SuppressWarnings("unchecked")
                Tipo[] values = (Tipo[]) findByCodeMethod.invoke(null);
                for (Tipo tipo : values) {
                    if (tipo.getCodice().equals(codice)) {
                        this.tipo = tipo;
                        break;
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
	    return tipo;
	}
	
	@SuppressWarnings("rawtypes")
    public String getName() {
		return ((Enum) getTipo()).name();
	}
	
	@SuppressWarnings("unchecked")
	public static <Codice extends Serializable, Tipo extends TipoApplicativo<Codice>> Class<Tipo> getTipo(Class<? extends Decodifica<Codice, Tipo>> tipoDecodifica) {
		// Funziona solo ad 1 livello di ereditarietà
		ParameterizedType decodificaType = (ParameterizedType) tipoDecodifica.getGenericSuperclass();
		Type tipoType = decodificaType.getActualTypeArguments()[1];
		return (Class<Tipo>) tipoType;
	}

	public void setTipo(Tipo tipo) {
	    this.tipo = tipo;
		this.codice = tipo.getCodice();
	}

	@Override
	public String toString() {
		return "Decodifica [codice=" + codice + ", tipo=" + tipo + ", descrizione=" + descrizione	+ "]";
	}

	@SuppressWarnings("unchecked")
	@Override
	public int compareTo(Decodifica<Codice, Tipo> other) {
		return ((Comparable<Tipo>) this.getTipo()).compareTo(other.getTipo());
	}
	
}
