package seminars.third.tdd;

import org.assertj.core.util.Arrays;

public class MoodAnalyser {
    String[]good = new String[]{"Hi", "Hello", "Ok"};
    String[]bad = new String[]{"By", "Bad", "Sad"};

    public String analyseMood(String message) {
        if (Arrays.asList(good).contains(message)) {
            return "Great";
        }
        if (Arrays.asList(bad).contains(message)) {
            return "Sad";
        }
        return "I can't understand";
    }

}