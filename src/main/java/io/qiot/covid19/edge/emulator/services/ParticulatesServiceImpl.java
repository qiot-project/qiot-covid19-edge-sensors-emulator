/**
 * 
 */
package io.qiot.covid19.edge.emulator.services;


import java.util.PrimitiveIterator;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import org.slf4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.qiot.covid19.edge.emulator.domain.ParticulatesGeneratorConfigService;
import io.qiot.covid19.edge.emulator.domain.PartuculatesBean;
import io.qiot.covid19.edge.emulator.util.RandomGeneratorProducer;


/**
 * @author abattagl
 *
 */
@ApplicationScoped
class ParticulatesServiceImpl implements ParticulatesService {
    Jsonb jsonb = JsonbBuilder.create();

    @Inject
    RandomGeneratorProducer randomGeneratorProducer;

    @Inject
    ParticulatesGeneratorConfigService particulatesGeneratorConfigService;

    private PrimitiveIterator.OfInt randomPM1_0Iterator;
    private PrimitiveIterator.OfInt randomPM2_5Iterator;
    private PrimitiveIterator.OfInt randomPM10Iterator;
    private PrimitiveIterator.OfInt randomPM1_0_atmIterator;
    private PrimitiveIterator.OfInt randomPM2_5_atmIterator;
    private PrimitiveIterator.OfInt randomPM10_atmIterator;
    private PrimitiveIterator.OfInt randomGt0_3umIterator;
    private PrimitiveIterator.OfInt randomGt0_5umIterator;
    private PrimitiveIterator.OfInt randomGt1_0umIterator;
    private PrimitiveIterator.OfInt randomGt2_5umIterator;
    private PrimitiveIterator.OfInt randomGt5_0umIterator;
    private PrimitiveIterator.OfInt randomGt10umIterator;

    /**
     * Logger for this class
     */
    @Inject
    Logger LOGGER;

    @PostConstruct
    void init() {
        //        randomADCIterator=randomGeneratorProducer.intRandomNumberGenerator(particulatesGeneratorConfigService.getAdcAvg(), particulatesGeneratorConfigService.getAdcDelta());
        randomPM1_0Iterator = randomGeneratorProducer.intRandomNumberGenerator(particulatesGeneratorConfigService.getPM1_0Avg(),particulatesGeneratorConfigService.getPM1_0Delta());
        randomPM2_5Iterator = randomGeneratorProducer.intRandomNumberGenerator(particulatesGeneratorConfigService.getPM2_5Avg(),particulatesGeneratorConfigService.getPM2_5Delta());
        randomPM10Iterator = randomGeneratorProducer.intRandomNumberGenerator(particulatesGeneratorConfigService.getPM10Avg(),particulatesGeneratorConfigService.getPM10Delta());
        randomPM1_0_atmIterator = randomGeneratorProducer.intRandomNumberGenerator(particulatesGeneratorConfigService.getPM1_0_atmAvg(),particulatesGeneratorConfigService.getPM1_0_atmDelta());
        randomPM2_5_atmIterator = randomGeneratorProducer.intRandomNumberGenerator(particulatesGeneratorConfigService.getPM2_5_atmAvg(),particulatesGeneratorConfigService.getPM2_5_atmDelta());
        randomPM10_atmIterator = randomGeneratorProducer.intRandomNumberGenerator(particulatesGeneratorConfigService.getPM10_atmAvg(),particulatesGeneratorConfigService.getPM10_atmDelta());
        randomGt0_3umIterator = randomGeneratorProducer.intRandomNumberGenerator(particulatesGeneratorConfigService.getGt0_3umAvg(),particulatesGeneratorConfigService.getGt0_3umDelta());
        randomGt0_5umIterator = randomGeneratorProducer.intRandomNumberGenerator(particulatesGeneratorConfigService.getGt0_5umAvg(),particulatesGeneratorConfigService.getGt0_5umDelta());
        randomGt1_0umIterator = randomGeneratorProducer.intRandomNumberGenerator(particulatesGeneratorConfigService.getGt1_0umAvg(),particulatesGeneratorConfigService.getGt1_0umDelta());
        randomGt2_5umIterator = randomGeneratorProducer.intRandomNumberGenerator(particulatesGeneratorConfigService.getGt2_5umAvg(),particulatesGeneratorConfigService.getGt2_5umDelta());
        randomGt5_0umIterator = randomGeneratorProducer.intRandomNumberGenerator(particulatesGeneratorConfigService.getGt5_0umAvg(),particulatesGeneratorConfigService.getGt5_0umDelta());
        randomGt10umIterator = randomGeneratorProducer.intRandomNumberGenerator(particulatesGeneratorConfigService.getGt10umAvg(),particulatesGeneratorConfigService.getGt10umDelta());
    }

    @Override
    public PartuculatesBean produce() {
        return generateMeasurement();
    }

    @Override
    public String produceAsString() throws Exception {
        return jsonb.toJson(generateMeasurement());
    }

    private PartuculatesBean generateMeasurement() {
        if(!randomPM1_0Iterator.hasNext()) {
            LOGGER.info("Iterators depleted for PARTICULATE measurements. Refreshing rundom number generators...");
            init();
        }
        PartuculatesBean bean = new PartuculatesBean();
//        bean.setReducing(randomReducingIterator.next());
        bean.setPm1_0(randomPM1_0Iterator.nextInt());
        bean.setPm2_5(randomPM2_5Iterator.nextInt());
        bean.setPm10(randomPM10Iterator.nextInt());
        bean.setPm1_0_atm(randomPM1_0_atmIterator.nextInt());
        bean.setPm2_5_atm(randomPM2_5_atmIterator.nextInt());
        bean.setPm10_atm(randomPM10_atmIterator.nextInt());
        bean.setGt0_3um(randomGt0_3umIterator.nextInt());
        bean.setGt0_5um(randomGt0_5umIterator.nextInt());
        bean.setGt1_0um(randomGt1_0umIterator.nextInt());
        bean.setGt2_5um(randomGt2_5umIterator.nextInt());
        bean.setGt5_0um(randomGt5_0umIterator.nextInt());
        bean.setGt10um(randomGt10umIterator.nextInt());
        return bean;
    }
}
