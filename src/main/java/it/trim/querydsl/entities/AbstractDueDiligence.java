package it.trim.querydsl.entities;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import it.trim.querydsl.persistence.SiNoType;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@MappedSuperclass
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(of="idDd")
@TypeDef(name="si_no", typeClass = SiNoType.class, defaultForType=Boolean.class)
public abstract class AbstractDueDiligence {
    
    @Id
    @GeneratedValue(generator="F_GENERIC_SEQ")
    // TODO [TatianaLitvinova] dichiarare a livello di package?
    @GenericGenerator(name="F_GENERIC_SEQ", strategy="it.trim.querydsl.persistence.CustomGenerator", parameters = {
            @Parameter(name = "sequence", value = "F_SEQ_GENERIC_ID"),
    })    
    private BigDecimal idDd;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_PROCESSO", nullable=false)
    private Processo processo;
    
    @OneToMany(fetch=FetchType.LAZY, mappedBy="dd")
    private List<ClientiCollegati> clientiCollegati;
    
    @OneToMany(fetch=FetchType.LAZY, mappedBy="ddCollegata")
    private List<ClientiCollegati> collegataA;

    @Column(nullable=true)
    private String groupIdCliente;

    @Column(nullable=true)
    private String codLe;

    // Codice punto operativo, ha senso solo per il prodotto
    @Column(nullable=true)
    private String codPo;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="COD_LINGUA", nullable=true)
    private LinguaIso639 lingua;

    @Column(nullable=true)
    private String codPaeseResidenza;

    @Column(nullable=true)
    private String codPaeseNascita;

    @Column(nullable=true)
    private String codPaeseDomicilio;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="COD_STATO_DUE_DIL", nullable=false)
    private DecodificaStatoDd decodificaStatoDd;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_FLUSSO", nullable=true)
    private Flusso flusso;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="COD_TIPO_ENTITY", nullable=true)
    private DecodificaTipoEntity decodificaTipoEntity;

    // Per SGR viene mappato COD_SAE
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="COD_TIPO_INDUSTRIA", nullable=true)
    private TipoIndustriaSae tipoIndustria;

    @Column(nullable=true)
    private String cognomeRagsoc;

    @Column(nullable=true)
    private String nome;

    @Column(nullable=true)
    private String indirizzo;

    @Column(nullable=true)
    private String tin;

    @Column(nullable=true)
    private String giin;

    @Column(nullable=true)
    private Date dataNascita;

    @Column(nullable=true)
    private String idGestore;

    @Column(nullable=true)
    private String idUtente;

    @Type(type="si_no")
    @Column(nullable=false)
    private boolean flagEscluso;

    @Column(nullable=true)
    private BigDecimal saldoAggregato;

    @Column(nullable=false)
    private Date dataAperturaDd;

    @Column(nullable=true)
    private Date dataChiusuraDd;
    
    @Column(nullable=true)
    private Date dataAutocertificazione;

    @Type(type="si_no")
    private boolean flagAutocertificazione;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_STATUS_FINALE", nullable=true)
    private DecodificaStatus decodificaStatusFinale;

    /**
     * Inizialmente viene impostato a flagReportable dello status che viene impostato sulla DD, ma poi potrebbe cambiare in seguito a delle verifiche
     */
    @Type(type="si_no")
    @Column(nullable=false)
    private boolean flagReportable;

    @Type(type="si_no")
    @Column(nullable=false)
    private boolean flagStatusForzato;

    @Column(nullable=true)
    private String idUtenteApertura;

    @Column(nullable=true)
    private String idUtenteChiusura;

    @Column(nullable=true)
    private String motivoAnnullamento;

    @Column(nullable=true)
    private String keyDecision;

    @Type(type="si_no")
    @Column(nullable=false)
    private boolean flagHighValue;

    @Column(nullable=true)
    private String motivoForzatura;

    @Column(nullable=true)
    private String idUtenteForzatura;

    @Column(nullable=true)
    private String codLeUtente;

    @Column(nullable=true)
    private String codPoUtente;

    @Column(nullable=true)
    private String codPoGestore;

    @Column(nullable=true)
    private String codLeGestore;

    @Column(nullable=true)
    private String codTipoProd;

    public AbstractDueDiligence(BigDecimal idDd) {
        this.idDd = idDd;
    }
    
	public Status getStatusFinale() {
		Status status = null;
        if (decodificaStatusFinale != null) {
            status = decodificaStatusFinale.getTipo();
        }
        return status;
	}
	
    public void setStatusFinale(Status status) {
        this.decodificaStatusFinale = new DecodificaStatus(status);
    }

    public StatoDd getStatoDd() {
        StatoDd statoDd = null;
        if (decodificaStatoDd != null) {
            statoDd = decodificaStatoDd.getStato();
        }
        return statoDd;
    }
    
    public void setStatoDd(StatoDd statoDd) {
        this.decodificaStatoDd = new DecodificaStatoDd(statoDd);
    }

//    public TipoCliente getTipoCliente() {
//        TipoCliente tipo = null;
//        if (decodificaTipoCliente != null) {
//            tipo = decodificaTipoCliente.getTipo();
//        }
//        return tipo;
//    }
//    
//    public void setTipoCliente(TipoCliente tipo) {
//        this.decodificaTipoCliente = new DecodificaTipoCliente(tipo);
//    }

    public Status getStatus() {
        // TODO [PRODOTTO] se lo status e' forzato prendere dallo storico l'ultimo status pre-forzatura
    	return getStatusFinale();
    }
    
    public TipoEntity getTipoEntity() {
        return decodificaTipoEntity == null ? null : decodificaTipoEntity.getTipo();
    }
    
    public void setTipoEntity(TipoEntity tipoEntity) {
        this.decodificaTipoEntity = new DecodificaTipoEntity(tipoEntity);
    }

	public List<ClientiCollegati> getClientiCollegatiPerTipo(final TipoCollegamento tipo) {
	    return ImmutableList.copyOf(Iterables.filter(clientiCollegati, new Predicate<ClientiCollegati>() {
            @Override
            public boolean apply(ClientiCollegati input) {
                return input.getTipoCollegamento() == tipo;
            }
        }));
	}
}
