package ca.ulaval.glo4002.pratique.domaine.equipement;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public class EquipementPerimable extends Equipement {
    private final LocalDateTime datePeremption;

    public EquipementPerimable(
        NoSerie noSerie,
        String description,
        String localisation,
        LocalDateTime derniereInspection,
        Duration dureValiditeInspection,
        LocalDateTime datePeremption
    ) {
        super(noSerie, description, localisation, derniereInspection, dureValiditeInspection);
        this.datePeremption = datePeremption;
    }

    @Override
    public boolean estPerimable() {
        return true;
    }

    @Override
    public LocalDateTime datePeremption() {
        return this.datePeremption;
    }

    @Override
    public boolean estUnContenant() {
        return false;
    }

    @Override
    public List<Equipement> getEquipementDansContenant() {
        return Collections.emptyList();
    }

    @Override
    public StatutEquipement getStatut(boolean inspectionSeulement) {
        LocalDateTime aujourdhui = LocalDateTime.now();
        if (this.datePeremption.isAfter(aujourdhui) && !inspectionSeulement) {
            return StatutEquipement.A_REMPLACER;
        }
        else if( this.derniereInspection.plus(this.dureValiditeInspection).isAfter(aujourdhui)) {
            return StatutEquipement.A_INSPECTER;
        }
        return StatutEquipement.OK;
    }
}
