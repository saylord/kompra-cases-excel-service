package com.example.kompracasesexcelservice.utils;

import com.example.kompracasesexcelservice.dto.LitigationCaseDTO;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

@Component
public class ExcelUtils {

    public static ByteArrayInputStream exportLitigation(List<LitigationCaseDTO> litigations, String fileName) throws Exception {
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();

        File file;

        FileInputStream fileInputStream;

        file = FileFactory.createFile(fileName, xssfWorkbook);
        fileInputStream = new FileInputStream(file);

        // create freeze pane in excel file
        XSSFSheet newSheet = xssfWorkbook.createSheet("судебные разбирательства");

//        newSheet.createFreezePane(0,2); // 0,2,0,2

        // create font for title
        XSSFFont titleFont = xssfWorkbook.createFont();
        titleFont.setFontName("Arial");
        titleFont.setBold(true);
        titleFont.setFontHeightInPoints((short) 12);

        // create style for cell of title and apply font to cell
        XSSFCellStyle titleCellStyle = xssfWorkbook.createCellStyle();
        titleCellStyle.setAlignment(HorizontalAlignment.CENTER);
        titleCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        titleCellStyle.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.index);
        titleCellStyle.setBorderBottom(BorderStyle.MEDIUM);
        titleCellStyle.setBorderLeft(BorderStyle.MEDIUM);
        titleCellStyle.setBorderRight(BorderStyle.MEDIUM);
        titleCellStyle.setBorderTop(BorderStyle.MEDIUM);
        titleCellStyle.setFont(titleFont);
        titleCellStyle.setWrapText(true);

        // create font for data
        XSSFFont dataFont = xssfWorkbook.createFont();
        dataFont.setFontName("Arial");
        dataFont.setBold(false);
        dataFont.setFontHeightInPoints((short) 10);

        // create style for cell data and apply font data to cell
        XSSFCellStyle dataCellStyle = xssfWorkbook.createCellStyle();
        dataCellStyle.setAlignment(HorizontalAlignment.LEFT);
        dataCellStyle.setBorderBottom(BorderStyle.THIN);
        dataCellStyle.setBorderLeft(BorderStyle.THIN);
        dataCellStyle.setBorderRight(BorderStyle.THIN);
        dataCellStyle.setBorderTop(BorderStyle.THIN);
        dataCellStyle.setFont(dataFont);
        dataCellStyle.setWrapText(true);

        // insert fieldName as title to excel
        insertFieldNameAsTitleToWorkbook(ExportConfig.litigationExport.getCellExportConfigList(), newSheet, titleCellStyle);

        // insert data of fieldName to excel
        insertDataToWorkbook(xssfWorkbook, ExportConfig.litigationExport, litigations, dataCellStyle);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        xssfWorkbook.write(outputStream);
        outputStream.close();
        fileInputStream.close();

        return new ByteArrayInputStream(outputStream.toByteArray());
    }

    private static void insertDataToWorkbook(Workbook workbook, ExportConfig exportConfig, List<LitigationCaseDTO> datas, XSSFCellStyle dataCellStyle) {
        int startRowIndex = exportConfig.getStartRow();
        int sheetIndex = exportConfig.getSheetIndex();
        Class clazz = exportConfig.getDataClass();
        List<CellConfig> cellConfigs = exportConfig.getCellExportConfigList();

        Sheet sheet = workbook.getSheetAt(sheetIndex);
        int currentRowIndex = startRowIndex;

        for (LitigationCaseDTO data : datas) {
            Row currentRow = sheet.getRow(currentRowIndex);
            if (ObjectUtils.isEmpty(currentRow)) {
                currentRow = sheet.createRow(currentRowIndex);
            }

            // insert data to row
            insertDataToCell(data, currentRow, cellConfigs, clazz, sheet, dataCellStyle);
            currentRowIndex++;
        }
    }

    private static void insertFieldNameAsTitleToWorkbook(List<CellConfig> cellConfigs, Sheet sheet, XSSFCellStyle titleCellStyle) {
        // title -> first row of excel -> get top row
        int currentRow = sheet.getTopRow();

        // create row
        Row row = sheet.createRow(currentRow);

        // resize fix text to each cell
        int i = 0;
        sheet.autoSizeColumn(currentRow);

        // insert field name to cell
        for (CellConfig cellConfig : cellConfigs) {
            Cell currentCell = row.createCell(i);
            String fieldName = cellConfig.getFieldName();
            currentCell.setCellValue(fieldName);
            currentCell.setCellStyle(titleCellStyle);
            sheet.autoSizeColumn(i);
            i++;
        }
    }

    private static void insertDataToCell(LitigationCaseDTO data, Row currentRow, List<CellConfig> cellConfigs, Class clazz, Sheet sheet, XSSFCellStyle dataStyle) {
        for (CellConfig cellConfig : cellConfigs) {
            Cell currentCell = currentRow.getCell(cellConfig.getColumnIndex());
            if (ObjectUtils.isEmpty(currentCell)) {
                currentCell = currentRow.createCell(cellConfig.getColumnIndex());
            }

            // get data for cell
            String cellValue = "";
            switch (cellConfig.getColumnIndex()) {
                case 0:
                    cellValue = data.getType().getName();
                    break;
                case 1:
                    cellValue = data.getNumber();
                    cellValue += " ";
                    if (data.getDate() != null) {
                        java.sql.Date date = new java.sql.Date(data.getDate());
                        cellValue += date;
                    } else {
                        cellValue += "-";
                    }
                    break;
                case 2:
                    cellValue = data.getPart();
                    break;
                case 3:
                    cellValue = data.getOrgan();
                    break;
                case 4:
                    cellValue = data.getCategory();
                    break;
                case 5:
                    cellValue = data.getResult();
                    break;
                default:
                    cellValue = "";
            }

            // set data
            currentCell.setCellValue(cellValue);
            sheet.autoSizeColumn(cellConfig.getColumnIndex());
            currentCell.setCellStyle(dataStyle);

        }
    }
}
