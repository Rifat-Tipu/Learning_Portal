package com.example.LearningPortal.controller;
import com.example.LearningPortal.DTO.AdminDTO;
import com.example.LearningPortal.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/portal")
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/admin/get")
    public ResponseEntity<AdminDTO> getAdminDetails(){
        return ResponseEntity.ok(adminService.getAdminDetails());
    }

    @PutMapping("/admin/update/{id}")
    public void updateAdmin(@PathVariable int id, @RequestBody AdminDTO adminDTO){
        adminService.updateAdmin(id,adminDTO);
    }
}
