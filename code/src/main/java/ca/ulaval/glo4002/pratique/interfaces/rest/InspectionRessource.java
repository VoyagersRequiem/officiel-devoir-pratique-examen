package ca.ulaval.glo4002.pratique.interfaces.rest;

import java.util.List;

import ca.ulaval.glo4002.pratique.application.ServiceInspection;
import ca.ulaval.glo4002.pratique.domaine.etablissement.numero.NoEtablissement;
import ca.ulaval.glo4002.pratique.interfaces.rest.dto.EtatEquipement;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/etablissements/{numero}")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class InspectionRessource {


    public ServiceInspection service;

    @Inject
    public InspectionRessource(ServiceInspection service) {
        this.service = service;
    }

    @GET()
    @Path("/equipements")
    public Response etatDesEquipement(
        @PathParam("numero") String noEtablissementStr,
        @QueryParam("inspectionSeulement") @DefaultValue("false") String inspectionSeulementStr
    ) {
        NoEtablissement noEtablissement = NoEtablissement.depuisString(noEtablissementStr);


        boolean inspectionSeulement = Boolean.parseBoolean(inspectionSeulementStr);

        List<EtatEquipement> etatEquipements = this.service.listerEtatEquipement(noEtablissement, inspectionSeulement);

        return Response.ok(etatEquipements).build();
    }
}
