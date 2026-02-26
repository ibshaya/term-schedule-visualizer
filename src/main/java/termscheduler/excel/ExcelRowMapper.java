package termscheduler.excel;

import termscheduler.domain.CourseSection;
import org.apache.poi.ss.usermodel.Row;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

/**
 * ExcelRowMapper converts a single Excel row into a CourseSection object.
 */
public class ExcelRowMapper {

    private static final int TERM = 0;
    private static final int CRN = 1;
    private static final int COURSE = 2;
    private static final int DEPT = 3;
    private static final int SEC = 4;
    private static final int TITLE = 5;
    private static final int M_ACT = 6;
    private static final int DAYS1 = 7;
    private static final int START1 = 8;
    private static final int END1 = 9;
    private static final int BLDG = 10;
    private static final int ROOM = 11;
    private static final int INSTR = 12;

    /**
     * Maps a single Excel row to a CourseSection domain object.
     */
    public static CourseSection map(Row row) {
        if (row == null) return null;

        //Read cell values
        String term = ExcelValueParser.getCellValue(row.getCell(TERM));
        String crn = ExcelValueParser.getCellValue(row.getCell(CRN));
        String course = ExcelValueParser.getCellValue(row.getCell(COURSE));
        String dept = ExcelValueParser.getCellValue(row.getCell(DEPT));
        String sec = ExcelValueParser.getCellValue(row.getCell(SEC));
        String title = ExcelValueParser.getCellValue(row.getCell(TITLE));
        String kind = ExcelValueParser.getCellValue(row.getCell(M_ACT));
        String daysStr = ExcelValueParser.getCellValue(row.getCell(DAYS1));
        String startStr = ExcelValueParser.getCellValue(row.getCell(START1));
        String endStr = ExcelValueParser.getCellValue(row.getCell(END1));
        String bldg = ExcelValueParser.getCellValue(row.getCell(BLDG));
        String room = ExcelValueParser.getCellValue(row.getCell(ROOM));
        String instr = ExcelValueParser.getCellValue(row.getCell(INSTR));

        //Parse day/time values
        List<DayOfWeek> days = ExcelValueParser.parseDays(daysStr);
        LocalTime start = ExcelValueParser.parseTime(startStr);
        LocalTime end = ExcelValueParser.parseTime(endStr);

        return new CourseSection(
                course,
                title,
                dept,
                kind,
                crn,
                term,
                sec,
                instr,
                days,
                start,
                end,
                bldg,
                room
        );
    }

    private ExcelRowMapper() {}
}
