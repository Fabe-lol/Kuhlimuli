package com.example.kuhlekuh;

import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Query;

import java.util.List;

@Entity
public class Kuh {
    public Kuh(){
        ohrmarke = 0;
        etBehandlung = false;
        euterentzuendung  = false;
        impfungKaelberflechte = false;
        klauenerkrankung = false;
        nabelerkankung = false;
        nachgeburtsverhaltung = false;
        sonderbehandlung = false;
        trockenstellen = false;
    }
    @PrimaryKey
    public int ohrmarke;
    public Boolean etBehandlung;
    public Boolean euterentzuendung;
    public Boolean impfungKaelberflechte;
    public Boolean klauenerkrankung;
    public Boolean nabelerkankung;
    public Boolean nachgeburtsverhaltung;
    public Boolean sonderbehandlung;
    public Boolean trockenstellen;
    public Kuh(int ohrmarke, boolean etBehandlung, boolean euterentzuendung, boolean impfungKaelberflechte,
               boolean klauenerkrankung, boolean nabelerkankung, boolean nachgeburtsverhaltung, boolean sonderbehandlung, boolean trockenstellen){
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
}

