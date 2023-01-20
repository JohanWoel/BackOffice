package encheres.backoffice.models;
import javax.persistence.*;

import lombok.NoArgsConstructor;

@Entity
@Table(name="encheres")
@NoArgsConstructor
public class Enchere {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idenchere", nullable = false)
    private int idEnchere;
    @ManyToOne(targetEntity = Utilisateur.class)
    @JoinColumn(name = "idutilisateur", referencedColumnName = "idutilisateur")
    private Utilisateur utilisateur;
    @ManyToOne(targetEntity = Produit.class)
    @JoinColumn(name = "idproduit", referencedColumnName = "idproduit")
    private Produit produit;
    @Column(name = "description")
    private String description;
    @Column(name = "prix_min_enchere")
    private int prix_min_enchere;
    @Column(name = "duree")
    private int duree;
    @Column(name = "statut")
    private boolean statut;

    public int getIdEnchere() {
        return idEnchere;
    }

    public void setIdEnchere(int idEnchere) {
        this.idEnchere = idEnchere;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrix_min_enchere() {
        return prix_min_enchere;
    }

    public void setPrix_min_enchere(int prix_min_enchere) {
        this.prix_min_enchere = prix_min_enchere;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }
}
