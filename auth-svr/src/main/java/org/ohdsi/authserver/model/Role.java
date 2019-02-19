package org.ohdsi.authserver.model;


import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @SequenceGenerator(name = "role_generator", sequenceName = "role_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "role_generator")
    @Getter
    private Integer id;

    @Column(name = "name")
    @Getter
    private String name;

    @Embedded
    private Metadata metadata = new Metadata();
}
