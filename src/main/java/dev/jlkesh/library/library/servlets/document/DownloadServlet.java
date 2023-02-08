package dev.jlkesh.library.library.servlets.document;

import dev.jlkesh.library.library.dao.DocumentDAO;
import dev.jlkesh.library.library.domains.Document;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.print.attribute.standard.PresentationDirection;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@WebServlet(name = "DownloadServlet", value = "/download")
public class DownloadServlet extends HttpServlet {
    private static final Path rootPath = Path.of("/home/jlkesh/apps/library/upload");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename = request.getParameter("filename");
        String forDownload = request.getParameter("download");
        DocumentDAO documentDAO = DocumentDAO.getInstance();
        Document document = documentDAO.findByGeneratedName(filename);
        Path filePath = rootPath.resolve(filename);
        response.setContentType(document.getMimeType());
        if (forDownload != null)
            response.addHeader("Content-Disposition", "attachment; filename=" + document.getOriginalFileName());
        response.getOutputStream().write(Files.readAllBytes(filePath));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
