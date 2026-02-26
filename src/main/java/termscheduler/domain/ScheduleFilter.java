package termscheduler.domain;

import java.time.DayOfWeek;
import java.util.List;
import java.util.stream.Collectors;

public class ScheduleFilter {
    public static List<CourseSection> filterByDayAndCRNs(
            CourseSectionCollection collection,
            List<String> crns,
            DayOfWeek day) {
        return collection.getAllSections().stream()
                .filter(s -> crns.contains(s.getCrn()) && s.getDays().contains(day))
                .collect(Collectors.toList());
    }
}

