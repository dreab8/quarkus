package io.quarkus.hibernate.orm.ManyToOne;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Andrea Boriero
 */
@Entity
public class Request {
    @Id
    @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuarioSolicitacao")
    private User userSolicitacao;

    public User getUserSolicitacao() {
        return userSolicitacao;
    }

    public void setUserSolicitacao(User userSolicitacao) {
        this.userSolicitacao = userSolicitacao;
    }
}
