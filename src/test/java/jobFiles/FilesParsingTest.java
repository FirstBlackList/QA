package jobFiles;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Configuration;
import com.codeborne.xlstest.XLS;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FilesParsingTest {

    ClassLoader cl = FilesParsingTest.class.getClassLoader();
    @Test
    void pdfParseTest() throws Exception {
        open("https://junit.org/junit5/docs/current/user-guide/");
        File downloadPdf = $("a[href='junit-user-guide-5.10.0.pdf']").download();
        /*try(InputStream is = new FileInputStream(downloadPdf)) {
            PDF content = new PDF(downloadPdf);
        }*/

        PDF content = new PDF(downloadPdf);
        assertThat(content.author).contains("Sam Brannen");
    }

    @Test
    void xlsParseTest() throws Exception {
        try (InputStream resourceAsStream = cl.getResourceAsStream("xlsFile/file_example_XLS_100.xls")) {
            XLS xlsFile = new XLS(resourceAsStream);
            assertThat(xlsFile.excel.getSheetAt(0).getRow(1).getCell(1).getStringCellValue().contains("Dulce"));
        }

        /*Configuration.timeout = 70000;
        open("https://file-examples.com/index.php/sample-documents-download/sample-xls-download/");
        File downloadXLS = $("a[href='https://file-examples.com/wp-content/storage/2017/02/file_example_XLS_100.xls']").scrollTo().download();
        try(InputStream is = new FileInputStream(downloadXLS)) {
            XLS content = new XLS(downloadXLS);
        }*/

        /*PDF content = new PDF(downloadPdf);
        assertThat(content.author).contains("Sam Brannen");*/
    }

    @Test
    void csvTest() throws IOException, CsvException {
        try (
                InputStream resourceAsStream = cl.getResourceAsStream("userData.csv");
                CSVReader csvFileReader = new CSVReader(new InputStreamReader(resourceAsStream))
        ) {
            List<String[]> list = csvFileReader.readAll();
            //assertThat(list.get(0)[1].contains("ergereegr"));
        }
    }

    @Test
    void csvTest1() throws IOException, CsvException {
        try (
                InputStream resourceAsStream = cl.getResourceAsStream("userData.csv");
                CSVReader csvFileReader = new CSVReader(new InputStreamReader(resourceAsStream))
        ) {
            List<String[]> list = csvFileReader.readAll();
            Assertions.assertEquals(list.get(3)[0], "ruffolo");


            //assertThat(list.get(3)[0].equals("gdgdfgd"));
        }
    }

    @Test
    void zipTest() throws IOException, CsvException {
        try (
                InputStream resourceAsStream = cl.getResourceAsStream("file.zip");
                ZipInputStream zis = new ZipInputStream(resourceAsStream)

        ) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                assertThat(entry.getName()).isEqualTo("dcds");
            }
        }
    }

    @Test
    void jsonParseTest() throws Exception {

        Gson gson = new Gson();
        try (
                InputStream resourceAsStream = cl.getResourceAsStream("testJson.json");
                InputStreamReader jsonReader = new InputStreamReader(resourceAsStream)
        ) {
            JsonObject jsonObject = gson.fromJson(jsonReader, JsonObject.class);

            assertThat(jsonObject.get("users").isJsonArray());
            assertThat(jsonObject.getAsJsonArray("users").get(0)
                    .getAsJsonObject().get("firstName").getAsString())
                    .isEqualTo("Krish");
            assertThat(jsonObject.getAsJsonArray("users").get(3)
                    .getAsJsonObject().get("emailAddress").getAsString())
                    .isEqualTo("devid.neo@learningcontainer.com");
        }
    }

    @Test
    @DisplayName("Тест русской раскладки")
    void jsonParseTestPojo() throws Exception {

        Gson gson = new Gson();
        try (
                InputStream resourceAsStream = cl.getResourceAsStream("testJson.json");
                InputStreamReader jsonReader = new InputStreamReader(resourceAsStream)
        ) {
            GlossaryJson jsonObject = gson.fromJson(jsonReader, GlossaryJson.class);

            int expected = jsonObject.getUsers().get(0).getUserId();
            Assertions.assertEquals(expected, 1);

            String firstNameTwoPlayer = jsonObject.getUsers().get(1).getFirstName();
            Assertions.assertEquals(firstNameTwoPlayer, "racks");

            assertThat(jsonObject.users.get(0).userId).isEqualTo(1);
            assertThat(jsonObject.getUsers().get(1).getLastName()).isEqualTo("jacson");
            assertThat(jsonObject.users.get(4).emailAddress).isEqualTo("jone.mac@learningcontainer.com");
        }
    }

}
