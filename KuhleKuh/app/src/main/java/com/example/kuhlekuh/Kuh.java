package com.example.kuhlekuh;

import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Query;

import java.util.Date;
import java.util.List;

@Entity
public class Kuh {
    //default constructor
    public Kuh() {
        this.ohrmarke = 0;
        this.etBehandlung = false;
        this.euterentzuendung = false;
        this.impfungKaelberflechte = false;
        this.klauenerkrankung = false;
        this.nabelerkankung = false;
        this.nachgeburtsverhaltung = false;
        this.sonderbehandlung = false;
        this.trockenstellen = false;
    }

    //full constructor
    public Kuh(int ohrmarke, boolean etBehandlung, boolean euterentzuendung, boolean impfungKaelberflechte,
               boolean klauenerkrankung, boolean nabelerkankung, boolean nachgeburtsverhaltung, boolean sonderbehandlung, boolean trockenstellen) {
        this.ohrmarke = ohrmarke;
        this.etBehandlung = etBehandlung;
        this.euterentzuendung = euterentzuendung;
        this.impfungKaelberflechte = impfungKaelberflechte;
        this.klauenerkrankung = klauenerkrankung;
        this.nabelerkankung = nabelerkankung;
        this.nachgeburtsverhaltung = nachgeburtsverhaltung;
        this.sonderbehandlung = sonderbehandlung;
        this.trockenstellen = trockenstellen;
    }


    @PrimaryKey
    private int ohrmarke;
    private Boolean etBehandlung;
    private Boolean euterentzuendung;
    private Boolean impfungKaelberflechte;
    private Boolean klauenerkrankung;
    private Boolean nabelerkankung;
    private Boolean nachgeburtsverhaltung;
    private Boolean sonderbehandlung;
    private Boolean trockenstellen;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getOhrmarke() {
        return ohrmarke;
    }

    public Boolean getEtBehandlung() {
        return etBehandlung;
    }

    public Boolean getEuterentzuendung() {
        return euterentzuendung;
    }

    public Boolean getImpfungKaelberflechte() {
        return impfungKaelberflechte;
    }

    public Boolean getKlauenerkrankung() {
        return klauenerkrankung;
    }

    public Boolean getNabelerkankung() {
        return nabelerkankung;
    }

    public Boolean getNachgeburtsverhaltung() {
        return nachgeburtsverhaltung;
    }

    public Boolean getSonderbehandlung() {
        return sonderbehandlung;
    }

    public Boolean getTrockenstellen() {
        return trockenstellen;
    }

    public void setEtBehandlung(Boolean etBehandlung) {
        this.etBehandlung = etBehandlung;
    }

    public void setEuterentzuendung(Boolean euterentzuendung) {
        this.euterentzuendung = euterentzuendung;
    }

    public void setImpfungKaelberflechte(Boolean impfungKaelberflechte) {
        this.impfungKaelberflechte = impfungKaelberflechte;
    }

    public void setKlauenerkrankung(Boolean klauenerkrankung) {
        this.klauenerkrankung = klauenerkrankung;
    }

    public void setNabelerkankung(Boolean nabelerkankung) {
        this.nabelerkankung = nabelerkankung;
    }

    public void setNachgeburtsverhaltung(Boolean nachgeburtsverhaltung) {
        this.nachgeburtsverhaltung = nachgeburtsverhaltung;
    }

    public void setSonderbehandlung(Boolean sonderbehandlung) {
        this.sonderbehandlung = sonderbehandlung;
    }

    public void setTrockenstellen(Boolean trockenstellen) {
        this.trockenstellen = trockenstellen;
    }

    public void setOhrmarke(int ohrmarke) {
        this.ohrmarke = ohrmarke;
    }
}

