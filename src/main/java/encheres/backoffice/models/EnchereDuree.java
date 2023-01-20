package encheres.backoffice.models;

import java.sql.Timestamp;
import javax.persistence.*;

import encheres.backoffice.exception.IntervalleException;
import lombok.NoArgsConstructor;

@Entity
@Table(name="encheredurees")
@NoArgsConstructor
public class EnchereDuree {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idduree", nullable = false)
    private int idDuree;
    @Column(name = "dureemin")
    private double dureeMin;
    @Column(name = "dureemax")
    private double dureeMax;
    @Column(name = "datechangement")
    private Timestamp dateChangement;

    public void setDureeMinDureeMax(double dureeMin, double dureeMax) throws IntervalleException {
        if(dureeMin<dureeMax){
            this.dureeMin = dureeMin;
            this.dureeMax = dureeMax;
        }
        else{
            throw new IntervalleException("dureeMin is greater than dureeMax");
        }
    }
    public int getIdDuree() {
        return idDuree;
    }

    public void setIdDuree(int idDuree) {
        this.idDuree = idDuree;
    }

    public double getDureeMin() {
        return dureeMin;
    }

    /*public void setDureeMin(double dureeMin) {
        this.dureeMin = dureeMin;
    }*/

    public double getDureeMax() {
        return dureeMax;
    }

    /*public void setDureeMax(double dureeMax) {
        this.dureeMax = dureeMax;
    }*/

    public Timestamp getDateChangement() {
        return dateChangement;
    }

    public void setDateChangement(Timestamp dateChangement) {
        this.dateChangement = dateChangement;
    }
}
