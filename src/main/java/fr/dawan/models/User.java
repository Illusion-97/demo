package fr.dawan.models;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

//@NoArgsConstructor // Génère le constructeur vide
//@RequiredArgsConstructor // Ici un constructeur avec les attributs finaux ou non-null
//@AllArgsConstructor // Constructeur avec tous les paramètres
/*@Getter
@Setter
@EqualsAndHashCode
@ToString*/
@Data
@Accessors(fluent = true)
public class User implements Serializable {
    //@NonNull
    private int age = 18;
    //@NonNull
    private String nom;
    private String prenom;
}
// POJO et JavaBean
