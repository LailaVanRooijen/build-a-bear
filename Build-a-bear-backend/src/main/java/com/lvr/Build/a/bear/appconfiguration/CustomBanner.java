package com.lvr.Build.a.bear.appconfiguration;

import org.springframework.boot.Banner;
import org.springframework.core.env.Environment;

public class CustomBanner implements Banner {
    private static final String terminalTxtColor = "\u001B[38;2;255;209;102m";
    private static final String primaryColor = "\u001B[38;2;239;71;111m";
    private static final String secondaryColor = "\u001B[38;2;34;116;165m";

    private static final String BANNER_BLOCKS =
            secondaryColor
                    + "\nSuper duper amazing development by\n\n"
                    + primaryColor
                    + "██╗      █████╗ ██╗   ██╗██╗      ██████╗ ██╗    ██╗\n"
                    + "██║     ██╔══██╗╚██╗ ██╔╝██║     ██╔═══██╗██║    ██║\n"
                    + "██║     ███████║ ╚████╔╝ ██║     ██║   ██║██║ █╗ ██║\n"
                    + "██║     ██╔══██║  ╚██╔╝  ██║     ██║   ██║██║███╗██║\n"
                    + "███████╗██║  ██║   ██║   ███████╗╚██████╔╝╚███╔███╔╝\n"
                    + "╚══════╝╚═╝  ╚═╝   ╚═╝   ╚══════╝ ╚═════╝  ╚══╝╚══╝\n\n"
                    + secondaryColor
                    + "Don't forget to have fun!       Spring version 3.2.5\n\n"
                    + terminalTxtColor;


    @Override
    public void printBanner(Environment environment, Class<?> sourceClass, java.io.PrintStream out) {
        out.println(BANNER_BLOCKS);
    }
}