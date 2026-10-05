package ca.ulaval.glo4002.pratique.domaine.etablissement.numero;

import java.util.Objects;

public class NoEtablissementLong implements NoEtablissement {
    private final Long numero;

    NoEtablissementLong(Long numero) {
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

        NoEtablissementLong that = (NoEtablissementLong) o;
        return Objects.equals(this.numero, that.numero);

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
