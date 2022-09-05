package com.anz.greenHouse.Controller;


import com.anz.greenHouse.Model.UserInfo;
import com.anz.greenHouse.WebSecurity.JwtRequest;
import com.anz.greenHouse.WebSecurity.JwtResponse;
import com.anz.greenHouse.WebSecurity.JwtTokenUtil;
import com.anz.greenHouse.WebSecurity.JwtUserDetailService;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/user")
public class UserController
{
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailService userDetailsService;

    JSONParser parser = new JSONParser();

    private void authenticate(String username, String password) throws Exception
    {
        try
        {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }
        catch (DisabledException e)
        {
            throw new Exception("USER_DISABLED", e);
        }
        catch (BadCredentialsException e)
        {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception
    {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody Map<String,String> payload) throws Exception
    {
        //UserInfo user = new UserInfo(payload.get("username"),payload.get("password"),true);
        return ResponseEntity.ok(userDetailsService.saveUser(payload.get("username"),payload.get("password")));
    }

    @PutMapping("/update-user")
    public ResponseEntity<JSONObject> activeUser(@RequestBody Map<String,String> payload) throws Exception
    {
        final boolean status = Boolean.parseBoolean(payload.get("status"));
        final int id = Integer.parseInt(payload.get("id"));
        userDetailsService.disableUser(status,id);

        JSONObject json = (JSONObject) parser.parse("{'status':'Updated to " + status + "'}");
        return ResponseEntity.ok(json);
    }
}
