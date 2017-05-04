package com.mdx.mars.robot.service.command;

import com.mdx.mars.robot.exception.command.InvalidCommandException;
import com.mdx.mars.robot.exception.position.InvalidPositionException;
import com.mdx.mars.robot.model.position.Position;
import com.mdx.mars.robot.type.command.CommandType;
import com.mdx.mars.robot.type.position.DirectionType;
import com.mdx.mars.robot.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CommandService {

    private static final Integer limitX = 4;
    private static final Integer limitY = 4;

    public String executeCommands(String param) {
        List<CommandType> commands = convertCommands(param);
        
        return executeCommands(commands);
    }
    
    public String executeCommands(List<CommandType> commands) {
        Position newPosition = new Position(0, 0, DirectionType.N);

        commands.stream().forEach(command -> {
            if (command.isMovimentCommand()) {
                newPosition.addMoviment();
            } else if (command.isTurnCommand()) {
                newPosition.setNewDirection(command);
            }

            if (!isValidPosition(newPosition)) {
                throw new InvalidPositionException("Invalid position");
            }
        });

        return newPosition.toString();
    }

    private Boolean isValidPosition(Position position) {
        return !(position.getX() > limitX || position.getX() < 0 || position.getY() > limitY || position.getY() < 0);
    }
    
    public List<CommandType> convertCommands(String params) {
        List<String> stringCommands = StringUtils.getListFromString(params);

        List<CommandType> commands = new ArrayList<>();

        stringCommands.forEach(command -> {
            CommandType type;

            try {
                type = CommandType.valueOf(command.toUpperCase());
            } catch (IllegalArgumentException e) {
                throw new InvalidCommandException("Invalid command");
            }

            commands.add(type);
        });

        return commands;
    }
}
