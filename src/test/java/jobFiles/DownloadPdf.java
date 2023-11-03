package jobFiles;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DownloadPdf {

    ClassLoader cl = DownloadPdf.class.getClassLoader();
    @Test
    void downloadPdf() throws Exception {
        Configuration.holdBrowserOpen = true;

        try (InputStream iS = cl.getResourceAsStream("fileupload/bash.pdf")) {
            PDF content = new PDF(iS);
            assertThat(content.author).contains("Илья Шпигорь");
            System.out.println(content.author);
            System.out.println(content.title);
            System.out.println(content.numberOfPages);
            //System.err.println(content.text);
            String text = content.text;
            try (FileOutputStream fO = new FileOutputStream("C:\\Users\\ADMIN\\Desktop\\bash.txt")) {
                byte[] buf = text.getBytes();
                fO.write(buf);
            }
        }
    }

    @Test
    void downloadPdfAndSave() throws Exception {
        Configuration.holdBrowserOpen = true;

        try (
                InputStream iS = cl.getResourceAsStream("fileupload/bash.pdf");
                FileOutputStream fO = new FileOutputStream("C:\\Users\\ADMIN\\Desktop\\bash.txt")
            )
        {
            PDF content = new PDF(iS);
            assertThat(content.author).contains("Илья Шпигорь");
            System.out.println(content.author);
            System.out.println(content.title);
            System.out.println(content.numberOfPages);
            //System.err.println(content.text);
            String text = content.text;
            byte[] buf = text.getBytes();
            fO.write(buf);
        }
    }

    @Test
    void downloadPDF2() throws Exception {
        Configuration.pageLoadStrategy = "eager";
        open("https://klex.ru/17zh");
        File path = $("a[href='https://www.phantastike.com/100_famous/100_znamenityh_zagadok_istorii/pdf/'].download_lnk").download();

        PDF pdf = new PDF(path);
        System.out.println(pdf.author);
        assertThat(pdf.author).contains("Инга Юрьевна Романенко");
        String gui = pdf.text.substring(pdf.text.indexOf("впоследствии стало известно"),
                pdf.text.indexOf("Доброжелатель»."));
        System.out.println(gui);
        assertThat(pdf.text).contains(gui);
        int size = pdf.numberOfPages;
        System.out.println(size);

    }

    @Test
    void xlsParseTest() throws IOException {
        try (InputStream resourceAsStream = cl.getResourceAsStream("")) {
            XLS content = new XLS(resourceAsStream);
            System.out.println(content);
        }
    }



}
