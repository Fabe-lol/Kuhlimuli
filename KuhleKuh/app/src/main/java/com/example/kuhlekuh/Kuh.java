package com.example.kuhlekuh;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

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
    private int switchAddOrEdit;
    private Date dateStartEtBehandlung;
    private Date dateEndEtBehandlung;
    private Date dateStartEuterenzuendung;
    private Date dateEndEuterentzuendung;
    private Date dateStartImpfungKaelberflechte;
    private Date dateEndImpfungKaelberflechte;
    private Date dateStartKlauenerkrankung;
    private Date dateEndKlauenerkrankung;
    private Date dateStartNabelerkrankung;
    private Date dateEndNabelerkrankung;
    private Date dateStartNachgeburtsverhaltung;
    private Date dateEndNachgeburtsverhaltung;
    private Date dateStartSonderbehandlung;
    private Date dateEndSonderbehandlung;
    private Date dateStartTrockenstellen;
    private Date dateEndTrockenstellen;

    public Date getDateStartEtBehandlung() {
        return dateStartEtBehandlung;
    }

    public void setDateStartEtBehandlung(Date dateStartEtBehandlung) {
        this.dateStartEtBehandlung = dateStartEtBehandlung;
    }

    public Date getDateEndEtBehandlung() {
        return dateEndEtBehandlung;
    }

    public void setDateEndEtBehandlung(Date dateEndEtBehandlung) {
        this.dateEndEtBehandlung = dateEndEtBehandlung;
    }

    public Date getDateStartEuterenzuendung() {
        return dateStartEuterenzuendung;
    }

    public void setDateStartEuterenzuendung(Date dateStartEuterenzuendung) {
        this.dateStartEuterenzuendung = dateStartEuterenzuendung;
    }

    public Date getDateEndEuterentzuendung() {
        return dateEndEuterentzuendung;
    }

    public void setDateEndEuterentzuendung(Date dateEndEuterentzuendung) {
        this.dateEndEuterentzuendung = dateEndEuterentzuendung;
    }

    public Date getDateStartImpfungKaelberflechte() {
        return dateStartImpfungKaelberflechte;
    }

    public void setDateStartImpfungKaelberflechte(Date dateStartImpfungKaelberflechte) {
        this.dateStartImpfungKaelberflechte = dateStartImpfungKaelberflechte;
    }

    public Date getDateEndImpfungKaelberflechte() {
        return dateEndImpfungKaelberflechte;
    }

    public void setDateEndImpfungKaelberflechte(Date dateEndImpfungKaelberflechte) {
        this.dateEndImpfungKaelberflechte = dateEndImpfungKaelberflechte;
    }

    public Date getDateStartKlauenerkrankung() {
        return dateStartKlauenerkrankung;
    }

    public void setDateStartKlauenerkrankung(Date dateStartKlauenerkrankung) {
        this.dateStartKlauenerkrankung = dateStartKlauenerkrankung;
    }

    public Date getDateEndKlauenerkrankung() {
        return dateEndKlauenerkrankung;
    }

    public void setDateEndKlauenerkrankung(Date dateEndKlauenerkrankung) {
        this.dateEndKlauenerkrankung = dateEndKlauenerkrankung;
    }

    public Date getDateStartNabelerkrankung() {
        return dateStartNabelerkrankung;
    }

    public void setDateStartNabelerkrankung(Date dateStartNabelerkrankung) {
        this.dateStartNabelerkrankung = dateStartNabelerkrankung;
    }

    public Date getDateEndNabelerkrankung() {
        return dateEndNabelerkrankung;
    }

    public void setDateEndNabelerkrankung(Date dateEndNabelerkrankung) {
        this.dateEndNabelerkrankung = dateEndNabelerkrankung;
    }

    public Date getDateStartNachgeburtsverhaltung() {
        return dateStartNachgeburtsverhaltung;
    }

    public void setDateStartNachgeburtsverhaltung(Date dateStartNachgeburtsverhaltung) {
        this.dateStartNachgeburtsverhaltung = dateStartNachgeburtsverhaltung;
    }

    public Date getDateEndNachgeburtsverhaltung() {
        return dateEndNachgeburtsverhaltung;
    }

    public void setDateEndNachgeburtsverhaltung(Date dateEndNachgeburtsverhaltung) {
        this.dateEndNachgeburtsverhaltung = dateEndNachgeburtsverhaltung;
    }

    public Date getDateStartSonderbehandlung() {
        return dateStartSonderbehandlung;
    }

    public void setDateStartSonderbehandlung(Date dateStartSonderbehandlung) {
        this.dateStartSonderbehandlung = dateStartSonderbehandlung;
    }

    public Date getDateEndSonderbehandlung() {
        return dateEndSonderbehandlung;
    }

    public void setDateEndSonderbehandlung(Date dateEndSonderbehandlung) {
        this.dateEndSonderbehandlung = dateEndSonderbehandlung;
    }

    public Date getDateStartTrockenstellen() {
        return dateStartTrockenstellen;
    }

    public void setDateStartTrockenstellen(Date dateStartTrockenstellen) {
        this.dateStartTrockenstellen = dateStartTrockenstellen;
    }

    public Date getDateEndTrockenstellen() {
        return dateEndTrockenstellen;
    }

    public void setDateEndTrockenstellen(Date dateEndTrockenstellen) {
        this.dateEndTrockenstellen = dateEndTrockenstellen;
    }

    public int getSwitchAddOrEdit() {
        return switchAddOrEdit;
    }

    public void setSwitchAddOrEdit(int switchAddOrEdit) {
        this.switchAddOrEdit = switchAddOrEdit;
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

