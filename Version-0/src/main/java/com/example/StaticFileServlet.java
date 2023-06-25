package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StaticFileServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the requested file path from the URL
        String requestedFilePath = request.getPathInfo();

        // Define the directory where your static files are located
        String rootDirectory = "/src/main/webapp/static/";

        // Create a file object with the requested file path
        File file = new File(rootDirectory, requestedFilePath);

        if (file.exists() && file.isFile()) {
            // Set the content type based on the file extension
            String mimeType = getServletContext().getMimeType(file.getName());
            response.setContentType(mimeType);

            // Set the content length (optional)
            response.setContentLength((int) file.length());

            // Create an input stream to read the file
            FileInputStream in = new FileInputStream(file);

            // Create an output stream to write the file content to the response
            OutputStream out = response.getOutputStream();

            // Copy the file content from input stream to output stream
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }

            // Close the streams
            in.close();
            out.close();
        } else {
            // If the file doesn't exist, return a 404 error
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
