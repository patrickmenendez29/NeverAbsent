
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;


class PDF {
    public static void main(String table) throws IOException {

        String filename = "sample.pdf";
        String message = "Absence Report.";


        PDDocument doc = new PDDocument();
        try {
            PDPage page = new PDPage();
            doc.addPage(page);

            // PDImageXObject pdImage = PDImageXObject.createFromFile("test.jpg", doc);

            PDFont font = PDType1Font.HELVETICA_BOLD;

            PDPageContentStream contents = new PDPageContentStream(doc, page);
            contents.beginText();
            contents.setFont(font, 18);
            contents.newLineAtOffset(10, 700);
            contents.showText(message);
            contents.endText();

            contents.beginText();
            contents.setFont(font, 12);
            contents.newLineAtOffset(10, 500);
            contents.showText(table);
            contents.endText();
            // contents.drawImage(pdImage, 350, 600);
            contents.close();

            doc.save(filename);
        }
        finally {
            doc.close();
        }

    }
}

