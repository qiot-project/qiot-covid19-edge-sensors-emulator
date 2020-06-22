/**
 * 
 */
package com.redhat.qiot.edge.emulator.services;


import com.redhat.qiot.edge.emulator.domain.PartuculatesBean;


/**
 * @author abattagl
 *
 */
public interface ParticulatesService {

    PartuculatesBean produce();

    String produceAsString() throws Exception;
}
