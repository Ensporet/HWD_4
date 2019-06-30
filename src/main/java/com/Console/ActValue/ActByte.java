package com.Console.ActValue;

@Act(type = {Byte.class, byte.class})
public class ActByte extends ActValueDefault<Byte> {


    @Override
    public String getMassage() {
        return "Entered NUMBER from -128 to 127";
    }

    @Override
    public Byte isTrueFormat(String string) {

        return (string != null && !string.isEmpty() &&
                string.matches(
                        "(\\+?0*" +
                                "((\\d\\d?)|" +
                                "([1][0-1]\\d)|" +
                                "([1][2][0-7])|" +
                                "))|" +
                                "(\\-?0*" +
                                "((\\d\\d?)|" +
                                "([1][0-1]\\d)|" +
                                "([1][2][0-8])" +
                                "))"


                )
        ) ? Byte.valueOf(string) : null;


    }


}


