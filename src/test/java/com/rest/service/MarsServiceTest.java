package com.rest.service;

import com.rest.exception.RestException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class MarsServiceTest {

    @InjectMocks
    private MarsService service;

    @Test
    public void comand_succes_test_1() {
        String response =service.command("MM");
        assertEquals("(0, 2, N)",response);
    }

    @Test
    public void comand_succes_test_2() {
        String response =service.command("MMRMMRMM");
        assertEquals("(2, 0, S)",response);
    }

    @Test
    public void comand_succes_test_3() {
        String response =service.command("MML");
        assertEquals("(0, 2, W)",response);
    }

    @Test
    public void comand_succes_test_4() {
        String response =service.command("MMLLML");
        assertEquals("(0, 1, E)",response);
    }

    @Test
    public void comand_succes_test_5() {
        String response =service.command("MMLLMLL");
        assertEquals("(0, 1, N)",response);
    }

    @Test
    public void comand_succes_test_6() {
        String response =service.command("MMRRMR");
        assertEquals("(0, 1, W)",response);
    }

    @Test
    public void comand_succes_test_7() {
        String response =service.command("MMRRMRR");
        assertEquals("(0, 1, N)",response);
    }

    @Test(expected = RestException.class)
    public void comand_exception_test_1() {
        service.command("AAA");
    }

    @Test(expected = RestException.class)
    public void comand_exception_test_2() {
        service.command("MMMMMMMMMM");
    }

    @Test(expected = RestException.class)
    public void comand_exception_test_3() {
        service.command("LMMMMMMMMMM");
    }

}
