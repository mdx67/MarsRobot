package com.mdx.mars.robot.type.command;

import java.util.Arrays;

public enum CommandType {
    
    L, R, M;
 
    public Boolean isMovimentCommand() {
        return this == CommandType.M;
    }
    
    public Boolean isTurnCommand() {
        return Arrays.asList(CommandType.L, CommandType.R).contains(this);
    }
}
