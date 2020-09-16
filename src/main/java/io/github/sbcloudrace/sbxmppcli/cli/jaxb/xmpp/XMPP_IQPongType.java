package io.github.sbcloudrace.sbxmppcli.cli.jaxb.xmpp;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMPP_IQPongType", propOrder = {"from", "to", "id", "type"})
@XmlRootElement(name = "iq")
@Getter
@Setter
public class XMPP_IQPongType {
    @XmlAttribute(name = "from")
    private String from;
    @XmlAttribute(name = "to")
    private String to;
    @XmlAttribute(name = "id")
    private String id;
    @XmlAttribute(name = "type", required = true)
    private String type = "result";

    public XMPP_IQPongType() {
    }

    public XMPP_IQPongType(String id) {
        from = String.format("sbrw.engine.engine@%s/EA_Chat", "127.0.0.1");
        to = "127.0.0.1";
        this.id = id;
    }


}
