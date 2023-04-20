package org.example;

import businessLogic.Control;
import interf.Interface;

public class Main {
    public static void main(String[] args) {

        Interface i = new Interface();
        Control c = new Control(i);

    }
}