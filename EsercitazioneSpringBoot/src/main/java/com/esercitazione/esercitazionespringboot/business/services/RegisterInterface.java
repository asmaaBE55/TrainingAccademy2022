package com.esercitazione.esercitazionespringboot.business.services;

import com.esercitazione.esercitazionespringboot.payload.request.LoginRequest;
import com.esercitazione.esercitazionespringboot.payload.request.SignupRequest;
import com.esercitazione.esercitazionespringboot.security.services.UserDetailsImpl;
import org.springframework.http.ResponseCookie;

public interface RegisterInterface {
    public String createUserBusiness(SignupRequest signUpRequest);

    public UserDetailsImpl authUser(LoginRequest loginRequest);

    public ResponseCookie logoutUser();

    public ResponseCookie authUserCookie(UserDetailsImpl userDetails);
}
