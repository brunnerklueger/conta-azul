package com.rest.service;

import com.rest.enums.CompassRoseEnum;
import com.rest.exception.RestException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class MarsService {

    private static final int MAX_DISTANCE = 5;
    private static final int START_POSITION = 0;

    public String command(String command) {
        int x = START_POSITION;
        int y = START_POSITION;

        CompassRoseEnum currentCardinalDirection = CompassRoseEnum.N;
        for(int i = START_POSITION; i < command.length(); i++) {

            char currentCommand = command.charAt(i);
            switch (currentCommand) {
                case 'L':
                case 'R':
                    currentCardinalDirection = this.findDirection(currentCardinalDirection,currentCommand);
                    break;
                case 'M':
                    switch (currentCardinalDirection) {
                        case N:
                            y++;
                            break;
                        case S:
                            y--;
                            break;
                        case E:
                            x++;
                            break;
                        default:
                            x--;
                            break;
                    }
                    break;
                default:
                    throw new RestException("Entrada possui caracteres inválidos.",HttpStatus.BAD_REQUEST.value());
            }
        }

        if(x < START_POSITION ||  x > MAX_DISTANCE || y < START_POSITION || y > MAX_DISTANCE) {
            throw new RestException(String.format("Entrada inválida. Não é possível acessar a posição (%d,%d)", x,y),HttpStatus.BAD_REQUEST.value());
        }

        return String.format("(%d, %d, %s)", x,y,currentCardinalDirection);
    }

    private CompassRoseEnum findDirection(CompassRoseEnum currentCardinalDirection, char command) {

        CompassRoseEnum newCardinalDirection;

        if(command == 'L') {
            switch (currentCardinalDirection) {
                case N:
                    newCardinalDirection = CompassRoseEnum.W;
                    break;
                case W:
                    newCardinalDirection = CompassRoseEnum.S;
                    break;
                case S:
                    newCardinalDirection = CompassRoseEnum.E;
                    break;
                default:
                    newCardinalDirection = CompassRoseEnum.N;
                    break;
            }
        } else {
            switch (currentCardinalDirection) {
                case N:
                    newCardinalDirection = CompassRoseEnum.E;
                    break;
                case E:
                    newCardinalDirection = CompassRoseEnum.S;
                    break;
                case S:
                    newCardinalDirection = CompassRoseEnum.W;
                    break;
                default:
                    newCardinalDirection = CompassRoseEnum.N;
                    break;
            }
        }

        return newCardinalDirection;
    }

}
