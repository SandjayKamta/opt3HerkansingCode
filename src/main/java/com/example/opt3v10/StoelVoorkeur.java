package com.example.opt3v10;

enum StoelVoorkeur {
    ALTIJD, BEREIK;

    public boolean moetMelden(int beschikbareStoelen) {
        switch (this) {
            case ALTIJD:
                return true;
            case BEREIK:
                return beschikbareStoelen > 0;
            default:
                return false;
        }
    }
}
