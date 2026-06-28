package com.exercises.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserRepositoryQueryTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void testFindByName_returnsMatchingUsers() {
        List<User> expected = List.of(
                new User(1L, "Alice"),
                new User(2L, "Alice")
        );
        when(userRepository.findByName("Alice")).thenReturn(expected);

        List<User> result = userService.getUsersByName("Alice");

        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(u -> "Alice".equals(u.getName())));
        verify(userRepository).findByName("Alice");
    }

    @Test
    void testFindByName_noResults() {
        when(userRepository.findByName("Unknown")).thenReturn(List.of());

        List<User> result = userService.getUsersByName("Unknown");

        assertTrue(result.isEmpty());
    }
}
