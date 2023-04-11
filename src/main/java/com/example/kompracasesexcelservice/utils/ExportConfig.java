package com.example.kompracasesexcelservice.utils;

import com.example.kompracasesexcelservice.dto.LitigationDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExportConfig {
    private int sheetIndex;
    private int startRow;
    private Class dataClass;
    private List<CellConfig> cellExportConfigList;
    public static final ExportConfig litigationExport;
    static {
        litigationExport = new ExportConfig();
        litigationExport.setSheetIndex(0);
        litigationExport.setStartRow(1);
        litigationExport.setDataClass(LitigationDTO.class);
        List<CellConfig> litigationCellConfig = new ArrayList<>();
        litigationCellConfig.add(new CellConfig(0, "Тип"));
        litigationCellConfig.add(new CellConfig(1, "Номер и дата"));
        litigationCellConfig.add(new CellConfig(2, "Истец"));
        litigationCellConfig.add(new CellConfig(3, "Судебный орган"));
        litigationCellConfig.add(new CellConfig(4, "Категория дела"));
        litigationCellConfig.add(new CellConfig(5, "Результат рассмотрения"));

        litigationExport.setCellExportConfigList(litigationCellConfig);
    }
}