package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFDataExporter implements DataExporterStrategy {

	@Override
	public void exportProject(Project project, String url) {
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
				for (Diagram diagram : project.getDiagrams()) {
					document.add(new Paragraph(diagram.toString()));
				}
				document.close();

				JOptionPane.showMessageDialog(null, "PDF saved successfully:\n" + filePath);
			} catch (FileNotFoundException | DocumentException e) {
				JOptionPane.showMessageDialog(null, "Error saving PDF: " + e.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	@Override
	public void exportDiagram(Diagram diagram, String url) {
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
				document.add(new Paragraph(diagram.toString()));
				document.close();

				JOptionPane.showMessageDialog(null, "PDF saved successfully:\n" + filePath);
			} catch (FileNotFoundException | DocumentException e) {
				JOptionPane.showMessageDialog(null, "Error saving PDF: " + e.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
