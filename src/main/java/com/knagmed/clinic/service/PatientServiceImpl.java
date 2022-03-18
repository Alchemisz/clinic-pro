package com.knagmed.clinic.service;

import com.knagmed.clinic.dao.PatientRepository;
import com.knagmed.clinic.entity.Patient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public Patient save(Patient patient) {

        try {
            if (patientRepository.findPatientByPesel(patient.getPesel()).isPresent())
                throw new SQLException("PATIENT WITH THAT PESEL ALREADY EXISTS!");
        } catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }

        return patientRepository.save(patient);
    }

    @Override
    public Optional<Patient> getById(Long id) {
        return patientRepository.findById(id);
    }

    @Override
    public List<Patient> getAll() {
        return patientRepository.findAll();
    }
}
