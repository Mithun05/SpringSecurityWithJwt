package com.room.accesser.jwt.examples.roomsecurity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.room.accesser.jwt.examples.roomuser.UserRoom;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

public class AuthenticateRoomUserWithJWT extends UsernamePasswordAuthenticationFilter {
    
	AuthenticationManager authenticationManager;

	public AuthenticateRoomUserWithJWT(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
		try {
			
			UserRoom userCred = new ObjectMapper().readValue(request.getInputStream(), UserRoom.class);

			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userCred.getUserName(), userCred.getUserPassword(), new ArrayList<>()));
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication auth) throws IOException, ServletException {

        String token = JWT.create()
                .withSubject(((User) auth.getPrincipal()).getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + RoomSecurityConstant.EXPIRATION_TIME))
                .sign(HMAC512(RoomSecurityConstant.SECRET.getBytes()));
        
        response.addHeader(RoomSecurityConstant.HEADER_STRING, RoomSecurityConstant.TOKEN_PREFIX + token);
    }

}
