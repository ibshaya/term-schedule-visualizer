package termscheduler.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExcelValueParser {

    public static String getCellValue(Cell cell) {
        if (cell == null) return "";
        return switch (cell.getCellType()) {
            case STRING -> cell.getStringCellValue().trim();
            case NUMERIC -> {
                double num = cell.getNumericCellValue();
                if (num == Math.floor(num)) {
                    // Whole number (e.g. CRN 12345.0 → "12345")
                    yield String.valueOf((long) num);
                } else {
                    // Fractional (e.g. time like 7.5 → "7.5")
                    yield String.valueOf(num);
                }
            }

            case FORMULA -> cell.getCachedFormulaResultType() == CellType.STRING
                    ? cell.getStringCellValue().trim()
                    : String.valueOf((int) cell.getNumericCellValue());
            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
            default -> "";
        };
    }

    public static List<DayOfWeek> parseDays(String dayStr) {
        List<DayOfWeek> days = new ArrayList<>();
        if (dayStr == null || dayStr.isBlank()) return days;

        for (char c : dayStr.trim().toUpperCase().toCharArray()) {
            switch (c) {
                case 'M' -> days.add(DayOfWeek.MONDAY);
                case 'T' -> days.add(DayOfWeek.TUESDAY);
                case 'W' -> days.add(DayOfWeek.WEDNESDAY);
                case 'U' -> days.add(DayOfWeek.THURSDAY); // KFUPM convention
                case 'F' -> days.add(DayOfWeek.FRIDAY);
                case 'S' -> days.add(DayOfWeek.SATURDAY);
                case 'A' -> days.add(DayOfWeek.SUNDAY);
            }
        }
        return days;
    }

    public static LocalTime parseTime(String timeStr) {
        if (timeStr == null || timeStr.isBlank()) return null;
        try {
            String padded = String.format("%04d", Integer.parseInt(timeStr));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmm");
            return LocalTime.parse(padded, formatter);
        } catch (Exception e) {
            return null;
        }
    }
}
