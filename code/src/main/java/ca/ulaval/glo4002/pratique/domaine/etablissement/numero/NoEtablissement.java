package ca.ulaval.glo4002.pratique.domaine.etablissement.numero;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface NoEtablissement {
    Pattern REGEX_NO_V1 = Pattern.compile("\\d+");
    static NoEtablissement depuisString(String numero) {
        Matcher matcher = REGEX_NO_V1.matcher(numero);
        if (matcher.matches()) {
            return new NoEtablissementLong(Long.parseLong(numero));
        } else {
            return new NoEtablissementUuid(UUID.fromString(numero));
        }

    }

    static NoEtablissement generer() {
        return new NoEtablissementUuid(UUID.randomUUID());
    }

    @Override
    boolean equals(Object o);

    @Override
    int hashCode();

    String asString();
}
