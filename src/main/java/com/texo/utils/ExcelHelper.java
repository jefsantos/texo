package com.texo.utils;



import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.texo.model.Movies;

public class ExcelHelper {

  public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
  static String[] HEADERs = { "Id", "Title", "Description", "Published" };
  static String SHEET = "movielist";
  public static boolean hasExcelFormat(MultipartFile file) {
    if (!TYPE.equals(file.getContentType())) {
      return false;
    }
    return true;
  }
  public static List<Movies> excelToMovies(InputStream is) {
    try {
    	Workbook workbook = WorkbookFactory.create(is);
//      Workbook workbook = new XSSFWorkbook(is);
      Sheet sheet = workbook.getSheet(SHEET);
      Iterator<Row> rows = sheet.iterator();
      List<Movies> movies = new ArrayList<Movies>();
      int rowNumber = 0;
      while (rows.hasNext()) {
        Row currentRow = rows.next();
        // skip header
        if (rowNumber == 0) {
          rowNumber++;
          continue;
        }
        Iterator<Cell> cellsInRow = currentRow.iterator();
        Movies movie = new Movies();
        int cellIdx = 0;
        while (cellsInRow.hasNext()) {
          Cell currentCell = cellsInRow.next();
          switch (cellIdx) {
          case 0:
        	  movie.setId((long) currentCell.getNumericCellValue());
            break;
          case 1:
        	  movie.setTitle(currentCell.getStringCellValue());
            break;
          case 2:
        	  movie.setStudios(currentCell.getStringCellValue()); 
            break;
            
          case 3:
        	  movie.setProducers(currentCell.getStringCellValue());
            break;
          case 4:
        	  movie.setWinner(currentCell.getBooleanCellValue());
            break;
          default:
            break;
          }
          cellIdx++;
        }
        movies.add(movie);
      }
      workbook.close();
      return movies;
    } catch (IOException e) {
      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
    }
  }
}
