package dev.jlkesh.library.library.servlets.book;

import dev.jlkesh.library.library.dao.BookDAO;
import dev.jlkesh.library.library.dao.CategoryDAO;
import dev.jlkesh.library.library.dao.DocumentDAO;
import dev.jlkesh.library.library.domains.Book;
import dev.jlkesh.library.library.domains.Document;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

@WebServlet(name = "BookAddServlet", urlPatterns = "/book/add")
@MultipartConfig(location = "/home/jlkesh/apps/library/upload")
public class BookAddServlet extends HttpServlet {

    private static final Path rootPath = Path.of(System.getProperty("user.home"), "/apps/library/upload");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDAO categoryDAO = CategoryDAO.getInstance();
        request.setAttribute("categories", categoryDAO.findAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/book/create.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String publishedAt1 = request.getParameter("publishedAt");
        System.out.println(publishedAt1);
        LocalDate publishedAt = LocalDate.parse(publishedAt1);
        Part file = request.getPart("file");
        Part image = request.getPart("image");
        String description = request.getParameter("description");
        String publisher = request.getParameter("publisher");
        String categoryId = request.getParameter("category_id");
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        Document imageDocument = saveFile(image);
        Document fileDocument = saveFile(file);
        BookDAO bookDAO = BookDAO.getInstance();
        Book book = Book.builder()
                .title(title)
                .author(author)
                .description(description)
                .publisher(publisher)
                .publishedAt(publishedAt)
                .coverId(imageDocument.getId())
                .documentId(fileDocument.getId())
                .category(Integer.parseInt(categoryId))
                .pages(300)
                .build();
        bookDAO.save(book);
        response.sendRedirect("/index.jsp");
    }

    private static Document saveFile(Part file) {
        try {
            DocumentDAO documentDAO = DocumentDAO.getInstance();
            String originalName = file.getSubmittedFileName();
            String extension = originalName.substring(originalName.lastIndexOf("."));
            String generatedName = UUID.randomUUID() + extension;
            String mimeType = file.getContentType();
            System.out.println(mimeType);
            long size = file.getSize();
            Document document = Document.builder()
                    .generatedFileName(generatedName)
                    .originalFileName(originalName)
                    .fileSize(size)
                    .mimeType(mimeType)
                    .filePath(rootPath.resolve(generatedName).toString())
                    .extension(extension)
                    .build();
            document = documentDAO.save(document);
            file.write(generatedName);
            return document;
        } catch (Exception e) {
            // TODO: 08/02/23 redirect to error page
            throw new RuntimeException(e);
        }
    }

}
