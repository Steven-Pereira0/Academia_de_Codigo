package org.academiadecodigo.bananayellow.cards;

public enum CardValue {

    C__R(4,"K"),
    C__J(3, "J"),
    C__D(2,"D"),
    C_10(0,"10"),
    C_09(0, "9"),
    C_08(0,"8"),
    C_07(0, "7"),
    C_06(0,"6"),
    C_05(10, "5"),
    C_04(0, "4"),
    C_03(0,"3"),
    C_02(0, "2"),
    C__A(11, "A");

    private int value;
    private String code;

    CardValue(int value, String code) {
        this.value = value;
        this.code = code;
    }
}
