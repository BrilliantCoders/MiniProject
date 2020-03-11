package com.helper;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class FileUploadHelper {

    public void uploadFile(CommonsMultipartFile file, HttpSession session) {
        String path = session.getServletContext().getRealPath("/");
        String filename = file.getOriginalFilename();

        System.out.println(path + " " + filename);

        try {
            byte barr[] = file.getBytes();

            BufferedOutputStream bout = new BufferedOutputStream(
                    new FileOutputStream(path + "/" + filename));
            bout.write(barr);
            bout.flush();
            bout.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
