/*package jobFiles;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class UploadFileTest {

    @Test
    void uploadImages() {

        Configuration.pageLoadStrategy = "eager";
        open("https://dropmefiles.com/");
        $("input[type='file']").uploadFromClasspath("fileupload/el2.jpg");
        $(".progress").shouldHave(text("загружено"), visible);
        $(".expand").click();
        $(".icon").parent().shouldHave(text("el2.jpg"), visible);
    }

    @Test
    void uploadText() {

        Configuration.pageLoadStrategy = "eager";
        open("https://dropmefiles.com/");
        $("input[type='file']").uploadFromClasspath("fileupload/user.csv");
        $(".progress").shouldHave(text("загружено"), visible);
        $(".expand").click();
        $(".icon").parent().shouldHave(text("user.csv"), visible);
    }

    @Test
    void uploadMp3() {

        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        open("https://dropmefiles.com/");
        $("input[type='file']").uploadFromClasspath("fileupload/KoroliSHutLesnik.mp3");
        $(".progress").shouldHave(text("загружено"), Duration.ofSeconds(10));
        $("input[type='file']").uploadFromClasspath("fileupload/user.csv");
        $(".progress").shouldHave(text("загружено"), visible);
        $(".expand").click();
        $(".icon").parent().parent().shouldHave(
                text("KoroliSHutLesnik.mp3"), visible,
                text("user.csv"), visible);
        $(".exit").click();
        Selenide.switchTo().alert(Duration.ofSeconds(3)).accept();

    }

}*/
