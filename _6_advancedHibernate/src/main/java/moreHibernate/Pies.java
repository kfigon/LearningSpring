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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Set;

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
    @JoinColumn(name = "obroza_id") // co w bazie jest w foreign key
    private Obroza obroza;

    @OneToMany(mappedBy = "pies") // ze strony 'many'
    private Set<Zabawka> zabawki;

    // jednokierunkowe:
//    @OneToMany
//    @JoinColumn(name ="pies_id") // ze strony many, po stronie many
//    private Set<Zabawka> zabawki

    // po drugiej stronie analogicznie, ale w druga strone
    // potrzebny junction table
//    @ManyToMany
//    @JoinTable(
//            name = "nazwa_junction_table",
//            joinColumns = @JoinColumn(name="jednaStrona_id"), // z junction
//            inverseJoinColumns = @JoinColumn(name="drugaStrona_id") // z junction
//    )
//    private List<Object> lista;

    @Override
    public String toString() {
        return String.format("%d. %s, wiek: %d, obroza %s", id, id, wiek, obroza.toString());
    }
}
