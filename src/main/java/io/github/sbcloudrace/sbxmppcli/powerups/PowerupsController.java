package io.github.sbcloudrace.sbxmppcli.powerups;

import io.github.sbcloudrace.sbxmppcli.cli.SbXmppClient;
import io.github.sbcloudrace.sbxmppcli.cli.jaxb.xmpp.PowerupActivated;
import io.github.sbcloudrace.sbxmppcli.cli.jaxb.xmpp.XMPP_ResponseType;
import io.github.sbcloudrace.sbxmppcli.session.SbSessionServiceProxy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/powerups")
@AllArgsConstructor
public class PowerupsController {

    private SbSessionServiceProxy sbSessionServiceProxy;

    @RequestMapping(value = "/activated/{securityToken}/{targetId}/{powerupHash}/{receivers}",
            method = RequestMethod.PUT)
    @ResponseBody
    public void activated(@PathVariable String securityToken,
                          @PathVariable("targetId") Long targetId,
                          @PathVariable Integer powerupHash,
                          @PathVariable("receivers") String receivers) {
        XMPP_ResponseType powerupActivatedResponse = new XMPP_ResponseType();
        PowerupActivated powerupActivated = new PowerupActivated();
        powerupActivated.setId(powerupHash);
        powerupActivated.setTargetPersonaId(targetId);
        powerupActivated.setPersonaId(sbSessionServiceProxy.activePersonaId(securityToken));
        powerupActivatedResponse.setPowerupActivated(powerupActivated);
        for (String receiver : receivers.split("-")) {
            Long receiverPersonaId = Long.valueOf(receiver);
            if (receiverPersonaId > 10) {
                SbXmppClient.getInstance().send(powerupActivatedResponse, receiverPersonaId);
            }
        }
    }
}
