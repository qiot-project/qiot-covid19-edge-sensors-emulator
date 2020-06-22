package com.redhat.qiot.edge.emulator.domain;


import io.quarkus.runtime.annotations.RegisterForReflection;


@RegisterForReflection
public class GasBean {

    private Double adc;
    private Double nh3;
    private Double oxidising;
    private Double reducing;

    public Double getAdc() {
        return adc;
    }

    public void setAdc(Double adc) {
        this.adc = adc;
    }

    public Double getNh3() {
        return nh3;
    }

    public void setNh3(Double nh3) {
        this.nh3 = nh3;
    }

    public Double getOxidising() {
        return oxidising;
    }

    public void setOxidising(Double oxidising) {
        this.oxidising = oxidising;
    }

    public Double getReducing() {
        return reducing;
    }

    public void setReducing(Double reducing) {
        this.reducing = reducing;
    }

    @Override
    public String toString() {
        return "GasBean [adc=" + adc + ", nh3=" + nh3 + ", oxidising="
                + oxidising + ", reducing=" + reducing + "]";
    }

}
