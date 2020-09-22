
package io.github.sbcloudrace.sbxmppcli.cli.jaxb.xmpp;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the io.github.sbcloudrace.sbxmppcli.cli.jaxb.xmpp package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _LobbyInvite_QNAME = new QName("", "LobbyInvite");
    private final static QName _PowerupActivated_QNAME = new QName("", "PowerupActivated");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: io.github.sbcloudrace.sbxmppcli.cli.jaxb.xmpp
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LobbyInvite }
     * 
     */
    public LobbyInvite createLobbyInvite() {
        return new LobbyInvite();
    }

    /**
     * Create an instance of {@link PowerupActivated }
     * 
     */
    public PowerupActivated createPowerupActivated() {
        return new PowerupActivated();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LobbyInvite }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "LobbyInvite")
    public JAXBElement<LobbyInvite> createLobbyInvite(LobbyInvite value) {
        return new JAXBElement<LobbyInvite>(_LobbyInvite_QNAME, LobbyInvite.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PowerupActivated }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PowerupActivated")
    public JAXBElement<PowerupActivated> createPowerupActivated(PowerupActivated value) {
        return new JAXBElement<PowerupActivated>(_PowerupActivated_QNAME, PowerupActivated.class, null, value);
    }

}
