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
    private PowerupActivated powerupActivated;

    @XmlElement(name = "LobbyInvite")
    private LobbyInvite lobbyInvite;

    @XmlAttribute(name = "status")
    private int status = 1;
    @XmlAttribute(name = "ticket")
    private int ticket = 0;

}
