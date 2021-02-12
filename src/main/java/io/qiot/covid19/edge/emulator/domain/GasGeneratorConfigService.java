package io.qiot.covid19.edge.emulator.domain;


import javax.enterprise.context.ApplicationScoped;


import io.quarkus.arc.config.ConfigProperties;


@ApplicationScoped
@ConfigProperties(prefix = "measurementgenerator.gas", failOnMismatchingMember = false)
public interface GasGeneratorConfigService {

    Double getAdcAvg();

    Double getAdcDelta();

    Double getNh3Avg();

    Double getNh3Delta();

    Double getOxidisingAvg();

    Double getOxidisingDelta();

    Double getReducingAvg();

    Double getReducingDelta();

}
