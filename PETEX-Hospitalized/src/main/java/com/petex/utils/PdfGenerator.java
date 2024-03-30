package com.petex.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.petex.entity.HospitalizedEntity;

@Component
public class PdfGenerator {

	public void generate( HospitalizedEntity hospital, File f)
			throws DocumentException, IOException {

		Document document = new Document(PageSize.A4);
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(f));
		document.open();

		Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTitle.setSize(20);

		Paragraph paragraph = new Paragraph("Hospitalization Details", fontTitle);
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(paragraph);

		document.add(new Paragraph("Name: " + hospital.getCustomerName()));
		document.add(new Paragraph("Description: " + hospital.getDescription()));
		document.add(new Paragraph("Email: " + hospital.getCustomerEmail()));
		document.add(new Paragraph("Date: " + hospital.getDate()));
		document.add(new Paragraph("Time: " + hospital.getTime()));
		document.add(new Paragraph("Mobile: " + hospital.getCustomerPhno()));
		
		document.close();
		writer.close();

	}

}
