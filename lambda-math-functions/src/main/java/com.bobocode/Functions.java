package com.bobocode;

import java.util.function.Function;

public class Functions {
    /**
     * A static factory method that creates an integer function map with basic functions:
     * - abs (absolute value)
     * - sgn (signum function)
     * - increment
     * - decrement
     * - square
     *
     * @return an instance of {@link FunctionMap} that contains all listed functions
     */
    public static FunctionMap<Integer, Integer> intFunctionMap() {
        FunctionMap<Integer, Integer> intFunctionMap = new FunctionMap<>();

        intFunctionMap.addFunction("abs", Functions::abs);
        intFunctionMap.addFunction("sgn", Functions::sgn);
        intFunctionMap.addFunction("increment", Functions::increment);
        intFunctionMap.addFunction("decrement", Functions::decrement);
        intFunctionMap.addFunction("square", Functions::square);

        return intFunctionMap;
    }

    private static Integer abs(int number) {
        return number < 0 ? number * -1 : number;
    }

    private static Integer sgn(int number) {
        if (number == 0) return 0;
        return number < 0 ? -1 : 1;
    }

    private static Integer increment(int number) {
        return number + 1;
    }

    private static Integer decrement(int number) {
        return number - 1;
    }

    private static Integer square(int number) {
        return number * number;
    }
}
