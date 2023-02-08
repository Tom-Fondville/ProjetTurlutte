package fr.epsi.turlutte.common.enums;

public enum Qualite {

        NEUF("Neuf"),
        BONETAT("Bon état"),
        USE("Usé"),
        TRESUSE("Très usé");

    private final String etat;

    Qualite(String etat) {
        this.etat=etat;
    }

}
