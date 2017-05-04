package com.mdx.mars.robot.service.command;

import static org.junit.Assert.*;
import com.mdx.mars.robot.exception.command.InvalidCommandException;
import com.mdx.mars.robot.exception.position.InvalidPositionException;
import com.mdx.mars.robot.type.command.CommandType;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.mockito.InjectMocks;

public class CommandServiceTest {

    @InjectMocks
    public CommandService commandService = new CommandService();

    @Test
    public void testSetNewSimplePosition() {
        List<CommandType> commands = Arrays.asList(CommandType.M, CommandType.M, CommandType.L);

        assertEquals("(0, 2, W)", commandService.executeCommands(commands));
    }

    @Test
    public void testSetNewComplexPosition() {
        List<CommandType> commands = Arrays.asList(CommandType.M, CommandType.M, CommandType.R, CommandType.M, CommandType.M, CommandType.R, CommandType.M, CommandType.M);

        assertEquals("(2, 0, S)", commandService.executeCommands(commands));
    }

    @Test
    public void testSetNewComplexPosition2() {
        List<CommandType> commands = Arrays.asList(CommandType.R, CommandType.M, CommandType.M, CommandType.M, CommandType.L, CommandType.M, CommandType.M, CommandType.M, CommandType.L, CommandType.M, CommandType.M, CommandType.M, CommandType.L, CommandType.M, CommandType.M, CommandType.M);

        assertEquals("(0, 0, S)", commandService.executeCommands(commands));
    }

    @Test(expected = InvalidPositionException.class)
    public void testInvalidPosition() {
        List<CommandType> commands = Arrays.asList(CommandType.M, CommandType.M, CommandType.M, CommandType.M, CommandType.M, CommandType.M, CommandType.M, CommandType.M);

        commandService.executeCommands(commands);
    }

    @Test(expected = InvalidPositionException.class)
    public void testInvalidPosition2() {
        List<CommandType> commands = Arrays.asList(CommandType.L, CommandType.M);

        commandService.executeCommands(commands);
    }

    @Test
    public void testConvertAndValidateCommands() {
        List<CommandType> expecteds = Arrays.asList(CommandType.M, CommandType.M, CommandType.L, CommandType.R);

        List<CommandType> commands = commandService.convertCommands("MMLR");

        assertArrayEquals(expecteds.toArray(), commands.toArray());
    }

    @Test(expected = InvalidCommandException.class)
    public void testConvertAndValidateInvalidCommands() {
        commandService.convertCommands("MBLR");
    }
}
