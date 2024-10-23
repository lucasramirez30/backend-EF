package pe.edu.cibertec.EF_BACKEND.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.EF_BACKEND.dto.ConsultaRequestDTO;
import pe.edu.cibertec.EF_BACKEND.dto.ConsultaResponseDTO;
import pe.edu.cibertec.EF_BACKEND.service.AlumnoService;

import java.time.Duration;
import java.util.Arrays;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {

    @Autowired
    AlumnoService alumnoService;

    @RequestMapping("/buscar")
    public ConsultaResponseDTO consultarAlumno(@RequestBody ConsultaRequestDTO consultaRequestDTO) {
        try {
            Thread.sleep(Duration.ofSeconds(5));

            String[] dataAlumno = alumnoService.consultarAlumno(consultaRequestDTO);
            System.out.println("Resultado: " + Arrays.toString(dataAlumno));
            if (dataAlumno == null || dataAlumno.length == 0) {
                return new ConsultaResponseDTO("ERROR 400","NO","ALUMNO","FOUND","'(:/)'");
            }
            return new ConsultaResponseDTO(dataAlumno[0],dataAlumno[1],dataAlumno[2],dataAlumno[3],dataAlumno[4]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
