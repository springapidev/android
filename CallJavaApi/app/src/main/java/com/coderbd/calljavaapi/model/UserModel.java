package com.coderbd.calljavaapi.model;

import android.util.Log;

import com.coderbd.calljavaapi.entity.User;
import com.coderbd.calljavaapi.util.BaseUrl;
import org.json.JSONObject;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Rajaul Islam on 4/22/2018.
 */

public class UserModel {
    private RestTemplate restTemplate = new RestTemplate();

    public List<User> findAll() {
        try {
            return restTemplate.exchange(BaseUrl.BASE_API_URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
            }).getBody();
        } catch (Exception e) {
            return null;
        }
    }

    public User findByid(Long id) {
        try {
            return restTemplate.exchange(BaseUrl.BASE_API_URL + "id", HttpMethod.GET, null, new ParameterizedTypeReference<User>() {
            }).getBody();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean create(User user) {
        try {
            Map<String, String> values = new HashMap<String, String>();
            values.put("firstName", user.getFirstName());
            values.put("lastName", user.getLastName());
            values.put("email", user.getEmail());
            JSONObject jsonpObject = new JSONObject(values);
            HttpHeaders httpHeaders=new HttpHeaders();
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity=new HttpEntity<String>(jsonpObject.toString(),httpHeaders);
            restTemplate.postForEntity(BaseUrl.BASE_API_URL, entity, null);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean update(User user) {
        try {
            Map<String, String> values = new HashMap<String, String>();
            values.put("id", String.valueOf(user.getId()));
            values.put("firstName", user.getFirstName());
            values.put("lastName", user.getLastName());
            values.put("email", user.getEmail());
            JSONObject jsonpObject = new JSONObject(values);
            HttpHeaders httpHeaders=new HttpHeaders();
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity=new HttpEntity<String>(jsonpObject.toString(),httpHeaders);
            restTemplate.postForEntity(BaseUrl.BASE_API_URL, entity, null);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean delete(Long id) {
        try {
            restTemplate.delete(BaseUrl.BASE_API_URL + id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
