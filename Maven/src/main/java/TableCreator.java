import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.vandeseer.easytable.TableDrawer;
import org.vandeseer.easytable.settings.HorizontalAlignment;
import org.vandeseer.easytable.structure.Row;
import org.vandeseer.easytable.structure.Table;
import org.vandeseer.easytable.structure.cell.TextCell;

import java.awt.*;
import java.io.IOException;

import static java.awt.Color.BLACK;

public class TableCreator {

   public void create(){
       try (PDDocument document = new PDDocument()) {
           final PDPage page = new PDPage(PDRectangle.A4);
           document.addPage(page);

           try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {

               // Build the table
               Table myTable = Table.builder()
                       .addColumnsOfWidth(100, 100)
                       .addRow(Row.builder()
                               .add(TextCell.builder().text("Class").borderWidth(1).backgroundColor(Color.GRAY).build())
                               .add(TextCell.builder().text("Absences").borderWidth(1).backgroundColor(Color.LIGHT_GRAY).build())
                               .build())
                       .addRow(Row.builder()
                               .add(TextCell.builder().text("Two One").borderWidth(1).textColor(BLACK).build())
                               .add(TextCell.builder().text("Two Two").borderWidth(1).horizontalAlignment(HorizontalAlignment.RIGHT).build())
                               .build())
                       .build();

               // Set up the drawer
               TableDrawer tableDrawer = TableDrawer.builder()
                       .contentStream(contentStream)
                       .startX(100f)
                       .startY(page.getMediaBox().getUpperRightY() - 20f)
                       .table(myTable)
                       .build();

               // And go for it!
               tableDrawer.draw();
           }

           document.save("example.pdf");
       } catch (IOException e) {
           e.printStackTrace();
       }

   }

   void addRow(Table table,String Xtext, String Ytext){

   }

    // Build the table
    // Set up the drawer
    // And go for it!
}
