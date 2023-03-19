import java.io.FileWriter;
import java.util.logging.Logger;

public class UploadFile {

    public static void Uploader() throws Exception {
        FileWriter fileWriter = new FileWriter("MyFile.txt");
        fileWriter.write("UploaderFileCheck");
        fileWriter.close();

    }

    public static void main(String[] args) throws Exception {
        UploadFile.Uploader();
    }

}
