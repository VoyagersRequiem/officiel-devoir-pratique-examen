package ca.ulaval.glo4002.pratique.application;

import java.util.LinkedList;
import java.util.List;

import org.jvnet.hk2.annotations.Service;

import ca.ulaval.glo4002.pratique.interfaces.rest.dto.EtatEquipement;
import ca.ulaval.glo4002.pratique.domaine.etablissement.EtablissementStockage;
import ca.ulaval.glo4002.pratique.domaine.etablissement.Etablissement;
import ca.ulaval.glo4002.pratique.domaine.etablissement.numero.NoEtablissement;
import ca.ulaval.glo4002.pratique.domaine.equipement.Equipement;
import jakarta.inject.Inject;

@Service
public class ServiceInspection {
    private final EtablissementStockage etablissementStockage;

    @Inject
    public ServiceInspection(EtablissementStockage etablissementStockage) {
        this.etablissementStockage = etablissementStockage;
    }

    public List<EtatEquipement> listerEtatEquipement(NoEtablissement noEtablissement, boolean inspectionSeulement) {
        Etablissement etablissement = this.etablissementStockage.trouverEtablissement(noEtablissement);
        List<EtatEquipement> etats = new LinkedList<>();
        for (Equipement equipement : etablissement.obtenirEquipements()) {
            etats.add(new EtatEquipement(equipement.getNoSerie(), equipement.getDescription(), equipement.getStatut(inspectionSeulement)));
        }
        return etats;
    }
}
