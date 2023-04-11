package com.example.kompracasesexcelservice.utils;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

@Component
public class FileFactory {
    public static final String PATH_TEMPLATE = "D:\\Programs\\github";
    public static File createFile(String filename, Workbook workbook) throws Exception {
        workbook = new XSSFWorkbook();

        OutputStream out = new FileOutputStream(PATH_TEMPLATE + filename);

        workbook.write(out);

        return ResourceUtils.getFile(PATH_TEMPLATE + filename);
    }
}
