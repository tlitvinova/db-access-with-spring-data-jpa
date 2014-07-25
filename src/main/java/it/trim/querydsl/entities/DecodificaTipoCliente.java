package it.trim.querydsl.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="F_D_TIPO_CLIENTE")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class DecodificaTipoCliente {
    @Id
    @Column(name="COD_TIPO_CLIENTE")
    @Enumerated(EnumType.STRING)
    private TipoCliente tipo;
    
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name = "F_D_STATUS_FORZATURA", joinColumns = @JoinColumn(name = "COD_TIPO_CLIENTE"), inverseJoinColumns = @JoinColumn(name = "ID_STATUS"))
    @OrderBy("nome")
    private List<DecodificaStatus> listaStatus;

    @Column(name="DESC_TIPO_CLIENTE", nullable = false)
    private String descrizione;
    
	public DecodificaTipoCliente(TipoCliente tipoCliente) {
		this.tipo = tipoCliente;
	}
}