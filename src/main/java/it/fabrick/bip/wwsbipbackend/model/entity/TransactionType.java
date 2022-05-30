package it.fabrick.bip.wwsbipbackend.model.entity;

import it.fabrick.bip.wwsbipbackend.model.enumeration.TransactionStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class TransactionType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_enumeration")
    private TransactionStatus enumeration;

    @Column(name = "type_value")
    private String value;

}
