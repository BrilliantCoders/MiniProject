package com.helper;

import com.model.Question;
import com.model.Student;
import org.apache.poi.hssf.extractor.OldExcelExtractor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.swing.text.DateFormatter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ExcelFileHelper {

    public Sheet getExcelSheet(CommonsMultipartFile file) throws IOException {

        InputStream fis = file.getInputStream();
        Workbook wb=null;
        Sheet sheet=null;
        try {
            //creating workbook instance that refers to .xlsx file

            wb = new XSSFWorkbook(fis);
            //creating a Sheet object to retrieve the object
            sheet  = wb.getSheetAt(0);
        }

        catch (Exception e) {
            try {
                wb=new HSSFWorkbook(fis);
                //creating a Sheet object to retrieve the object
                sheet  = wb.getSheetAt(0);
            }
            catch (Exception ex){
                OldExcelExtractor wbo = new OldExcelExtractor(fis);
                System.out.println("here i am1 " +wbo.getText());
            }


        }

        //evaluating cell type
        FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();

        return sheet;

    }

    public String getCellValue(Cell cell){
        DataFormatter formatter=new DataFormatter();
        String val=formatter.formatCellValue(cell);;
        /*switch (cell.getCellType()){
            case STRING: val=cell.getStringCellValue();
                break;
            case NUMERIC: val=String.valueOf(cell.getNumericCellValue());
                break;
            case BOOLEAN: val=String.valueOf(cell.getBooleanCellValue());
                break;
            default:
            val=String.valueOf(cell.getDateCellValue());
                break;

        }
*/
        return val;
    }


    public ArrayList<String> getHeaderFromExcelSheet(Sheet sheet){

        ArrayList<String> headers = new ArrayList<String>();
        for (Row row : sheet)     //iteration over row using for each loop
        {

            int j=0;
            for (Cell cell : row)    //iteration over cell using for each loop
            {
                //if(cell.getCellTypeEnum()== CellType.STRING){
                switch (j) {
                    case 0:
                    case 1:
                        headers.add(cell.getStringCellValue()) ;
                        break;
                    default:
                        headers.add(String.valueOf(cell.getDateCellValue())) ;
                        break;
                }
                j++;
            }
            break;
        }

        return headers;
    }




    public ArrayList<Student> getArrayFromExcelSheet(Sheet sheet){

        int i = 0, j = 0;
        ArrayList<Student> students = new ArrayList<Student>();
        for (Row row : sheet)     //iteration over row using for each loop
        {

            Student ob = new Student();
            ArrayList<String> present = new ArrayList<String>();
            ArrayList<String> absent = new ArrayList<String>();
            j = 0;
            if (i != 0) {
                for (Cell cell : row)    //iteration over cell using for each loop
                {
                    //if(cell.getCellTypeEnum()== CellType.STRING){
                    switch (j) {
                        case 0:
                            ob.setRollNo((int) cell.getNumericCellValue());
                            break;
                        case 1:
                            ob.setName(cell.getStringCellValue());
                            break;
                        default:
                            if (cell.getStringCellValue().equalsIgnoreCase("P"))
                                present.add("P");
                            else
                                present.add("A");
                            break;
                    }
                    j++;
                }
                ob.setAbsent(absent);
                ob.setPresent(present);
                System.out.println(ob.getEmail());
                students.add(ob);
            }
            i++;
            System.out.println();
        }
        System.out.println("here "+students.size());
        return students;
    }


    public ArrayList<Student> getStudentListFromExcelSheet(Sheet sheet){

        int i = 0, j = 0;
        ArrayList<Student> students = new ArrayList<Student>();
        for (Row row : sheet)     //iteration over row using for each loop
        {

            Student ob = new Student();
            ArrayList<String> present = new ArrayList<String>();
            ArrayList<String> absent = new ArrayList<String>();
            j = 0;
            if (i != 0) {
                for (Cell cell : row)    //iteration over cell using for each loop
                {
                    //if(cell.getCellTypeEnum()== CellType.STRING){
                    switch (j) {
                        case 0:
                            ob.setRollNo((int) cell.getNumericCellValue());
                            break;
                        case 1:
                            ob.setRegNo(cell.getStringCellValue());
                            break;
                        case 2:
                            ob.setName(cell.getStringCellValue());
                            break;
                        case 3:
                            ob.setEmail(cell.getStringCellValue());
                            break;
                        case 4:
                            ob.setPassword(cell.getStringCellValue());
                            break;
                        default:
                            break;
                    }
                    j++;
                }
                students.add(ob);
            }
            i++;
            System.out.println();
        }

        return students;
    }





    public ArrayList<Question> getQuestionListFromExcelSheet(Sheet sheet){

        int i = 0, j = 0;
        ArrayList<Question> questions = new ArrayList<Question>();
        for (Row row : sheet)     //iteration over row using for each loop
        {

            Question ob = new Question();
            j=0;
            if (i != 0) {
                for (Cell cell : row)    //iteration over cell using for each loop
                {
                    //if(cell.getCellTypeEnum()== CellType.STRING){
                    switch (j) {
                        case 0:
                            //ob.setQuestion(cell.getStringCellValue());
                            break;
                        case 1:
                            ob.setQuestion(getCellValue(cell));
                            break;
                        case 2:
                            ob.setOption1(getCellValue(cell));
                            break;

                        case 3:
                            ob.setOption2(getCellValue(cell));
                            break;


                        case 4:
                            ob.setOption3(getCellValue(cell));
                            break;

                        case 5:
                            ob.setOption4(getCellValue(cell));
                            break;

                        case 6:
                            ob.setAnswer(Integer.parseInt(getCellValue(cell).trim()));
                            break;

                    }

                    j++;
                }
                questions.add(ob);
            }
            i++;

        }
        System.out.println(questions.size());
        return questions;
    }
















}
