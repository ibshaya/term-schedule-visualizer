package termscheduler.domain;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

public class    CourseSection extends Course {

    private final String crn;
    private final String term;
    private final String section;
    private final String instructor;
    private final List<DayOfWeek> days;
    private final LocalTime startTime;
    private final LocalTime endTime;
    private final String building;
    private final String room;

    public CourseSection(String code, String title, String dept, String kind,
                         String crn, String term, String section, String instructor,
                         List<DayOfWeek> days, LocalTime startTime, LocalTime endTime,
                         String building, String room) {
        super(code, title, dept, kind);
        this.crn = crn;
        this.term = term;
        this.section = section;
        this.instructor = instructor;
        this.days = days;
        this.startTime = startTime;
        this.endTime = endTime;
        this.building = building;
        this.room = room;
    }

    public String getCrn() {
        return crn;
    }

    public String getTerm() {
        return term;
    }

    public String getSection() {
        return section;
    }

    public String getInstructor() {
        return instructor;
    }

    public List<DayOfWeek> getDays() {
        return days;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public String getBuilding() {
        return building;
    }

    public String getRoom() {
        return room;
    }

    public String displayName() {
        return getCode() + "-" + section + " (" + getTitle() + ")";
    }

    @Override
    public String toString() {
        return String.format(
                "%s [%s] (%s) | %s %s-%s | %s %s | %s",
                getCode(), section, getKind(),
                days, startTime, endTime,
                building, room, instructor
        );
    }
}
