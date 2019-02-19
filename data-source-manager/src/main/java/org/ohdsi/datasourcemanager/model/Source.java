package org.ohdsi.datasourcemanager.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "source")
@SQLDelete(sql = "UPDATE {h-schema}source SET deleted_at = current_timestamp WHERE id = ?")
public class Source {

    @Id
    @GenericGenerator(
            name = "source_id_seq",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator = "source_id_seq")
    @Column(name = "id")
    @Getter
    @Setter
    private Integer sourceId;

    @Column(name = "name")
    @Getter
    @Setter
    private String name;
}
