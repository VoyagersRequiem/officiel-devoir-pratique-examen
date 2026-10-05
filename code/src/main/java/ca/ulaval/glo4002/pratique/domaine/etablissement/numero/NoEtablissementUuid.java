package ca.ulaval.glo4002.pratique.domaine.etablissement.numero;

import java.util.UUID;

public class NoEtablissementUuid implements NoEtablissement {
    private final UUID numero;

    NoEtablissementUuid(UUID numero) {
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        NoEtablissementUuid that = (NoEtablissementUuid) o;
        return this.numero.equals(that.numero);
    }

    @Override
    public int hashCode() {
        return this.numero.hashCode();
    }

    @Override
    public String asString() {
        return this.numero.toString();
    }
}
