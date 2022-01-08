package com.bagus.findhawker.hawker;

import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;

public interface HawkerService {

    void initializeHawkersData();

    HawkersEntity getHawkers(GetHawkersRequest request);
}
