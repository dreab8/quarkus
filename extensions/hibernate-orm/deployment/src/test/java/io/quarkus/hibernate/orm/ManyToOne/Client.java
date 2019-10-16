package io.quarkus.hibernate.orm.ManyToOne;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Andrea Boriero
 */
@Entity
public class Client {
    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private Log log = new Log();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Log getLog() {
        return log;
    }

    public void setLog(Log log) {
        this.log = log;
    }
}
