package day1;

import java.util.regex.*;

public class timeConversion {
    public static void main(String[] args) {
        //String s = "12:01:00PM";
        String s = "07:05:45PM";
        s = timeConversion(s);
        System.out.println(s);
    }

    public static String timeConversion(String s) {
        // Note: period is just a boolean beforeMidday (AM true PM false)
        // boolean beforeMidday = s.substring(len-2, len).equals("AM");
        // if (!beforeMidday)
        /*
        int len = s.length();
        String period = s.substring(len-2, len);
        System.out.println(period);
        s = s.substring(0, len-2);
        String [] times = s.split(":");
        for(String time : times) {
             System.out.println(time);
         }
        if (period.equals("PM")) {
            if (!times[0].equals("12")) {
                int calc = Integer.parseInt(times[0]) + 12;
                times[0] = String.valueOf(calc);
            }
        } else {
            if (times[0].equals("12")) {
                times[0] = "00";
            }
        }
        //s = times[0] + ":" + times[1] + ":" + times[2];
        s = String.join(":", times);

        return s;*/

        String period = "";
        int hour = 0;

        Pattern pattern = Pattern.compile("\\w\\w$");
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            period = matcher.group();
            //System.out.println(period);
            s = matcher.replaceAll("");
        }

        pattern = Pattern.compile("^\\d\\d");
        matcher = pattern.matcher(s);
        if (matcher.find()) {
            hour = Integer.parseInt(matcher.group());
            //System.out.println(hour);
        }

        if (period.equals("PM")) {
            if (hour != 12) {
                s = matcher.replaceFirst(String.valueOf(hour+12));
            }
        } else {
            if (s.startsWith("12")) {
                //s = matcher.replaceFirst("00");
                s = s.replace("12", "00");
            }
        }

        return s;
    }
}
