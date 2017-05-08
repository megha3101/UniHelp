package com.example.dzm2000.unihelp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.lang.reflect.Method;
import java.net.ResponseCache;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dzm2000 on 8/05/2017.
 */

public class RegisterRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL ="https://memg9319.000webhostapp.com/Register.php";
    private Map<String, String> params;

    public RegisterRequest(String name, String username, int id_num, String password, Response.Listener<String> listner){
            super(Method.POST, REGISTER_REQUEST_URL,listner, null);
        params = new HashMap<>();
        params.put("name", name);
        params.put("username", username);
        params.put("password", password);
        params.put("id_num", id_num + "");

    }

    public Map<String, String> getParams() {
        return params;
    }
}
