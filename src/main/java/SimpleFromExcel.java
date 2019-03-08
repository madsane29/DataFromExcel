
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;




public class SimpleFromExcel {

      public static ArrayList<Transaction> readData() {
          ArrayList<Transaction> transactions = new ArrayList<>();
          try {
              
              String type, where;
              Date date;
              int amount, balance;
              DataFormatter dataFormatter = new DataFormatter();
              Workbook workbook = WorkbookFactory.create(new File("export2.xls"));
              Sheet sheet = workbook.getSheetAt(0);

              int firstRow = 15;
              int lastRow = sheet.getLastRowNum();

              Cell cell;
              for (int i = 15; i <= lastRow; i++) {
                  Row row = sheet.getRow(i);
                  
                  cell = row.getCell(1);
                  type = dataFormatter.formatCellValue(cell);

                  String tmp;
                  cell = row.getCell(2);
                  tmp = dataFormatter.formatCellValue(cell);
                  SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
                  date = formatter.parse(tmp);

                  cell = row.getCell(4);
                  String hasToFormatIt = dataFormatter.formatCellValue(cell);
                  amount = formatIt(hasToFormatIt);

                  cell = row.getCell(5);
                  hasToFormatIt = dataFormatter.formatCellValue(cell);
                  balance = formatIt(hasToFormatIt);

                  cell = row.getCell(8);
                  where = dataFormatter.formatCellValue(cell);

                  Transaction tmp2 = new Transaction(type, date, amount, balance, where);
                  transactions.add(tmp2);
                  
              }

          } catch (IOException ex) {
              System.out.println("IOException in readData(): " + ex);
          } catch (InvalidFormatException ex) {
              System.out.println("InvalidFormatException in readData(): " + ex);
          } catch (ParseException ex) {
              System.out.println("ParseException in readData(): " + ex);
          }
        
          return transactions;
      }
    
    public static void main(String[] args) throws InvalidFormatException, IOException, ParseException {
        ArrayList<Transaction> transactions = readData();
        writeOut(transactions);
        
    }
    
    public static int formatIt(String input) {
        input = input.substring(0, input.length()-3);
        input = input.replaceAll(",","");
         
        return Integer.parseInt(input);
    }
    
    public static void writeOut(ArrayList<Transaction> transactions) {
        for (Transaction i : transactions) {
            System.out.format("%32s%16s%16s%16s%16s", i.getType(), i.getDate(), i.getAmount(), i.getBalance(), i.getWhere());
            System.out.println();
        }
    }

}
