package learningHibernate;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity     // jdbc tabela. encja to klasa zmapowana na tabele w bazie
//@Table(name = "student") // default
public class Student {

    @Id
    @GeneratedValue
    private Integer id;

//    @Column(name = "imie") // mozna jawnie nadawac nazwy, zmienic mapping.
    // jesli 2 slowa camelCasem to zmapowane bedzie podkreslnikami
    private String imie;
    private String nazwisko;
    private Integer wiek;

    @Override
    public String toString() {
        return String.format("%d. %s %s, wiek: %d", id, imie, nazwisko, wiek);
    }
}
