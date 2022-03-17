package com.knagmed.clinic.controller;

import com.knagmed.clinic.entity.Address;
import com.knagmed.clinic.entity.Doctor;
import com.knagmed.clinic.entity.Patient;
import com.knagmed.clinic.entity.Specialization;
import com.knagmed.clinic.service.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/doctor")
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping("/test")
    public ResponseEntity<Doctor> getTest(){
        Doctor doctor = new Doctor("Adrian", "Mengele", new Address("26-005", "Warszawa", "37A"));
        doctor.addSpecialization(new Specialization("Neurolog"));
        return new ResponseEntity<Doctor>(
                doctor
                , HttpStatus.OK
        );
    }

    @GetMapping("")
    public ResponseEntity<List<Doctor>> getPatient(){
        return new ResponseEntity<>(doctorService.getAll(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Doctor> addPatient(@RequestBody Doctor doctor){
        Doctor save = doctorService.save(doctor);
        return new ResponseEntity<Doctor>(save, HttpStatus.OK);
    }

}
