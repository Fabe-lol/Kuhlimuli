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
    private int ohrmarke;
    private Boolean etBehandlung;
    private Boolean euterentzuendung;
    private Boolean impfungKaelberflechte;
    private Boolean klauenerkrankung;
    private Boolean nabelerkankung;
    private Boolean nachgeburtsverhaltung;
    private Boolean sonderbehandlung;
    private Boolean trockenstellen;
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
    public void setOhrmarke(int ohrmarke){
        this.ohrmarke = ohrmarke;
    }
    public int getOhrmarke() {
        return ohrmarke;
    }
    public boolean geteuterentzuendung(){
        return euterentzuendung;
    }
    public boolean getimpfungKaelberflechte(){
        return impfungKaelberflechte;
    }
    public boolean getklauenerkrankung(){
        return klauenerkrankung;
    }
    public boolean getnabelerkankung(){
        return nabelerkankung;
    }
    public boolean getnachgeburtsverhaltung(){
        return nachgeburtsverhaltung;
    }
    public boolean getsonderbehandlung(){
        return sonderbehandlung;
    }
    public boolean gettrockenstellen(){
        return trockenstellen;
    }

}

