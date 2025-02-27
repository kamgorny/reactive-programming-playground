package monoservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class MonoFileService implements FileService{

    private static final Logger logger = LoggerFactory.getLogger(MonoFileService.class);
    public static final Path PATH = Path.of("src/main/resources");


    @Override
    public Mono<String> read(String fileName)
    {
        return Mono.fromCallable(() -> Files.readString(PATH.resolve(fileName)));
    }

    @Override
    public Mono<Void> write(String fileName, String content)
    {
        return Mono.fromRunnable(() -> writeToFile(fileName, content));
    }

    @Override
    public Mono<Void> delete(String fileName)
    {
        return Mono.fromRunnable(() -> deleteFile(fileName));
    }


    private void writeToFile(String fileName, String content)
    {
        try
        {
            Files.writeString(PATH.resolve(fileName), content);
            logger.info("Content written to file.");
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    private void deleteFile(String fileName)
    {
        try
        {
            Files.delete(PATH.resolve(fileName));
            logger.info("Deleted: {}", fileName);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
