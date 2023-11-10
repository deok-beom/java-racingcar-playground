package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Terminal {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String in(String message) throws IOException {
        System.out.println(message);
        return br.readLine();
    }

    public static void outln(String str) {
        System.out.println(str);
    }
}
