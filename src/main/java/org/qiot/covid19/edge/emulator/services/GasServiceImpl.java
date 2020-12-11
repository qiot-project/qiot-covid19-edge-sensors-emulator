/**
 * 
 */
package org.qiot.covid19.edge.emulator.services;


import java.util.PrimitiveIterator;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import org.qiot.covid19.edge.emulator.domain.GasBean;
import org.qiot.covid19.edge.emulator.domain.GasGeneratorConfigService;
import org.qiot.covid19.edge.emulator.util.RandomGeneratorProducer;
import org.slf4j.Logger;


import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * @author abattagl
 *
 */
@ApplicationScoped
class GasServiceImpl implements GasService {
    Jsonb jsonb = JsonbBuilder.create();

    @Inject
    RandomGeneratorProducer randomGeneratorProducer;

    @Inject
    GasGeneratorConfigService gasGeneratorConfigService;

//    private PrimitiveIterator.OfDouble randomADCIterator;
    private PrimitiveIterator.OfDouble randomNH3Iterator;
    private PrimitiveIterator.OfDouble randomOxidisingIterator;
    private PrimitiveIterator.OfDouble randomReducingIterator;

    /**
     * Logger for this class
     */
    @Inject
    Logger LOGGER;

    @PostConstruct
    void init() {
        //        randomADCIterator=randomGeneratorProducer.doubleRandomNumberGenerator(gasGeneratorConfigService.getAdcAvg(), gasGeneratorConfigService.getAdcDelta());
        randomNH3Iterator = randomGeneratorProducer
                .doubleRandomNumberGenerator(
                        gasGeneratorConfigService.getNh3Avg(),
                        gasGeneratorConfigService.getNh3Delta());
        randomOxidisingIterator = randomGeneratorProducer
                .doubleRandomNumberGenerator(
                        gasGeneratorConfigService.getOxidisingAvg(),
                        gasGeneratorConfigService
                                .getOxidisingDelta());
        randomReducingIterator = randomGeneratorProducer
                .doubleRandomNumberGenerator(
                        gasGeneratorConfigService.getReducingAvg(),
                        gasGeneratorConfigService.getReducingDelta());
    }

    @Override
    public GasBean produce() {
        return generateMeasurement();
    }

    @Override
    public String produceAsString() throws Exception {
        return jsonb.toJson(generateMeasurement());
    }

    private GasBean generateMeasurement() {
        GasBean bean = new GasBean();
        if(!randomNH3Iterator.hasNext()) {
            LOGGER.info("Iterators depleted for GAS measurements. Refreshing rundom number generators...");
            init();
        }
        bean.setNh3(randomNH3Iterator.next());
        bean.setOxidising(randomOxidisingIterator.next());
        bean.setReducing(randomReducingIterator.next());

        return bean;
    }
}