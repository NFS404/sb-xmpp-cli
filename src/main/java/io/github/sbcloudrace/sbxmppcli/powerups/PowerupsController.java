package io.github.sbcloudrace.sbxmppcli.powerups;

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
        System.out.println("[" + securityToken + "] - [" + targetId + "] - [" + powerupHash + "] - [" + receivers + "]");
    }
}
