package moreHibernate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pies")
public class Pies {
    @Id
    @GeneratedValue
    private Integer id;

    private String imie;

    private Integer wiek;

    @OneToOne
    @JoinColumn(name = "obroza_id") // co w bazie jest
    private Obroza obroza;

    @Override
    public String toString() {
        return String.format("%d. %s, wiek: %d, obroza %s", id, id, wiek, obroza.toString());
    }
}
