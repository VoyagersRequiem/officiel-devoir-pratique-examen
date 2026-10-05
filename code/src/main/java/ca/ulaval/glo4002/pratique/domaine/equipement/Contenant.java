package ca.ulaval.glo4002.pratique.domaine.equipement;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class Contenant extends Equipement {
    private final List<Equipement> equipements;

    public Contenant(
        NoSerie noSerie,
        String description,
        String localisation,
        LocalDateTime derniereInspection,
        Duration dureValiditeInspection,
        List<Equipement> equipements
    ) {
        super(noSerie, description, localisation, derniereInspection, dureValiditeInspection);
        this.equipements = equipements;
    }
    @Override
    public boolean estPerimable() {
        return false;
    }

    @Override
    public LocalDateTime datePeremption() {
        throw new EquipementException("Un contenant n'est pas périmable.");
    }

    @Override
    public boolean estUnContenant() {
        return true;
    }

    @Override
    public List<Equipement> getEquipementDansContenant() {
        return null;
    }

    public StatutEquipement getStatut(boolean inspectionSeulement) {
        StatutEquipement statut = super.getStatut(inspectionSeulement);
        for ( Equipement  equipement : equipements ) {
            if(equipement.getStatut(inspectionSeulement) != StatutEquipement.OK) {
                statut = equipement.getStatut(inspectionSeulement);
            }
            if (statut == StatutEquipement.A_REMPLACER) {
                break;
            }
        }
        return statut;
    }

}
