package cz.osu;

import java.util.regex.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Pattern pattern = Pattern.compile("(\\d{2})(\\d{2})(\\d{2})/(\\d+)");
        Matcher mikoMatcher = pattern.matcher("990528/5973");

        if (mikoMatcher.matches()) {
            StringBuilder regexReport = new StringBuilder()
                    .append("Year: 19")
                    .append(mikoMatcher.group(1))
                    .append("; Month: ")
                    .append(mikoMatcher.group(2))
                    .append("; Day: ")
                    .append(mikoMatcher.group(3))
                    .append("; Generated code: ")
                    .append(mikoMatcher.group(4));

            System.out.println(regexReport.toString());
        }
    }

}
