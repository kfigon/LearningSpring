package learningHibernate;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity     // jdbc tabela
public class Student {

    @Id
    @GeneratedValue
    private Integer id;

//    @Column(name = "FULL_NAME") // mozna jawnie nadawac nazwy
    private String imie;
    private String nazwisko;
    private Integer wiek;

    @Override
    public String toString() {
        return String.format("%d. %s %s, wiek: %d", id, imie, nazwisko, wiek);
    }
}
