package com.coderbd.restapidisplaylist.model;

import com.coderbd.restapidisplaylist.entity.User;
import com.coderbd.restapidisplaylist.util.BaseUrl;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by user on 4/23/2018.
 */

public class UserModel {
    RestTemplate restTemplate = new RestTemplate();

    public List<User> findAll() {
        try {
            return restTemplate.exchange(BaseUrl.API_BASE_URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
            }).getBody();
        } catch (Exception e) {

            return null;
        }
    }
}
