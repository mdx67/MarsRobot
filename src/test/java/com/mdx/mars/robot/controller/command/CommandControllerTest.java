package com.mdx.mars.robot.controller.command;

import com.mdx.mars.robot.service.command.CommandService;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CommandControllerTest {

    @InjectMocks
    CommandController controller;

    @Mock
    CommandService commandService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testNewCommand() throws Exception {
        ResponseEntity result = controller.newCommand("MML");

        assertTrue(result.getStatusCode() == HttpStatus.OK);
    }
}
