package com.petex.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.petex.entity.ReportEntity;

import jakarta.servlet.http.HttpServletResponse;

@Component
public class PdfGenerator {

    public void generate(HttpServletResponse response, List<ReportEntity> entities, File f)
            throws DocumentException, IOException {

        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
        PdfWriter.getInstance(document, new FileOutputStream(f));
        document.open();

        Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        fontTitle.setSize(20);

        Paragraph paragraph = new Paragraph("PETEX FUNDING", fontTitle);

        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(paragraph);

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] { 3.5f, 6.5f, 6.5f, 6.5f, 6.5f });
        table.setSpacingBefore(5);

        table.addCell("CUSTOMER ID");
        table.addCell("CUSTOMER NAME");
        table.addCell("EMAIL");
        table.addCell("MOBILE NUMBER");
        table.addCell("DONATION AMOUNT");

        for (ReportEntity entity : entities) {
            table.addCell(String.valueOf(entity.getCustomerId()));
            table.addCell(entity.getCustomerName());
            table.addCell(entity.getEmail());
            table.addCell(String.valueOf(entity.getMobileNumber()));
            table.addCell(String.valueOf(entity.getDonationAmount()));
        }

        document.add(table);
        document.close();
    }
}
