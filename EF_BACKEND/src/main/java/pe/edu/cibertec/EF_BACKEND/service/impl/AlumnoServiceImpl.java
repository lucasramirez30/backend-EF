package pe.edu.cibertec.EF_BACKEND.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.EF_BACKEND.dto.ConsultaRequestDTO;
import pe.edu.cibertec.EF_BACKEND.service.AlumnoService;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    private ResourceLoader resourceLoader;

    private Resource resource;

    @Override
    public String[] consultarAlumno(ConsultaRequestDTO consultaRequestDTO) throws IOException{
        if (resource == null) {
            resource = resourceLoader.getResource("classpath:alumnos.txt");
        }

        List<String[]> alumnos = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Path.of(resource.getFile().toURI()))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                alumnos.add(data);
            }

            for (String [] alumno : alumnos) {
                if (consultaRequestDTO.codigoAlumno().equals(alumno[0])) {
                    return alumno;
                }
            }
        } catch (IOException e) {
            throw new IOException("Error al leer el archivo alumnos.txt");
        }
        return null;
    }
}
