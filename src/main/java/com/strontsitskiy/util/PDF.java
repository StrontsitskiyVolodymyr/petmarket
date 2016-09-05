package com.strontsitskiy.util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PDF {
    String path = "C:/Users/i/Desktop/ВебМаг/Shop/src/main/webapp/";

    public void create(String address, String dateDilivery, int price, String name,String pet) {
        Document document = new Document();
        Rectangle rectangle = new Rectangle(600, 200);
        document.setPageSize(rectangle);
        Font[] fonts = {
                new Font(Font.FontFamily.COURIER, 18, Font.BOLD)
        };
        try {
            PdfWriter.getInstance(document, new FileOutputStream(path + "orders/order" + pet + ".pdf"));
            document.open();
            Image image = Image.getInstance(path + "img/logo.png");
            document.add(image);
            Paragraph paragraph = new Paragraph();
            Paragraph paragraph2 = new Paragraph();
            Paragraph paragraph3 = new Paragraph();
            paragraph.setFont(fonts[0]);
            paragraph3.setFont(fonts[0]);
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd:MM:yyyy");
            paragraph.add("Price: " + price + "$ to " + name + " time " + simpleDateFormat.format(date));
            paragraph2.add("Delivery in " + address + "  " + dateDilivery);
            paragraph3.add("Thanks for yoy order:)");
            document.add(paragraph);
            document.add(paragraph2);
            document.add(paragraph3);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}
