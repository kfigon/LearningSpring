package moreHibernate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Zabawka {
    @Id
    @GeneratedValue
    private Integer id;

    private String nazwa;

    // one to many musi byc dwukierunkowe
    @ManyToOne
    @JoinColumn(name = "pies_id")
    private Pies pies;

    @Override
    public String toString() {
        return String.format("%d. %s", id, nazwa);
    }
}
