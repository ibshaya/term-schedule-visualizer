# Term Schedule Visualizer

A JavaFX-based desktop application for visualizing academic term schedules and calculating routing between campus buildings.

## Overview

This application helps students:
- View course schedules from Excel data files
- Visualize campus maps and building locations
- Filter schedules by day of the week
- Input course registration numbers (CRNs)
- Calculate walking distances between buildings

## Quick Start

1. **Prerequisites**: Java 11+ and JavaFX SDK
2. **Compile**: `mvn compile` or compile using your IDE
3. **Run**: `mvn exec:java -Dexec.mainClass="termscheduler.ui.TermScheduleVisualizerApp"`
4. **Input**: Enter CRN numbers in the input field
5. **View**: See your schedule and navigate campus map

## Project Structure

```
src/main/java/termscheduler/
├── domain/              # Business logic & data models
│   ├── Building.java
│   ├── Course.java
│   ├── CourseSection.java
│   ├── CourseSectionCollection.java
│   ├── CampusMap.java
│   ├── RouteCalculator.java
│   └── ScheduleFilter.java
├── excel/               # Excel file processing
│   ├── ExcelScheduleReader.java
│   ├── ExcelRowMapper.java
│   └── ExcelValueParser.java
└── ui/                  # User interface (JavaFX)
    ├── TermScheduleVisualizerApp.java
    ├── CrnInputPane.java
    ├── DaySelectorPane.java
    ├── MapView.java
    ├── MapCoordinatePicker.java
    └── ResultsPane.java

docs/
├── UML.drawio
├── Spesefications.pdf
├── TSV Report.pdf
└── Term Schedule 251.xlsx
```

## Features

- **Schedule Input**: Enter multiple CRNs to view combined schedule
- **Campus Map**: Interactive visualization of building locations
- **Route Planning**: Calculate distances between buildings
- **Day Filtering**: View schedule by specific day
- **Excel Integration**: Import student course schedules

## Technologies

- **Language**: Java 11+
- **UI Framework**: JavaFX
- **Data Processing**: Apache POI

## Building

```bash
# Maven
mvn clean compile

# Run from IDE
- Open TermScheduleVisualizerApp.java
- Click Run
```

## Dependencies

- JavaFX SDK
- Apache POI

## Documentation

See `docs/` folder for diagrams and specifications.

## Author

Ibrahim Alshayea 



# Updated
<!-- version bump -->


<!-- docs update -->
