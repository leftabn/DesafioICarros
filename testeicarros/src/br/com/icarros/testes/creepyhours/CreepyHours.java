package br.com.icarros.testes.creepyhours;

import java.util.regex.Pattern;

public class CreepyHours {
    static int countCreepyHours(String[] hours) {
        int beepCount = 0;
        String regex = "(\\d)\\1:(\\d)\\2|(\\d)(\\d):\\3\\4|(\\d)(\\d):\\6\\5|(\\d\\d):(\\7)";
        Pattern pattern = Pattern.compile(regex);
        for (String hour : hours) {
            if (pattern.matcher(hour).matches()) {
                beepCount++;
            }
        }
        return beepCount;
    }

    public static void main(String[] args) {
        String[] hours = {"11:00","13:13","00:00","20:02","00:02","10:00"};
        System.out.println(countCreepyHours(hours));
    }
}
