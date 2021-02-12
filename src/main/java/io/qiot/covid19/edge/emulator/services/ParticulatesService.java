/**
 * 
 */
package io.qiot.covid19.edge.emulator.services;


import io.qiot.covid19.edge.emulator.domain.PartuculatesBean;


/**
 * @author abattagl
 *
 */
public interface ParticulatesService {

    PartuculatesBean produce();

    String produceAsString() throws Exception;
}
