package io.github.sbcloudrace.sbxmppcli.session;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "SB-SESSION", path = "/sb-session")
public interface SbSessionServiceProxy {

    @RequestMapping(value = "/tokensession/active-persona-id/{securityToken}", method = RequestMethod.GET)
    Long activePersonaId(@PathVariable("securityToken") String securityToken);

}
