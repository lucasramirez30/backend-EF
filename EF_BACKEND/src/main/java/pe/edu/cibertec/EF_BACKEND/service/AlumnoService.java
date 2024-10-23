package pe.edu.cibertec.EF_BACKEND.service;

import pe.edu.cibertec.EF_BACKEND.dto.ConsultaRequestDTO;

import java.io.IOException;

public interface AlumnoService {
    String[] consultarAlumno(ConsultaRequestDTO consultaRequestDTO) throws IOException;
}