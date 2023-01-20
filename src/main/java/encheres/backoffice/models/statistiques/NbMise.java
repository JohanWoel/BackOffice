package encheres.backoffice.models.statistiques;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "v_stat_nbmise")
@NoArgsConstructor
public class NbMise {
    @Id
    @Column(name = "idcategorie", nullable = false)
    private Integer idCategorie;

    @Column(name = "nbmises")
    private int nbMises;

    @Column(name = "libelle")
    private String libelle;

    public Integer getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Integer idCategorie) {
        this.idCategorie = idCategorie;
    }

    public int getNbMises() {
        return nbMises;
    }

    public void setNbMises(int nbMises) {
        this.nbMises = nbMises;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}

