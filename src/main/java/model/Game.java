package model;

import util.MathUtil;
import util.PropertiesReader;

import java.util.*;

/**
 * An object with simple-Java game mechanisms.
 */
public class Game {
    /*
    Contains current game diapason value.
    In EASY mode here will be min diapasons after each users move.
     */
    private int maxDiapason;
    private int minDiapason;

    /*Generated random value in max - min game diapason.*/
    private int number;

    /*In EASY mode the game diapason is decreases after each [in diapason] input.*/
    private GameMode mode;

    /*Contains all users moves in the game session*/
    private LinkedHashSet<Integer> moves;

    /*Check game is end. Throws an exception when adding new value after isComplete set true.*/
    private boolean isComplete;

    public Game() {
        //default value
        setMode(GameMode.HARD);

        Map<String, String> propsMap = PropertiesReader.getPropertiesMap("game.properties");

        maxDiapason = Integer.valueOf(propsMap.get("maxDiapason"));
        minDiapason = Integer.valueOf(propsMap.get("minDiapason"));

        number = MathUtil.rand(minDiapason, maxDiapason, true);

        isComplete = false;

        moves = new LinkedHashSet<>();
    }

    public GameMode getMode() {
        return mode;
    }

    public void setMode(GameMode mode) {
        this.mode = mode;
    }

    public int getMaxDiapason() {
        return maxDiapason;
    }

    public int getMinDiapason() {
        return minDiapason;
    }

    public boolean isComplete() {
        return isComplete;
    }

    /**
     * Get unmodifiableSet of all users moves in the game session
     * @return unmodifiableSet {@code Set<Integer>}
     */
    public Set<Integer> getMoves() {

        return Collections.unmodifiableSet(moves);
    }

    /**
     * Checks value into the diapason, add to MovesSet users input value.
     * In LIGHT mode decreases diapason after each [in diapason] input.
     * @param value {@code int}
     * @return {@code CheckValueStatus}
     * @throws GameIsEndException
     */
    public CheckValueStatus addNextValue(int value) throws GameIsEndException {

        if (isComplete){
            throw new GameIsEndException();
        }

        moves.add(value);

        if (value > maxDiapason){
            return CheckValueStatus.OUT_OF_MAX_DIAPASON;
        }else if(value < minDiapason){
            return CheckValueStatus.OUT_OF_MIN_DIAPASON;
        }else if(value < number){
            if (mode == GameMode.LIGHT){
                minDiapason = value;
            }
            return CheckValueStatus.INPUT_VALUE_LESS;
        }else if (value > number){
            if (mode == GameMode.LIGHT){
                maxDiapason = value;
            }
            return CheckValueStatus.INPUT_VALUE_GREATER;
        }else {
            isComplete = true;
            return CheckValueStatus.WIN;
        }
    }
}
