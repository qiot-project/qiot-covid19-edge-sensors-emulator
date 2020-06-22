/**
 * 
 */
package com.redhat.qiot.edge.emulator.services;


import com.redhat.qiot.edge.emulator.domain.GasBean;


/**
 * @author abattagl
 *
 */
public interface GasService {

    GasBean produce();

    String produceAsString() throws Exception;
}
