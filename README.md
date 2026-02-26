# Term Schedule Visualizer

A JavaFX-based application that visualizes academic term schedules and calculates optimal routes between campus buildings.

## Overview

This application helps students plan their class schedules by:
- Reading course data from Excel files
- Displaying campus maps with building locations
- Calculating walking times between buildings
- Visualizing schedules with day-based filtering
- Inputting custom course registration numbers (CRNs)

## Project Structure

```
src/main/java/edu/kfupm/swe316/termschedulevisualizer/
├── domain/          # Core business logic and domain models
│   ├── Building.java
│   ├── Course.java
│   ├── CourseSection.java
│   ├── CourseSectionCollection.java
│   ├── CampusMap.java
│   ├── RouteCalculator.java
│   └── ScheduleFilter.java
├── excel/           # Excel data processing
│   ├── ExcelScheduleReader.java
│   ├── ExcelRowMapper.java
│   └── ExcelValueParser.java
└── ui/              # User interface components
    ├── TermScheduleVisualizerApp.java
    ├── ResultsPane.java
    ├── MapView.java
    ├── MapCoordinatePicker.java
    ├── DaySelectorPane.java
    └── CrnInputPane.java
```

## Features

- **Schedule Planning**: Input multiple course CRNs to view combined schedule
- **Campus Navigation**: Interactive campus map showing building locations
- **Route Calculation**: Calculate walking distances and times between buildings
- **Day Filtering**: Filter and view schedule by specific days of the week
- **Data Processing**: Reads course schedules from Excel data files

## Technologies

- **Language**: Java 11+
- **UI Framework**: JavaFX
- **Data Processing**: Apache POI (Excel)
- **IDE**: Compatible with IntelliJ IDEA, Eclipse, VS Code

## Building and Running

### Prerequisites
- Java 11 or higher
- Maven 3.6+ or Gradle 6.0+

### Using Maven
```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="edu.kfupm.swe316.termschedulevisualizer.ui.TermScheduleVisualizerApp"
```

### Using Gradle
```bash
gradle clean build
gradle run
```

### From IDE
- Open project in your IDE
- Build the project
- Run `TermScheduleVisualizerApp.java` as a Java application

## Dependencies

- JavaFX SDK
- Apache POI (for Excel file reading)

## Documentation

- `docs/UML.drawio` - UML class diagram
- `docs/Spesefications.pdf` - Project specifications
- `docs/map.png` - Campus map visualization

## License

This project is provided as-is for educational purposes.

## Author

Ibrahim Alshayea

## Acknowledgments

- KFUPM Software Engineering Course (SWE 316)
