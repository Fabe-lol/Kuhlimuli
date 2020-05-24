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
    public int uid;

    @ColumnInfo(name = "ETBehandlung")
    public Boolean ETBehandlung;

    @ColumnInfo(name = "Euterentzuendung")
    public Boolean Euterentzuendung;

    @ColumnInfo(name = "Impfung_Kaelberflechte")
    public Boolean Impfung_Kaelberflechte;

    @ColumnInfo(name = "Klauenerkrankung")
    public Boolean Klauenerkrankung;

    @ColumnInfo(name = "Nabelerkankung")
    public Boolean Nabelerkankung;

    @ColumnInfo(name = "Nachgeburtsverhaltung")
    public Boolean Nachgeburtsverhaltung;

    @ColumnInfo(name = "Sonderbehandlung")
    public Boolean Sonderbehandlung;

    @ColumnInfo(name = "Trockenstellen")
    public Boolean Trockenstellen;
}

