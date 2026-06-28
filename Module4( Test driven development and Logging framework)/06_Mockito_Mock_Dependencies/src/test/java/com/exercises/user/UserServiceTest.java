package com.exercises.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void testGetUserById_found() {
        User user = new User(1L, "Alice");
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User result = userService.getUserById(1L);

        assertNotNull(result);
        assertEquals("Alice", result.getName());
        verify(userRepository).findById(1L);
    }

    @Test
    void testGetUserById_notFound() {
        when(userRepository.findById(99L)).thenReturn(Optional.empty());

        User result = userService.getUserById(99L);

        assertNull(result);
    }

    @Test
    void testGetUserOrThrow_throwsWhenNotFound() {
        when(userRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(java.util.NoSuchElementException.class, () -> userService.getUserOrThrow(99L));
    }

    @Test
    void testSaveUser() {
        User user = new User(null, "Bob");
        User savedUser = new User(1L, "Bob");
        when(userRepository.save(user)).thenReturn(savedUser);

        User result = userService.saveUser(user);

        assertEquals(1L, result.getId());
        assertEquals("Bob", result.getName());
    }

    @Test
    void testGetUsersByName() {
        List<User> users = List.of(new User(1L, "Alice"), new User(2L, "Alice"));
        when(userRepository.findByName("Alice")).thenReturn(users);

        List<User> result = userService.getUsersByName("Alice");

        assertEquals(2, result.size());
    }
}
