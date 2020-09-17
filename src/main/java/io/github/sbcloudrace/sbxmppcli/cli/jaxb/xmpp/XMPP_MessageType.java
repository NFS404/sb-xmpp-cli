package io.github.sbcloudrace.sbxmppcli.cli.jaxb.xmpp;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "messageType", propOrder = {"body", "subject"})
@XmlRootElement(name = "message")
@Getter
@Setter
public class XMPP_MessageType {

    @XmlElement(required = true)
    private String body;
    @XmlAttribute(name = "from")
    private String from = "";
    @XmlAttribute(name = "id")
    private String id = "JN_1234567";
    @XmlAttribute(name = "to")
    private String to;
    @XmlElement(required = true)
    private Long subject;

    public XMPP_MessageType() {
        from = "sbrw.engine.engine@" + "127.0.0.1";
    }

    public void setToPersonaId(Long personaId) {
        this.to = "sbrw." + personaId.toString() + "@" + "127.0.0.1";
    }
}
