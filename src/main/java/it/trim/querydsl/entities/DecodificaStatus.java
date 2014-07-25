package it.trim.querydsl.entities;

import it.trim.querydsl.persistence.SiNoType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "F_D_STATUS")
@Getter
@Setter
@NoArgsConstructor
@ToString
@AttributeOverrides({
	@AttributeOverride(name="codice", column=@Column(name="ID_STATUS")),
	@AttributeOverride(name="nome", column=@Column(name="NOME_STATUS")),
	@AttributeOverride(name="descrizione", column=@Column(name="DESC_STATUS"))
})
@TypeDef(name="si_no", typeClass = SiNoType.class, defaultForType=Boolean.class)
public class DecodificaStatus extends Decodifica<BigDecimal, Status> {
    @Column(name="FLAG_REPORTABLE", nullable=false)
    @Type(type="si_no")
    private boolean flagReportable;
    
    /**
     * Peso che viene dato allo stato, serve nei report SGR
     */
    @Column(nullable=true)
    private BigDecimal gracePeriod;

	public DecodificaStatus(Status tipo) {
		super(tipo);
	}
}