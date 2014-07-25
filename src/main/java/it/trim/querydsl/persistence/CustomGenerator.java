package it.trim.querydsl.persistence;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.SequenceGenerator;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Properties;

public class CustomGenerator extends SequenceGenerator {
    @Override
    public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
        Serializable id = session.getEntityPersister(null, object)
                      .getClassMetadata().getIdentifier(object, session);
        return id != null ? id : super.generate(session, object);
    }
    
    @Override
    public void configure(Type type, Properties params, Dialect dialect) throws MappingException {
        if (System.getProperty("databasePopulation") != null) params.setProperty(PARAMETERS, "START WITH 20100");
        super.configure(type, params, dialect);
    }

}
