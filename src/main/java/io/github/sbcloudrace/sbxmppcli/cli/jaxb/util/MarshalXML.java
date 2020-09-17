package io.github.sbcloudrace.sbxmppcli.cli.jaxb.util;

import io.github.sbcloudrace.sbxmppcli.cli.jaxb.xmpp.PowerupActivated;
import io.github.sbcloudrace.sbxmppcli.cli.jaxb.xmpp.XMPP_ResponseType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.StringWriter;

public class MarshalXML {

    @SuppressWarnings("unchecked")
    public static String marshal(Object obj) {
        StringWriter stringWriter = new StringWriter();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
            XmlRootElement xmlRootAnnotation = obj.getClass().getAnnotation(XmlRootElement.class);
            System.out.println(xmlRootAnnotation);
            if (xmlRootAnnotation == null) {
                String xmlTypeAnnotationName ="nothing";
                XmlType xmlTypeAnnotation = obj.getClass().getAnnotation(XmlType.class);
                if(xmlTypeAnnotation != null){
                    xmlTypeAnnotationName = xmlTypeAnnotation.name();
                }
                QName qname = new QName("", xmlTypeAnnotationName);
                JAXBElement<Object> jaxbElement = new JAXBElement<Object>(qname, (Class<Object>) obj.getClass(), null, obj);
                jaxbMarshaller.marshal(jaxbElement, stringWriter);
            } else {
                jaxbMarshaller.marshal(obj, stringWriter);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringWriter.toString();
    }

    public static void main(String[] args) {
        XMPP_ResponseType powerupActivatedResponse = new XMPP_ResponseType();
        PowerupActivated powerupActivated = new PowerupActivated();
        powerupActivated.setId(666);
        powerupActivated.setTargetPersonaId(123L);
        powerupActivated.setPersonaId(123l);
        powerupActivatedResponse.setPowerupActivated(powerupActivated);
        String responseXmlStr = MarshalXML.marshal(powerupActivatedResponse);
        System.out.println(responseXmlStr);
    }
}
