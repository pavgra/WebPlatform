package org.ohdsi.authserver.controller;

import lombok.val;
import org.ohdsi.authserver.model.Role;
import org.ohdsi.authserver.model.User;
import org.ohdsi.authserver.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;
    }

    @RequestMapping(value = "/me", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> user(Principal principal) {

        User user = userService.get(principal.getName());

        val userInfo = new HashMap<String, Object>();
        userInfo.put("user", user.getUsername());
        // Get roles list from DB instead of JWT to eliminate a need for user to re-login after new grants
        userInfo.put("authorities", user.getRoles().stream().map(Role::getName).collect(Collectors.toList()));
        return userInfo;
    }
}
