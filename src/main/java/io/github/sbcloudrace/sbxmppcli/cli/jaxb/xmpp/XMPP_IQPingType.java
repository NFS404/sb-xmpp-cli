package io.github.sbcloudrace.sbxmppcli.cli.jaxb.xmpp;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMPP_IQPingType", propOrder = {"type", "id", "from", "to", "ping"})
@XmlRootElement(name = "iq")
@Getter
@Setter
public class XMPP_IQPingType {
    @XmlAttribute(name = "type", required = true)
    private String type;
    @XmlAttribute(name = "id")
    private String id;
    @XmlAttribute(name = "from")
    private String from;
    @XmlAttribute(name = "to")
    private String to;
    @XmlElement(namespace = "urn:xmpp:ping")
    private String ping;

}
