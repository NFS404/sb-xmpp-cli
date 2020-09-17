package io.github.sbcloudrace.sbxmppcli.powerups;

import io.github.sbcloudrace.sbxmppcli.cli.SbXmppClient;
import io.github.sbcloudrace.sbxmppcli.cli.jaxb.xmpp.PowerupActivated;
import io.github.sbcloudrace.sbxmppcli.cli.jaxb.xmpp.XMPP_ResponseType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/powerups")
public class PowerupsController {

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
        powerupActivated.setPersonaId(100L);
        powerupActivatedResponse.setPowerupActivated(powerupActivated);
        SbXmppClient.getInstance().send(powerupActivatedResponse,100L);
        System.out.println("[" + securityToken + "] - [" + targetId + "] - [" + powerupHash + "] - [" + receivers + "]");
    }
}
