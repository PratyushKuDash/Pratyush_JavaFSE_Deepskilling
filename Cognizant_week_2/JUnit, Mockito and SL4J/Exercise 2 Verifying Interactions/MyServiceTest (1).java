package com.example.service;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

public class MyServiceTest {
    
    @Test
    public void testVerifyInteraction() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        service.fetchData();
        verify(mockApi).getData();
        verify(mockApi, times(1)).getData(); 
        verify(mockApi, never()).deleteData(); 
        verify(mockApi, atLeastOnce()).getData(); 
    }
    
    @Test
    public void testVerifyInteractionWithArguments() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        
        service.processData("test-id", 42);
        
        verify(mockApi).updateData(eq("test-id"), eq(42));
      
        verify(mockApi).updateData(anyString(), anyInt());
    }
    
    @Test
    public void testVerifyInteractionOrder() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        
        service.complexOperation();
       
        InOrder inOrder = inOrder(mockApi);
        inOrder.verify(mockApi).start();
        inOrder.verify(mockApi).process();
        inOrder.verify(mockApi).end();
    }
}