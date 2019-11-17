package com.jkc.github_fetcher.controllers;

import com.jkc.github_fetcher.model.GithubModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class GithubController {

    @GetMapping("/gettingData/user/{user}")
    public GithubModel getData(@PathVariable("user") String user){
        Map<String,Object> urlVariables = new HashMap<>();
        urlVariables.put("user",user);
        ResponseEntity<GithubModel> response = new RestTemplate().getForEntity("https://api.github.com/users/{user}", GithubModel.class,urlVariables);
        return response.getBody();
    }
}
