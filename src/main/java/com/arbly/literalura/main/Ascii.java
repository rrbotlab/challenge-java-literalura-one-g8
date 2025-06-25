package com.arbly.literalura.main;

public class Ascii {
    public static final String CLEAR_CONSOLE = "\033[H\033[2J";

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static final String LOGO = ANSI_GREEN + """
                __    ____________________  ___    __   __  ______  ___\s
               / /   /  _/_  __/ ____/ __ \\/   |  / /  / / / / __ \\/   |
              / /    / /  / / / __/ / /_/ / /| | / /  / / / / /_/ / /| |
             / /____/ /  / / / /___/ _, _/ ___ |/ /__/ /_/ / _, _/ ___ |
            /_____/___/ /_/ /_____/_/ |_/_/  |_/_____|____/_/ |_/_/  |_|
            """ + ANSI_RESET;

    public static final String ABOUT = ANSI_BLUE + """
                Challenge Literalura
                Alura Latam & Oracle Next Education - ONE - G8
                ©2025 Ricardo G http://github.com/rrbotlab/challenge-java-literalura-one-g8
                Version 1.0.0
                """ + ANSI_RESET;

}
