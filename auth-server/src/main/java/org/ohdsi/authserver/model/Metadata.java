package org.ohdsi.authserver.model;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.PrePersist;
import java.util.Date;

@Embeddable
public class Metadata {

    @Column(name = "created_at")
    @Getter
    protected Date createdAt;

    @PrePersist
    private void prePersist() {

        this.createdAt = new Date();
    }
}
