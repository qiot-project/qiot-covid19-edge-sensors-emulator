package io.qiot.covid19.edge.emulator.domain;


import javax.enterprise.context.ApplicationScoped;


import org.eclipse.microprofile.config.inject.ConfigProperty;


import io.quarkus.arc.config.ConfigProperties;


@ApplicationScoped
@ConfigProperties(prefix = "measurementgenerator.particulates", failOnMismatchingMember = false)
public interface ParticulatesGeneratorConfigService {

    @ConfigProperty(name = "PM1_0-avg")
    int getPM1_0Avg();
    @ConfigProperty(name = "PM1_0-delta")
    int getPM1_0Delta();
    @ConfigProperty(name = "PM2_5-avg")
    int getPM2_5Avg();
    @ConfigProperty(name = "PM2_5-delta")
    int getPM2_5Delta();
    @ConfigProperty(name = "PM10-avg")
    int getPM10Avg();
    @ConfigProperty(name = "PM10-delta")
    int getPM10Delta();
    @ConfigProperty(name = "PM1_0_atm-avg")
    int getPM1_0_atmAvg();
    @ConfigProperty(name = "PM1_0_atm-delta")
    int getPM1_0_atmDelta();
    @ConfigProperty(name = "PM2_5_atm-avg")
    int getPM2_5_atmAvg();
    @ConfigProperty(name = "PM2_5_atm-delta")
    int getPM2_5_atmDelta();
    @ConfigProperty(name = "PM10_atm-avg")
    int getPM10_atmAvg();
    @ConfigProperty(name = "PM10_atm-delta")
    int getPM10_atmDelta();
    @ConfigProperty(name = "gt0_3um-avg")
    int getGt0_3umAvg();
    @ConfigProperty(name = "gt0_3um-delta")
    int getGt0_3umDelta();
    @ConfigProperty(name = "gt0_5um-avg")
    int getGt0_5umAvg();
    @ConfigProperty(name = "gt0_5um-delta")
    int getGt0_5umDelta();
    @ConfigProperty(name = "gt1_0um-avg")
    int getGt1_0umAvg();
    @ConfigProperty(name = "gt1_0um-delta")
    int getGt1_0umDelta();
    @ConfigProperty(name = "gt2_5um-avg")
    int getGt2_5umAvg();
    @ConfigProperty(name = "gt2_5um-delta")
    int getGt2_5umDelta();
    @ConfigProperty(name = "gt5_0um-avg")
    int getGt5_0umAvg();
    @ConfigProperty(name = "gt5_0um-delta")
    int getGt5_0umDelta();
    @ConfigProperty(name = "gt10um-avg")
    int getGt10umAvg();
    @ConfigProperty(name = "gt10um-delta")
    int getGt10umDelta();

}
