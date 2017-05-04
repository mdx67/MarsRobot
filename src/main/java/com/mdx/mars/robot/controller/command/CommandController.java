package com.mdx.mars.robot.controller.command;

import com.mdx.mars.robot.exception.command.InvalidCommandException;
import com.mdx.mars.robot.exception.rest.BadRequestException;
import com.mdx.mars.robot.exception.position.InvalidPositionException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.mdx.mars.robot.service.command.CommandService;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Controller
@RequestMapping("/rest")
@Transactional
public class CommandController {

    @Autowired
    public CommandService commandService;

    @RequestMapping(value = "/mars/{commands}", method = RequestMethod.POST)
    public ResponseEntity newCommand(@PathVariable("commands") String commands) throws BadRequestException {
        try {
            String result = commandService.executeCommands(commands);

            return new ResponseEntity(result, HttpStatus.OK);
        } catch (InvalidPositionException | InvalidCommandException e) {
            e.printStackTrace();

            throw new BadRequestException(e.getMessage());
        }
    }
}
