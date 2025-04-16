package com.example.OnlineBankProcess.Testing;

import com.example.OnlineBankProcess.Entity.Role;
import com.example.OnlineBankProcess.Entity.User;
import com.example.OnlineBankProcess.Service.UserService;
import com.example.OnlineBankProcess.UserRepo.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class UserServiceTesting {

    private UserService userService;
    private UserRepository userRepository = Mockito.mock(UserRepository.class);
    private User user;

    @Before
    public void setUp() {
        userService = new UserService(userRepository);

        user = new User();
        user.setName("John Doe");
        user.setEmail("john@example.com");
        user.setPassword("password123");
        user.setRole(Role.CUSTOMER);
    }

    @Test
    public void testRegisterUser() {
        // Mock repository behavior
        when(userRepository.save(any(User.class))).thenReturn(user);

        // Call service method
        User savedUser = userService.registerUser(user);

        // Assertions
        Assert.assertNotNull(savedUser);
        Assert.assertEquals("John Doe", savedUser.getName());
        Assert.assertEquals("john@example.com", savedUser.getEmail());

        // Verify repository was called once
        verify(userRepository, times(1)).save(any(User.class));
    }
}
