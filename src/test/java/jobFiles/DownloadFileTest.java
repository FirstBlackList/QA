package jobFiles;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class DownloadFileTest {

    @Test
    void downloadFileTxt() throws Exception {
        open("https://github.com/SeleniumHQ/selenium/blob/trunk/README.md");
        File downloadTxt = $("a[href='https://github.com/SeleniumHQ/selenium/raw/trunk/README.md']").scrollTo().download();
        try (InputStream is = new FileInputStream(downloadTxt)) {
            byte[] bytes = is.readAllBytes();
            String fileContent = new String(bytes, StandardCharsets.UTF_8);
            System.out.println(fileContent);
            assertThat(fileContent).contains("[User Manual](https://selenium.dev/documentation/)");
        }

    }

    @Test
    void downloadCucumberFile() throws Exception {
        open("https://github.com/cucumber/cucumber-js/blob/main/docs/support_files/world.md");
        File newFile = $("a[data-testid=raw-button]").download();
        try (InputStream is = new FileInputStream(newFile)) {
            byte[] bytes = is.readAllBytes();
            String cont = new String(bytes, StandardCharsets.UTF_8);
            assertThat(cont).contains("Given(\"my color is {string}\", function(color) {\n" +
                    "  this.color = color\n" +
                    "})");
        }
    }

    @Test
    void fileDownload() throws Exception {
        open("https://www.dwsamplefiles.com/download-txt-sample-files/");
        File newFile = $("a[href='https://www.dwsamplefiles.com/?dl_id=176']").scrollTo().download();
        try (InputStream iS = new FileInputStream(newFile)) {
            byte[] info = iS.readAllBytes();
            String resText = new String(info, StandardCharsets.UTF_8);
            String expected = "Utilitatis causa amicitia est quaesita.\n" +
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Collatio igitur ista te nihil iuvat. Honesta oratio, Socratica, Platonis etiam. Primum in nostrane potestate est, quid meminerimus? Duo Reges: constructio interrete. Quid, si etiam iucunda memoria est praeteritorum malorum? Si quidem, inquit, tollerem, sed relinquo. An nisi populari fama?\n" +
                    "\n" +
                    "Quamquam id quidem licebit iis existimare, qui legerint. Summum a vobis bonum voluptas dicitur. At hoc in eo M. Refert tamen, quo modo. Quid sequatur, quid repugnet, vident. Iam id ipsum absurdum, maximum malum neglegi.";
            String[] obj = resText.split("\\.");
            for (String s : obj) {
                System.out.println(s);
            }
            Assertions.assertEquals(expected, resText);
        }
    }


}
