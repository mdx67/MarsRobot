package com.mdx.mars.robot.model.position;

import com.mdx.mars.robot.type.command.CommandType;
import com.mdx.mars.robot.type.position.DirectionType;

public class Position {

    private Integer x;
    private Integer y;
    private DirectionType direction;

     public Position(Integer x, Integer y, DirectionType direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Integer getX() {
        return this.x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return this.y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public DirectionType getDirection() {
        return direction;
    }

    public void setDirection(DirectionType direction) {
        this.direction = direction;
    }
    
    public void addMoviment() {
        switch (this.getDirection()) {
            case N:
                this.setY(this.getY() + 1);
                break;
            case E:
                this.setX(this.getX() + 1);
                break;
            case S:
                this.setY(this.getY() - 1);
                break;
            case W:
                this.setX(this.getX() - 1);
                break;
        }
    }
    
    public void setNewDirection(CommandType newDirection) {
        if (newDirection == CommandType.R) {
            switch (this.getDirection()) {
                case N:
                    this.setDirection(DirectionType.E);
                    break;
                case E:
                    this.setDirection(DirectionType.S);
                    break;
                case S:
                    this.setDirection(DirectionType.W);
                    break;
                case W:
                    this.setDirection(DirectionType.N);
                    break;
            }
        } else {
            switch (this.getDirection()) {
                case N:
                    this.setDirection(DirectionType.W);
                    break;
                case W:
                    this.setDirection(DirectionType.S);
                    break;
                case S:
                    this.setDirection(DirectionType.E);
                    break;
                case E:
                    this.setDirection(DirectionType.N);
                    break;
            }
        }
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + direction + ')';
    }
}
