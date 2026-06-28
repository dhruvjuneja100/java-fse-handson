package com.exercises.mockexamples;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MyServiceTest {

    @Test
    void testExternalApi_mockingAndStubbing() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mock Data");

        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        assertEquals("Mock Data", result);
    }

    @Test
    void testVerifyInteraction() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mock Data");

        MyService service = new MyService(mockApi);
        service.fetchData();

        verify(mockApi).getData();
    }

    @Test
    void testArgumentMatching() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.pushData("test-payload");

        verify(mockApi).sendData(eq("test-payload"));
        verify(mockApi, never()).getData();
    }

    @Test
    void testHandlingVoidMethod() {
        ExternalApi mockApi = mock(ExternalApi.class);
        doNothing().when(mockApi).sendData(anyString());

        MyService service = new MyService(mockApi);
        service.pushData("data");

        verify(mockApi).sendData("data");
    }

    @Test
    void testMultipleReturnValues() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData())
                .thenReturn("First Response")
                .thenReturn("Second Response");

        MyService service = new MyService(mockApi);

        assertEquals("First Response", service.fetchData());
        assertEquals("Second Response", service.fetchData());
    }

    @Test
    void testVerifyInteractionOrder() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Data");

        MyService service = new MyService(mockApi);
        service.fetchData();
        service.pushData("payload");

        InOrder inOrder = inOrder(mockApi);
        inOrder.verify(mockApi).getData();
        inOrder.verify(mockApi).sendData("payload");
    }

    @Test
    void testVoidMethodThrowsException() {
        ExternalApi mockApi = mock(ExternalApi.class);
        doThrow(new RuntimeException("Send failed")).when(mockApi).sendData(anyString());

        MyService service = new MyService(mockApi);

        assertThrows(RuntimeException.class, () -> service.pushData("data"));
        verify(mockApi).sendData("data");
    }
}
