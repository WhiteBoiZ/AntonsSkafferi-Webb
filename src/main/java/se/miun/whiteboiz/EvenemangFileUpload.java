package se.miun.whiteboiz;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.primefaces.model.file.UploadedFiles;

import java.io.*;

@Named
@RequestScoped
public class EvenemangFileUpload {

    @Inject
    EvenemangService evenemangService;
    String realPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
    String absolutePath = realPath + "resources/images/";
    String destination = absolutePath;
    public void upload(FileUploadEvent event) {
        FacesMessage msg = new FacesMessage("Success! ", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);

        UploadedFile file = event.getFile();

        evenemangService.setInputImageName(file.getFileName());
        try {
            copyFile(event.getFile().getFileName(), file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void copyFile(String fileName, InputStream in) {
        try {
            // write the inputStream to a FileOutputStream
            OutputStream out = new FileOutputStream(new File(destination + fileName));
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            in.close();
            out.flush();
            out.close();
            System.out.println("New file uploaded: " + (destination + fileName));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
