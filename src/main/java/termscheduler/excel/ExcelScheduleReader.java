package termscheduler.excel;

import termscheduler.domain.CourseSection;
import termscheduler.domain.CourseSectionCollection;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelScheduleReader {

    private static final int HEADER_ROW = 0;
    private static final int DATA_START_ROW = 1;

    public CourseSectionCollection read(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            if (sheet == null) {
                throw new IOException("No sheet found in Excel file.");
            }

            CourseSectionCollection collection = null;
            String term = null;

            for (int i = DATA_START_ROW; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue;

                CourseSection section = ExcelRowMapper.map(row);
                if (term == null) {
                    term = section.getTerm();
                    collection = new CourseSectionCollection(term);
                }

                collection.addSection(section);
            }

            return collection;

        } catch (IOException e) {
            System.err.println("Error reading Excel file: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
