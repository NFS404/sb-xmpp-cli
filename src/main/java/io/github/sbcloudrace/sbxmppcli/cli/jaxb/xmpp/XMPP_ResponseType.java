package io.github.sbcloudrace.sbxmppcli.cli.jaxb.xmpp;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@XmlRootElement(name = "response")
public class XMPP_ResponseType {

    @XmlElement(name = "PowerupActivated")
    protected PowerupActivated powerupActivated;

    @XmlAttribute(name = "status")
    protected int status = 1;
    @XmlAttribute(name = "ticket")
    protected int ticket = 0;

}
