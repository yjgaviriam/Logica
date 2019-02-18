/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author xJoni
 */
public class Formula {
    
    private char value;
    private String text;
    private boolean isOperator;
    private int orientation;

    public Formula(char value, String text, boolean isOperator) {
        this.value = value;
        this.text = text;
        this.isOperator = isOperator;
    }

    public char getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public boolean isIsOperator() {
        return isOperator;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }    
}
