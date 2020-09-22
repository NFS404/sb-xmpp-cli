package io.github.sbcloudrace.sbxmppcli.lobby;


import io.github.sbcloudrace.sbxmppcli.cli.SbXmppClient;
import io.github.sbcloudrace.sbxmppcli.cli.jaxb.xmpp.LobbyInvite;
import io.github.sbcloudrace.sbxmppcli.cli.jaxb.xmpp.XMPP_ResponseType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/lobby")
@AllArgsConstructor
public class LobbyController {

    @RequestMapping(value = "/send-join-event/{lobbyInviteId}/{eventId}/{personaId}",
            method = RequestMethod.PUT)
    @ResponseBody
    public void sendJoinEvent(@PathVariable Long lobbyInviteId,
                              @PathVariable Integer eventId,
                              @PathVariable Long personaId){
        LobbyInvite lobbyInvite = new LobbyInvite();
        lobbyInvite.setEventId(eventId);
        lobbyInvite.setLobbyInviteId(lobbyInviteId);
        lobbyInvite.setInviteLifetimeInMilliseconds(10000);
        XMPP_ResponseType xmpp_responseType = new XMPP_ResponseType();
        xmpp_responseType.setLobbyInvite(lobbyInvite);
        SbXmppClient.getInstance().send(xmpp_responseType, personaId);
    }
}
