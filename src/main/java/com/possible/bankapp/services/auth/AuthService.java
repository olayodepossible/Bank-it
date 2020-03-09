package com.possible.bankapp.services.auth;


import com.possible.bankapp.models.user.User;

import java.util.UUID;

public interface AuthService {
    void createUser(User user);
    void verifyUser(String token);
    String signInUser(String email, String password);
    void resetPassword(String email);
    void setNewPassword(UUID id, String newPassword, String token);
}
