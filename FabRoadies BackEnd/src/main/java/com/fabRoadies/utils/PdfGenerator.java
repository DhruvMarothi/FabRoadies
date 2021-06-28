package com.fabRoadies.utils;
import com.fabRoadies.entity.Passenger;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.text.Document;
 import com.itextpdf.text.DocumentException;
 import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.PdfPCell;
 import com.itextpdf.text.pdf.PdfPTable;
 import com.itextpdf.text.pdf.PdfWriter;

import ch.qos.logback.classic.Logger;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
 import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.springframework.stereotype.Component;
 
/**
 * @author Pratik
 * @version 2.0
 */
@Component
public class PdfGenerator {

   // private static final com.itextpdf.text.log.Logger LOGGER = LoggerFactory.getLogger(PdfGenerator.class);

    public static void generateItenary(List<Passenger> reservation, String filePath) throws DocumentException, MalformedURLException, IOException{
    //    LOGGER.info("generateItinerary()");
        Document document=new Document();
        
        
        
        
        
        try {
        	
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();
            PdfPTable table = new PdfPTable(3);         
            String impath="C:\\Users\\ibmjfsdb209\\Desktop\\FabRoadies\\FabRoadies FrontEnd\\src\\assets\\icon01.jpg";
            Image image = Image.getInstance(impath);
            image.scaleToFit(175, 175);
            image.setAbsolutePosition(400,750);
            document.add(image);
   
            
            Paragraph p1=new Paragraph("FabRoadies");
            
            p1.setSpacingBefore(40);
            document.add(p1);
            Paragraph p2=new Paragraph("****");
            document.add(p2);
           // document.add(generateTable(reservation));
            PdfPCell c1 = new PdfPCell(new Phrase("Reservation Date:"+reservation.get(0).getTicket().getReservationDate()+""));
            table.addCell(c1);
            PdfPCell c2 = new PdfPCell(new Phrase("Bus Number:"+reservation.get(0).getTicket().getBus().getBusno()));
            table.addCell(c2);
            PdfPCell c3 = new PdfPCell(new Phrase("Ticket Number"+" "+reservation.get(0).getTicket().getTicketId()));
            table.addCell(c3);
            PdfPCell c4 = new PdfPCell(new Phrase("Departure City :"+reservation.get(0).getTicket().getBus().getDepartureCity()));
            c4.setColspan(2);
            table.addCell(c4);
            PdfPCell c5 = new PdfPCell(new Phrase("Arrival City :"+reservation.get(0).getTicket().getBus().getArrivalCity()));
            
            table.addCell(c5);
            
          
            for(int i=0;i<reservation.size();i++)
            {  
            	 PdfPCell c6 = new PdfPCell(new Phrase("Name : "+reservation.get(i).getName()));
            	 c6.setColspan(2);
                 table.addCell(c6);
                 PdfPCell c7 = new PdfPCell(new Phrase("SeatNo :"+" "+reservation.get(i).getSeatno()));
                 
                 table.addCell(c7);
        
  

            }
            PdfPCell c8 = new PdfPCell(new Phrase("Total Cost :"+reservation.get(0).getTicket().getPrice()+""));
            c8.setColspan(3);
            table.addCell(c8);
         
            
            document.add(table);
            
            document.close();

        } catch (FileNotFoundException e){}
    }
}