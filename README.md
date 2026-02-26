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
src/main/java/termscheduler/
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

docs/               # Documentation and resources
├── UML.drawio       # System architecture diagram
├── Spesefications.pdf
├── HW # 1.pdf
├── HW1-202176470-IBRAHIM ALSHAYEA.pdf
└── Term Schedule 251.xlsx
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
- **Build Tool**: Maven / Gradle
- **IDE**: Compatible with IntelliJ IDEA, Eclipse, VS Code

## Building and Running

### Prerequisites
- Java 11 or higher
- Maven 3.6+ or Gradle 6.0+

### Using Maven
```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="termscheduler.ui.TermScheduleVisualizerApp"
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

## Package Overview

### Domain (`termscheduler.domain`)
Core business entities and logic:
- **Building**: Represents campus buildings with coordinates
- **Course**: Course information and details
- **CourseSection**: Specific section of a course with schedule
- **CourseSectionCollection**: Collection management for course sections
- **CampusMap**: Campus map data and management
- **RouteCalculator**: Distance/route calculations between buildings
- **ScheduleFilter**: Schedule filtering and processing

### Excel (`termscheduler.excel`)
Data import from Excel files:
- **ExcelScheduleReader**: Reads schedule data from Excel
- **ExcelRowMapper**: Maps Excel rows to domain objects
- **ExcelValueParser**: Parses Excel cell values

### UI (`termscheduler.ui`)
JavaFX user interface components:
- **TermScheduleVisualizerApp**: Main application entry point
- **ResultsPane**: Results display panel
- **MapView**: Campus map visualization
- **MapCoordinatePicker**: Building coordinate selection
- **DaySelectorPane**: Day filtering component
- **CrnInputPane**: CRN input form

## Dependencies

- JavaFX SDK (for UI)
- Apache POI (for Excel file reading)

### Maven Dependencies Example
```xml
<dependency>
    <groupId>org.openjfx</groupId>
    <artifactId>javafx-controls</artifactId>
    <version>21</version>
</dependency>
<dependency>
    <groupId>org.apache.poi</groupId>
    <artifactId>poi</artifactId>
    <version>5.2.0</version>
</dependency>
```

## Documentation

- `docs/UML.drawio` - UML class diagram and system architecture
- `docs/Spesefications.pdf` - Project specifications
- `docs/map.png` - Campus map visualization reference
- `docs/Term Schedule 251.xlsx` - Sample schedule data

## License

This project is provided as-is for educational purposes.

## Author

Ibrahim Alshayea (ibshaya)

## Acknowledgments

- KFUPM Software Engineering Course (SWE 316)
