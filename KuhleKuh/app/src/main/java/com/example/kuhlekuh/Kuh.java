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
}

