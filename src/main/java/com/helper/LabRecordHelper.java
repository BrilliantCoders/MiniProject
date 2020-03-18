package com.helper;

import com.model.LabMarks;
import com.model.Student;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.ArrayList;

public class LabRecordHelper {

    public ArrayList<LabMarks> getListFromFile(Sheet sheet){

        int i = 0, j = 0;
        ArrayList<LabMarks> marks = new ArrayList<LabMarks>();
        for (Row row : sheet)     //iteration over row using for each loop
        {

            LabMarks ob = new LabMarks();
            j = 0;
            ArrayList<Double> list=new ArrayList<Double>();

            if (i != 0) {
                for (Cell cell : row)
                {
                    switch (j){
                        case 0: ob.setRollNo((int) cell.getNumericCellValue());
                                break;
                        case 1: ob.setName( getCellValue(cell));
                            break;
                        default:
                                list.add(cell.getNumericCellValue());

                    }
                    j++;
                }

                ob.setExecutionMarks(list);
                marks.add(ob);
            }
            i++;
        }
        return marks;
    }

    public String getCellValue(Cell cell){
        DataFormatter formatter=new DataFormatter();
        String val=formatter.formatCellValue(cell);;
        return val;
    }

}
