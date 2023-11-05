/*package jobFiles;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SelenideFileTest {

    static  { //если в кнопке нет аттрибута href (так как не стабильными становяться тесты)
        //Configuration.fileDownload = FileDownloadMode.PROXY;
        //Configuration.downloadsFolder=куда скачивать
    }

    @Test
    void downloadTest() throws IOException {
        open("https://github.com/junit-team/junit5/blob/main/README.md");
        File download = $("[data-testid=raw-button]").download();

        //InputStream is = new FileInputStream(download);
        //InputStream is = Files.newInputStream(download.toPath()); ??? работает ли

        try (InputStream is = new FileInputStream(download)) { //вместо finally только если класс реализует interface Closeable
            byte[] bytes = is.readAllBytes();
            String textDocument = new String(bytes, StandardCharsets.UTF_8);
            assertThat(textDocument).contains("Contributions to JUnit");
        }

        //OR
        *//*try {
            byte[] bytes = is.readAllBytes();
            String textDocument = new String(bytes, StandardCharsets.UTF_8);
            assertThat(textDocument).contains("Contributions to JUnit");

        } finally {
            is.close();
        }*//*

    }

    @Test
    void uploadFile() {
        open("https://fineuploader.com/demos.html");
        // bad practic так как может не работать в CI$("input[type='file']").uploadFile(new File("build/downloads/9d232f86-0f14-487b-9d4c-b48f8a08bb89/README.md"));//pravilo zakon dlya UPLOAD
        $("input[type='file']").uploadFromClasspath("picture/image2.jpg");//всегда берёт из папки resources
        //javascript с его помощью можно поставить атрибут видимый-> невидимому элементу
        $("div.qq-file-info").shouldHave(text("image2.jpg"));
        System.out.println("");
    }

}*/
