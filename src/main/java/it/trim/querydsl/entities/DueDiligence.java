package it.trim.querydsl.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "F_DUE_DILIGENCE")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class DueDiligence extends AbstractDueDiligence {
    public DueDiligence(BigDecimal idDd) {
        super(idDd);
    }
    public DueDiligence(long idDd) {
        this(BigDecimal.valueOf(idDd));
    }
}
