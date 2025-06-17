package phonebook;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

public class Timer {
    public LocalTime findTime(long start, long end) {
        long time = end - start;
        int minutes = (int) TimeUnit.NANOSECONDS.toMinutes(time);
        int seconds = (int) TimeUnit.NANOSECONDS.toSeconds(time) % 60;
        int millis = (int) TimeUnit.NANOSECONDS.toMillis(time) % 1000;

        return LocalTime.of(0, minutes, seconds, millis);
    }
}
