package termscheduler.domain;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CourseSectionCollection {

    private final String term;
    private final List<CourseSection> sections;

    public CourseSectionCollection(String term) {
        this.term = term;
        this.sections = new ArrayList<>();
    }

    public String getTerm() {
        return term;
    }

    public void addSection(CourseSection section) {
        if (section != null) {
            sections.add(section);
        }
    }

    public void removeSection(CourseSection section) {
        sections.remove(section);
    }

    public List<CourseSection> getAllSections() {
        return new ArrayList<>(sections);
    }

    public int getTotalSections() {
        return sections.size();
    }

    /**
     * Filters by multiple CRNs (used for the CRN input field in the UI).
     */
    public List<CourseSection> findSectionsByCRNs(List<String> crns) {
        if (crns == null || crns.isEmpty()) return new ArrayList<>();
        return sections.stream()
                .filter(s -> crns.contains(s.getCrn()))
                .collect(Collectors.toList());
    }



    @Override
    public String toString() {
        return String.format("CourseSectionCollection{term=%s, totalSections=%d}", term, sections.size());
    }
}
