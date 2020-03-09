package com.possible.bankapp.auth;

import com.possible.bankapp.models.user.User;
import com.possible.bankapp.repositories.UserRepository;
import com.possible.bankapp.services.auth.AuthServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class AuthServiceTest {

    @MockBean
    private UserRepository userRepository;

    @Mock
    private AuthServiceImpl authService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void it_should_return_when_a_user_is_registered() {
        User user = new User();
        user.setEmail("bezkoder@gmail.com");
        when(userRepository.save(any())).thenReturn(user);
    }

    @Test
    public void it_should_verify_a_user_that_is_registered() {
        authService.verifyUser("hjfjhdfj");
        verify(authService, times(1)).verifyUser("hjfjhdfj");
    }
}
