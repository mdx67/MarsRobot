package com.mdx.mars.robot.model.position;

import com.mdx.mars.robot.type.command.CommandType;
import com.mdx.mars.robot.type.position.DirectionType;
import org.junit.Test;
import static org.junit.Assert.*;

public class PositionTest {

    @Test
    public void testAddOneMoviment() {
        Position position = new Position(0, 0, DirectionType.N);

        position.addMoviment();

        assertEquals(new Integer(1), position.getY());
        assertEquals(new Integer(0), position.getX());
    }

    @Test
    public void testAddFourMoviments() {
        Position position = new Position(0, 0, DirectionType.N);

        position.addMoviment();
        position.addMoviment();
        position.addMoviment();
        position.addMoviment();

        assertEquals(new Integer(4), position.getY());
        assertEquals(new Integer(0), position.getX());
    }

    @Test
    public void testSetLeftDirection() {
        Position position = new Position(0, 0, DirectionType.N);

        position.setNewDirection(CommandType.L);

        assertEquals(DirectionType.W, position.getDirection());
    }

    @Test
    public void testSetRightDirection() {
        Position position = new Position(0, 0, DirectionType.N);

        position.setNewDirection(CommandType.R);

        assertEquals(DirectionType.E, position.getDirection());
    }

    @Test
    public void testSetTwoLeftDirection() {
        Position position = new Position(0, 0, DirectionType.N);

        position.setNewDirection(CommandType.L);
        position.setNewDirection(CommandType.L);

        assertEquals(DirectionType.S, position.getDirection());
    }

    @Test
    public void testSetTwoRightDirection() {
        Position position = new Position(0, 0, DirectionType.N);

        position.setNewDirection(CommandType.R);
        position.setNewDirection(CommandType.R);

        assertEquals(DirectionType.S, position.getDirection());
    }

    @Test
    public void testSetNewDirectionAndNewMoviment() {
        Position position = new Position(0, 0, DirectionType.N);

        position.setNewDirection(CommandType.R);
        position.addMoviment();

        assertEquals(DirectionType.E, position.getDirection());
        assertEquals(new Integer(1), position.getX());
    }
}
