package com.possible.bankapp.auth;

import com.possible.bankapp.controllers.AuthController;
import com.possible.bankapp.repositories.UserRepository;
import com.possible.bankapp.responses.Response;
import com.possible.bankapp.services.auth.AuthService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class AuthControllerTest {


    @Mock
    private AuthService authService;

    @Mock
    private AuthController authController;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void it_should_return_response_created() {
        SignUpRequest newTestUser = new SignUpRequest("Uthman", "uthman@gmail.com", "uthman",
                "9876578");
        Response<String> result = new Response<>(HttpStatus.CREATED);
        result.setData(null);
        result.setMessage("You have successfully signed up on Bank-It");
        ResponseEntity<Response<String>> response = new ResponseEntity<>(result, HttpStatus.CREATED);
        when(authController.createUser(newTestUser)).thenReturn(response);
    }

    @Test
    public void it_should_verify_and_return_response_accepted() {
        SignUpRequest newTestUser = new SignUpRequest("Usman", "usman@gmail.com", "usmansj",
                "9876578");
        Response<String> result = new Response<>(HttpStatus.BAD_REQUEST);
        result.setData(null);
        ResponseEntity<Response<String>> response = new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        when(authController.verifyUser("newTestUser")).thenReturn(response);
    }
}
