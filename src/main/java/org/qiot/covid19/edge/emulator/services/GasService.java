/**
 * 
 */
package org.qiot.covid19.edge.emulator.services;


import org.qiot.covid19.edge.emulator.domain.GasBean;


/**
 * @author abattagl
 *
 */
public interface GasService {

    GasBean produce();

    String produceAsString() throws Exception;
}
