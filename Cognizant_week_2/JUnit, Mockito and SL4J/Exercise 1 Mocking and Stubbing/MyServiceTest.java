package com.example.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MyServiceTest {

    @Mock
    private ExternalApi mockApi;
    
    @InjectMocks
    private MyService myService;
    
    @Test
    void testFetchData() {
        // Arrange (stubbing)
        when(mockApi.getData()).thenReturn("Mocked Data");
        
        // Act
        String result = myService.fetchData();
        
        // Assert
        assertEquals("Mocked Data", result);
        verify(mockApi).getData();
    }
    
    @Test
    void testApiAvailable() {
        when(mockApi.getStatusCode()).thenReturn(200);
        assertTrue(myService.isApiAvailable());
    }
    
    @Test
    void testApiNotAvailable() {
        when(mockApi.getStatusCode()).thenReturn(404);
        assertFalse(myService.isApiAvailable());
    }
}