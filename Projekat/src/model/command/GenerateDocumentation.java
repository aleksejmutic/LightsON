package model.command;

import java.io.File;
import java.io.FileOutputStream;

import javax.swing.JFileChooser;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import model.Diagram;

public class GenerateDocumentation {
	public static void saveTextAsPDF(Diagram diagram) {
		// FileChooser
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Save PDF");
		fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("PDF Files", "pdf"));

		int userSelection = fileChooser.showSaveDialog(null);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File fileToSave = fileChooser.getSelectedFile();

			// Postavka pdf ekstenzije
			String filePath = fileToSave.getAbsolutePath();
			if (!filePath.toLowerCase().endsWith(".pdf")) {
				filePath += ".pdf";
			}

			Document document = new Document();
			try {
	            PdfWriter.getInstance(document, new FileOutputStream(filePath));
	            document.open();

	            // Font for the name
	            Font nameFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);

	            // Adding diagram name to the top center
	            Paragraph nameParagraph = new Paragraph(diagram.getDiagramName(), nameFont);
	            nameParagraph.setAlignment(Element.ALIGN_CENTER);
	            document.add(nameParagraph);

	            document.add(new Paragraph("\n")); // Adding space

	            // Adding element type and count
	            String documentationText = diagram.generateDocumentation(); // Use previous method
	            Font textFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
	            Paragraph textParagraph = new Paragraph(documentationText, textFont);
	            textParagraph.setAlignment(Element.ALIGN_JUSTIFIED);
	            document.add(textParagraph);

	            document.close();
	            System.out.println("PDF generated successfully at: " + filePath);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		}
	}
}
