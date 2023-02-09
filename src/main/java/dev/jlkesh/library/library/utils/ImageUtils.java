package dev.jlkesh.library.library.utils;

import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageProducer;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class ImageUtils {
    private static final int COVER_WIDTH = 180;
    private static final int COVER_HEIGHT = 300;

    public static void getResize(Path source, Path target, int img_width, int img_height) throws IOException {
        try (InputStream is = new FileInputStream(source.toFile())) {
            resize(is, target, img_width, img_height);
        }
    }

    public static OutputStream resize(InputStream input, Path target, int width, int height) throws IOException {
        BufferedImage originalImage = ImageIO.read(input);
        Image newResizedImage = originalImage
                .getScaledInstance(width, height, Image.SCALE_SMOOTH);
        String fileName = target.getFileName().toString();
        String fileExtension = StringUtils.getFileExtension(fileName);
        OutputStream outputStream = Files.newOutputStream(target);
        ImageIO.write(convertToBufferedImage(newResizedImage), fileExtension, outputStream);
        return outputStream;
    }

    public static void resizeForCover(InputStream input, Path target) throws IOException {
        BufferedImage originalImage = ImageIO.read(input);
        Image newResizedImage = originalImage.getScaledInstance(COVER_WIDTH, COVER_HEIGHT, Image.SCALE_DEFAULT);
        String s = target.getFileName().toString();
        ImageIO.write(convertToBufferedImage(newResizedImage),StringUtils.getFileExtension(target.getFileName().toString()), target.toFile());
    }

    private static BufferedImage convertToBufferedImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }
        BufferedImage bufferedImage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.drawImage(img, 0, 0, null);
        graphics2D.dispose();
        return bufferedImage;
    }


}
