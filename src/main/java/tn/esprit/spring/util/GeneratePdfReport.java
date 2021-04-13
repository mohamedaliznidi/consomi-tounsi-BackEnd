package tn.esprit.spring.util;
import com.itextpdf.text.BaseColor;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import tn.esprit.spring.entities.ItemBasket;
import tn.esprit.spring.entities.OrderC;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import java.util.List;


public class GeneratePdfReport {

	private static final Logger logger = LoggerFactory.getLogger(GeneratePdfReport.class);
	

    public static ByteArrayInputStream ordersReport(OrderC orderC,List<ItemBasket> items) {

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        
       // ItemBasketServiceImpl is = new ItemBasketServiceImpl();

        try {
        	PdfWriter.getInstance(document, out);
            document.open();
            
            
            com.itextpdf.text.Font charika = FontFactory.getFont(FontFactory.COURIER_BOLD, 20 , BaseColor.RED); // couleur de paragraphe
			Paragraph param = new Paragraph("Consomi Tounsi", charika);
			param.setAlignment(Element.ALIGN_CENTER);  // paragraphe centré
			document.add(param);
			document.add(Chunk.NEWLINE); // traja3 lestar
			
        	com.itextpdf.text.Font font = FontFactory.getFont(FontFactory.COURIER, 14 , BaseColor.BLACK); // couleur de paragraphe
			Paragraph para = new Paragraph("Bill of Products", font);
			para.setAlignment(Element.ALIGN_CENTER);  // paragraphe centré
			document.add(para);
			document.add(Chunk.NEWLINE); // traja3 lestar
			
			
			com.itextpdf.text.Font fontt = FontFactory.getFont(FontFactory.COURIER, 12 , BaseColor.BLACK); // couleur de paragraphe
			Paragraph parama = new Paragraph(orderC.getShippingAdress()+"", fontt);
			parama.setAlignment(Element.ALIGN_LEFT);  // paragraphe centré
			document.add(parama);
			document.add(Chunk.NEWLINE); // traja3 lestar
			
			
            PdfPTable table = new PdfPTable(5); //nombre de colonne 
            table.setWidthPercentage(90); // taille du tableau par rapport du page en pourcentage
            table.setWidths(new int[]{3,1, 1, 2, 2}); // kol case 9adech bech tekel

            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD , 10);

            PdfPCell hcell;
            hcell = new PdfPCell(new Phrase("Name of product", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Price unitary", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Quantity", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Tax price", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Total price", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            System.out.println("IM HERE YEEEEEY");
            System.out.println(orderC);
            System.out.println("Getting items");
            //List<ItemBasket> items; 
            System.out.println("list :"+items);
            System.out.println("listing items :");
            System.out.println(items);
            System.out.println("listed");
            for (ItemBasket item : items) {

                PdfPCell cell;

                cell = new PdfPCell(new Phrase(item.getProduct().getName()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(item.getProduct().getPrice()+"DT"));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cell.setPaddingRight(5);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(item.getQuantity()+""));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(orderC.getTaxPrice()+"%"));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(item.getProduct().getPrice()*item.getQuantity()+(item.getProduct().getPrice()*item.getQuantity())*(orderC.getTaxPrice())/(100)+"DT"));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cell.setPaddingRight(5);
                table.addCell(cell);
            }
            
            hcell = new PdfPCell(new Phrase("", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Total to pay", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase(orderC.getTotalPrice()+"DT", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            document.add(table);
            document.add(Chunk.NEWLINE);
            
            com.itextpdf.text.Font ktiba = FontFactory.getFont(FontFactory.HELVETICA, 12 , BaseColor.BLUE); // couleur de paragraphe
			Paragraph paramee = new Paragraph("Other informations:", ktiba);
			paramee.setAlignment(Element.ALIGN_LEFT);  // paragraphe centré
			document.add(paramee);
			document.add(Chunk.NEWLINE); // traja3 lestar
            
            
            
            
            
            
            PdfPTable table2 = new PdfPTable(4); //nombre de colonne 
            table2.setWidthPercentage(90); // taille du tableau par rapport du page en pourcentage
            table2.setWidths(new int[]{1, 3, 2, 3}); // kol case 9adech bech tekel

            Font headFont2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD , 10);

            PdfPCell hcell2;
            hcell2 = new PdfPCell(new Phrase("Is paid", headFont2));
            hcell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            table2.addCell(hcell2);
            
            hcell2 = new PdfPCell(new Phrase("Paid at", headFont2));
            hcell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            table2.addCell(hcell2);

            hcell2 = new PdfPCell(new Phrase("Is delivered", headFont2));
            hcell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            table2.addCell(hcell2);
            
            hcell = new PdfPCell(new Phrase("Delivered at", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table2.addCell(hcell);
           

                PdfPCell cell2;
                if (orderC.isPaid()) cell2 = new PdfPCell(new Phrase("Paid"));
                else cell2 = new PdfPCell(new Phrase("Not Paid"));
                cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
                table2.addCell(cell2);
               
               cell2 = new PdfPCell(new Phrase(orderC.getPaidAt()+""));
                cell2.setPaddingLeft(5);
                cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
                table2.addCell(cell2);
                
               if (orderC.isDelivered()) cell2 = new PdfPCell(new Phrase("Delivered"));
               else cell2 = new PdfPCell(new Phrase("Not Delevered"));
                cell2.setPaddingLeft(5);
                cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
                table2.addCell(cell2);

                cell2 = new PdfPCell(new Phrase(orderC.getDeliveredAt()+""));
                cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell2.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cell2.setPaddingRight(5);
                table2.addCell(cell2);
           // }

            document.add(table2);
            
            
            
            
            
            
            
            
            
            
            com.itextpdf.text.Font charikaa = FontFactory.getFont(FontFactory.HELVETICA, 6 , BaseColor.BLACK); // couleur de paragraphe
			Paragraph parame = new Paragraph("Thanks for choosing us", charikaa);
			parame.setAlignment(Element.ALIGN_RIGHT);  // paragraphe centré
			document.add(parame);
			document.add(Chunk.NEWLINE); // traja3 lestar

            document.close();

        } catch (DocumentException ex) {

            logger.error("Error occurred: {0}", ex);
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}

