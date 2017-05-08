package com.example.dzm2000.unihelp;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dzm2000 on 8/05/2017.
 */

public class LoginRequest extends StringRequest {
        private static final String LOGIN_REQUEST_URL ="https://memg9319.000webhostapp.com/Login.php";
        private Map<String, String> params;

        public RegisterRequest(String username, String password, Response.Listener<String> listner){
            super(Method.POST, LOGIN_REQUEST_URL,listner, null);
            params = new HashMap<>();
            params.put("username", username);
            params.put("password", password);


        }

        public Map<String, String> getParams() {
            return params;
        }
    }

}
