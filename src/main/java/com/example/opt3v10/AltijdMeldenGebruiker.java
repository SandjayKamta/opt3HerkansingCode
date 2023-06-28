package com.example.opt3v10;

class AltijdMeldenGebruiker extends Gebruiker {
    public AltijdMeldenGebruiker(String naam) {
        super(naam);
    }

    @Override
    protected void valideer() {
        System.out.println("Gebruiker valideren...");
        // Valideren voor AltijdMeldenGebruiker
    }

    @Override
    protected void voerVoorkeurenUit() {
        System.out.println("Voorkeuren verwerken...");
        // Voorkeursverwerking voor AltijdMeldenGebruiker
    }

    @Override
    protected void voerRegistratieUit() {
        System.out.println("Registratie wordt uitgevoerd...");
        // Registratielogica voor AltijdMeldenGebruiker
    }

    @Override
    protected boolean moetMelden(int beschikbareStoelen) {
        return true; // Altijd melden, ongeacht het aantal beschikbare stoelen
    }
}
