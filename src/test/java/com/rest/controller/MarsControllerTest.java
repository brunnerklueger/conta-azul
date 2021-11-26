package com.rest.controller;

import com.rest.exception.RestException;
import com.rest.service.MarsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MarsControllerTest {

    @InjectMocks
    private MarsController controller;

    @Mock
    private MarsService service;

    @Test
    public void command() {

        when(service.command(any())).thenReturn("(0,2,N)");
        String response = controller.comandar("MM");
        assertNotNull(response);
    }

    @Test(expected = RestException.class)
    public void command_exception() {

        when(service.command(any())).thenThrow(new RestException("a",300));
        controller.comandar("MM");
    }
}
