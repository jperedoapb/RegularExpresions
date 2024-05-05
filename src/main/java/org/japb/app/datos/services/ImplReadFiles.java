package org.japb.app.datos.services;

import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Log4j2
public class ImplReadFiles implements ReadFile{

    private final ResourceLoader resourceLoader;

    public ImplReadFiles(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public List<String> readFile() {
        List<String> lines = new ArrayList<>();
        Pattern pat = Pattern.compile("^2011\\-.*[zk].*$");
        // Cargamos el archivo:
        try{
            // Cargar el archivo CSV desde el directorio resources
            Resource resource = new ClassPathResource("results.csv");

            // Leer el archivo CSV
            BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                // Procesar cada línea del CSV
                Matcher matcher = pat.matcher(line);
                if (matcher.find()) {
                    log.info(line);
                    lines.add(line);
                }

            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
