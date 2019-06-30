package com.Console.ActValue;

@Act(type = {long.class, Long.class})
public class ActLong extends ActValueDefault<Long> {

    @Override
    public String getMassage() {
        return "Entered number";
    }

    @Override
    public Long isTrueFormat(String string) {
        return (string != null && string.matches("(\\+|\\-)?\\d*")) ? Long.valueOf(string) : null;
    }
}
