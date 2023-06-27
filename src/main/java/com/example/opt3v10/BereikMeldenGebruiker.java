package com.example.opt3v10;

class BereikMeldenGebruiker extends Gebruiker {
    public BereikMeldenGebruiker(String naam) {
        super(naam);
    }

    @Override
    protected void valideer() {
        System.out.println("Gebruiker valideren...");
        // Valideren voor BereikMeldenGebruiker
    }

    @Override
    protected void voerVoorkeurenUit() {
        System.out.println("Voorkeuren verwerken...");
        // Voorkeursverwerking voor BereikMeldenGebruiker
    }

    @Override
    protected void voerRegistratieUit() {
        System.out.println("Registratie uitvoeren...");
        // Registratielogica voor BereikMeldenGebruiker
    }

    @Override
    protected boolean moetMelden(int beschikbareStoelen) {
        return beschikbareStoelen > 0; // Melden alleen als er 1 of meer stoelen beschikbaar zijn
    }
}
