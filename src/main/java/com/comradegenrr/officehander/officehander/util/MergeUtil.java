package com.comradegenrr.officehander.officehander.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.spire.xls.CellRange;
import com.spire.xls.Workbook;
import com.spire.xls.Worksheet;

@Component
public class MergeUtil {
    
    public InputStream mergeTwo(List<MultipartFile> multipartFileList, String clm) throws IOException{
        if(multipartFileList.size()!=2){
            return null;
        }

        Workbook workBook1 = new Workbook();
        workBook1.loadFromStream(multipartFileList.get(0).getInputStream());

        Workbook workBook2 = new Workbook();
        workBook2.loadFromStream(multipartFileList.get(1).getInputStream());;

        Worksheet workSheet1 = workBook1.getWorksheets().get(0);
        Worksheet workSheet2 = workBook2.getWorksheets().get(0);

        Workbook resultWorkbook = new Workbook();
        Worksheet resultWorkSheet = resultWorkbook.getWorksheets().get(0);

        CellRange[] cellRanges1 =  workSheet1.getRows();
        CellRange[] cellRanges2 =  workSheet2.getRows();
        int resultRowCount = 1;
        for(CellRange c1:cellRanges1){
            for(CellRange c2:cellRanges2){
                if(c1.isBlank()){
                    continue;
                }
                if(c1.getColumns()[Integer.valueOf(clm)-1].getValue().equals(c2.getColumns()[Integer.valueOf(clm)-1].getValue())){
                    resultWorkSheet.insertRow(resultRowCount, c1.getColumnCount());
                    for(int i=0;i<c1.getColumnCount();i++){
                        resultWorkSheet.setValue(resultRowCount, i+1, c1.getColumns()[i].getValue());
                    }
                    resultRowCount++;
                }
            }
        }
        UUID uuid = UUID.randomUUID();
        resultWorkbook.saveToFile(uuid+"temp.xlsx");
        File returnFile = new File(uuid+"temp.xlsx");
        
        return new FileInputStream(returnFile);

    }

}
