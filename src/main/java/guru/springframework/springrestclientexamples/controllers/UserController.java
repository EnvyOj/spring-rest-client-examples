package guru.springframework.springrestclientexamples.controllers;

import guru.springframework.springrestclientexamples.service.ApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ServerWebExchange;

@Slf4j
@Controller
public class UserController {

    private ApiService apiService;

    public UserController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping
    public String index(){
        return "index";
    }

    @PostMapping("/users")
    public String formPost(Model model, ServerWebExchange serverWebExchange){
        /*MultiValueMap<String, String> map = serverWebExchange.getFormData().block();

        Integer limit = Integer.valueOf(map.get("limit").get(0));

        log.debug("Received limit value: "+limit);
        // default if null or zero
        if(limit == null || limit == 0 || limit > 1){
            log.debug("Setting limit to default of 1");
            limit = 1;
        }*/

        model.addAttribute("users", apiService
                .getUsers(serverWebExchange
                        .getFormData()
                        .map(data -> Integer.valueOf(data.getFirst("limit")))));

        return "userlist";
    }
}
