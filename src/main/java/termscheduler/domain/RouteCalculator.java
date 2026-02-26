package termscheduler.domain;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class RouteCalculator {

    /**
     * Calculates the total travel distance between all buildings
     * visited in order of class start time.
     */
    public static double calculateTotalDistance(List<CourseSection> sections, CampusMap campusMap) {
        if (sections == null || sections.size() < 2) return 0;

        List<CourseSection> sorted = new ArrayList<>(sections);
        sorted.sort(Comparator.comparing(CourseSection::getStartTime,
                Comparator.nullsLast(LocalTime::compareTo)));

        double totalDistance = 0.0;
        Building previous = null;

        for (CourseSection section : sorted) {
            Building current = campusMap.getBuildingByCode(section.getBuilding());
            if (current == null) {
                System.err.println("Skipping unknown building: " + section.getBuilding());
                continue;
            }

            if (previous != null && !previous.getCode().equals(current.getCode())) {
                totalDistance += previous.distanceTo(current);
            }

            previous = current;
        }

        return totalDistance;
    }

    /**
     * Returns the ordered list of unique buildings visited by the student in a day.
     */
    public static List<Building> getRoutePath(List<CourseSection> sections, CampusMap campusMap) {
        List<Building> path = new ArrayList<>();
        if (sections == null || sections.isEmpty()) return path;

        List<CourseSection> sorted = new ArrayList<>(sections);
        sorted.sort(Comparator.comparing(CourseSection::getStartTime,
                Comparator.nullsLast(LocalTime::compareTo)));

        Building lastAdded = null;
        for (CourseSection section : sorted) {
            Building b = campusMap.getBuildingByCode(section.getBuilding());
            if (b != null && (lastAdded == null || !lastAdded.getCode().equals(b.getCode()))) {
                path.add(b);
                lastAdded = b;
            }
        }

        return path;
    }


    public static String getRouteSummary(List<CourseSection> sections, CampusMap campusMap) {
        if (sections == null || sections.isEmpty()) {
            return "No classes scheduled for this day.";
        }

        double totalDistance = calculateTotalDistance(sections, campusMap);
        List<Building> path = getRoutePath(sections, campusMap);

        StringBuilder sb = new StringBuilder();
        sb.append("Selected Day Route:\n");
        sb.append("Number of Courses: ").append(sections.size()).append("\n");
        sb.append("Unique Buildings Visited: ").append(path.size()).append("\n\n");
        sb.append("Path: ");

        for (int i = 0; i < path.size(); i++) {
            sb.append(path.get(i).getCode());
            if (i < path.size() - 1) sb.append(" → ");
        }

        sb.append("\n\nTotal Distance: ")
                .append(String.format("%.2f units", totalDistance));

        return sb.toString();
    }
}
