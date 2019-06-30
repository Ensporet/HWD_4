package com.Console.ActValue;

@Act(type = {Character.class, char.class})
public class ActCharter extends ActValueDefault<Character> {

    @Override
    public String getMassage() {
        return "Entered NUMBER from 0 to 65535 or one symbol";
    }

    @Override
    public Character isTrueFormat(String string) {


        if (string == null || string.isEmpty()) {
            return null;
        }


        if (string.length() == 1) {
            return string.charAt(0);
        }


        return string.matches(
                "\\+?0*" +
                        "(([1-5]\\d\\d\\d\\d)|" +
                        "([6][0-4]\\d\\d\\d)|" +
                        "([6][5][0-4]\\d\\d)|" +
                        "([6][5][5][0-2]\\d)|" +
                        "([6][5][5][3][0-5])|" +
                        "(\\d\\d?\\d?\\d?))"

        ) ? (char) Integer.valueOf(string).intValue() : null;


    }


}
