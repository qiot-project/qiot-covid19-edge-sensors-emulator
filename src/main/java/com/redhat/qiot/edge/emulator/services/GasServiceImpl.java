/**
 * 
 */
package com.redhat.qiot.edge.emulator.services;


import java.util.PrimitiveIterator;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;


import org.slf4j.Logger;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.redhat.qiot.edge.emulator.domain.GasBean;
import com.redhat.qiot.edge.emulator.domain.GasGeneratorConfigService;
import com.redhat.qiot.edge.emulator.util.RandomGeneratorProducer;


/**
 * @author abattagl
 *
 */
@ApplicationScoped
class GasServiceImpl implements GasService {

    private final ObjectMapper MAPPER = new ObjectMapper();

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
        return MAPPER.writeValueAsString(generateMeasurement());
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
