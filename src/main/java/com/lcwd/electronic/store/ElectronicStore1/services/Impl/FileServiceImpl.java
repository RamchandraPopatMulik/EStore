package com.lcwd.electronic.store.ElectronicStore1.services.Impl;

import com.lcwd.electronic.store.ElectronicStore1.exceptions.BadApiRequest;
import com.lcwd.electronic.store.ElectronicStore1.services.FileService;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;
import java.util.logging.Logger;


@Service
public class FileServiceImpl implements FileService {

    private Logger logger= (Logger) LoggerFactory.getLogger(FileServiceImpl.class);
    @Override
    public String uploadFile(MultipartFile file, String path) throws IOException {

        String originalFilename = file.getOriginalFilename();
        logger.info("FileName is : {}"+originalFilename);
        String fileName = UUID.randomUUID().toString();
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileNameWithExtension = fileName + extension;
        String fullPathWithFileName=path + File.separator+fileNameWithExtension;

        if(extension.equalsIgnoreCase(".png") || extension.equalsIgnoreCase(".jpeg"))
        {
         File folder = new File(path);

         if(!folder.exists())
         {
           // Folder Create
             folder.mkdirs();
         }
            Files.copy(file.getInputStream(), Paths.get(fullPathWithFileName));

         return fileNameWithExtension;
        }
        else
        {
            throw new BadApiRequest("File With this" +extension + "Not Alloewd!!!!");
        }
        
    }

    @Override
    public InputStream getResource(String path, String name) {
        return null;
    }
}
