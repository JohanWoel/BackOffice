package encheres.backoffice.models.statistiques;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "v_stat_avgmise")
@NoArgsConstructor
public class AvgMise {
    @Id
    @Column(name = "idcategorie", nullable = false)
    private Integer idCategorie;

    @Column(name = "moyennemise")
    private int moyenneMise;

    @Column(name = "libelle")
    private String libelle;

    public Integer getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Integer idCategorie) {
        this.idCategorie = idCategorie;
    }

    public int getMoyenneMise() {
        return moyenneMise;
    }

    public void setMoyenneMise(int moyenneMise) {
        this.moyenneMise = moyenneMise;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}


