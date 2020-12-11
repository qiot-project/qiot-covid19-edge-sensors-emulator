package org.qiot.covid19.edge.emulator.domain;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class PartuculatesBean {

    private int PM1_0;
    private int PM2_5;
    private int PM10;
    private int PM1_0_atm;
    private int PM2_5_atm;
    private int PM10_atm;
    private int gt0_3um;
    private int gt0_5um;
    private int gt1_0um;
    private int gt2_5um;
    private int gt5_0um;
    private int gt10um;
    
    public int getPM1_0() {
        return PM1_0;
    }
    
    public void setPM1_0(int pM1_0) {
        PM1_0 = pM1_0;
    }
    
    public int getPM2_5() {
        return PM2_5;
    }
    
    public void setPM2_5(int pM2_5) {
        PM2_5 = pM2_5;
    }
    
    public int getPM10() {
        return PM10;
    }
    
    public void setPM10(int pM10) {
        PM10 = pM10;
    }
    
    public int getPM1_0_atm() {
        return PM1_0_atm;
    }
    
    public void setPM1_0_atm(int pM1_0_atm) {
        PM1_0_atm = pM1_0_atm;
    }
    
    public int getPM2_5_atm() {
        return PM2_5_atm;
    }
    
    public void setPM2_5_atm(int pM2_5_atm) {
        PM2_5_atm = pM2_5_atm;
    }
    
    public int getPM10_atm() {
        return PM10_atm;
    }
    
    public void setPM10_atm(int pM10_atm) {
        PM10_atm = pM10_atm;
    }
    
    public int getGt0_3um() {
        return gt0_3um;
    }
    
    public void setGt0_3um(int gt0_3um) {
        this.gt0_3um = gt0_3um;
    }
    
    public int getGt0_5um() {
        return gt0_5um;
    }
    
    public void setGt0_5um(int gt0_5um) {
        this.gt0_5um = gt0_5um;
    }
    
    public int getGt1_0um() {
        return gt1_0um;
    }
    
    public void setGt1_0um(int gt1_0um) {
        this.gt1_0um = gt1_0um;
    }
    
    public int getGt2_5um() {
        return gt2_5um;
    }
    
    public void setGt2_5um(int gt2_5um) {
        this.gt2_5um = gt2_5um;
    }
    
    public int getGt5_0um() {
        return gt5_0um;
    }
    
    public void setGt5_0um(int gt5_0um) {
        this.gt5_0um = gt5_0um;
    }
    
    public int getGt10um() {
        return gt10um;
    }
    
    public void setGt10um(int gt10um) {
        this.gt10um = gt10um;
    }

    @Override
    public String toString() {
        return "PartuculatesBean [PM1_0=" + PM1_0 + ", PM2_5=" + PM2_5
                + ", PM10=" + PM10 + ", PM1_0_atm=" + PM1_0_atm
                + ", PM2_5_atm=" + PM2_5_atm + ", PM10_atm="
                + PM10_atm + ", gt0_3um=" + gt0_3um + ", gt0_5um="
                + gt0_5um + ", gt1_0um=" + gt1_0um + ", gt2_5um="
                + gt2_5um + ", gt5_0um=" + gt5_0um + ", gt10um="
                + gt10um + "]";
    }
    
    
}
