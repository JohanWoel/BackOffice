package encheres.backoffice.models.statistiques;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "v_nbencheres_categorie")
@NoArgsConstructor
public class NbEncheres {

    @Id
    @Column(name = "idcategorie", nullable = false)
    private Integer idCategorie;

    @Column(name = "nbencheres")
    private int nbEncheres;

    @Column(name = "libelle")
    private String libelle;

    public Integer getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Integer idCategorie) {
        this.idCategorie = idCategorie;
    }

    public int getNbEncheres() {
        return nbEncheres;
    }

    public void setNbEncheres(int nbEncheres) {
        this.nbEncheres = nbEncheres;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
