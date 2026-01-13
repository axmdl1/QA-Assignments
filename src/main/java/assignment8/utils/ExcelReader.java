package assignment8.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class ExcelReader {

    public static Map<String, String> getCredentials(String sheetName) {
        try (
                InputStream is = ExcelReader.class
                        .getClassLoader()
                        .getResourceAsStream("testData.xlsx")
        ) {
            if (is == null) {
                throw new RuntimeException("testData.xlsx not found in resources");
            }

            Workbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheet(sheetName);

            Row header = sheet.getRow(0);
            Row values = sheet.getRow(1);

            if (header == null || values == null) {
                throw new RuntimeException("Excel rows are empty");
            }

            DataFormatter formatter = new DataFormatter();
            Map<String, String> data = new HashMap<>();

            int lastCell = header.getLastCellNum(); // ВАЖНО

            for (int i = 0; i < lastCell; i++) {
                Cell headerCell = header.getCell(i);
                Cell valueCell = values.getCell(i);

                if (headerCell == null || valueCell == null) {
                    continue;
                }

                String key = formatter.formatCellValue(headerCell).trim();
                String value = formatter.formatCellValue(valueCell).trim();

                data.put(key, value);
            }

            return data;

        } catch (Exception e) {
            throw new RuntimeException("Failed to read Excel file", e);
        }
    }
}