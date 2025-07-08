package com.example.LearningPortal.service;
import com.example.LearningPortal.DTO.AdminDTO;
import com.example.LearningPortal.entity.Admin;
import com.example.LearningPortal.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {
private final AdminRepository adminRepository;

    public AdminDTO getAdminDetails() {
        Admin admin=adminRepository.findById(1).orElseThrow(()->new RuntimeException("Admin not found"));
        AdminDTO dto=new AdminDTO();
        dto.setEmail(admin.getEmail());
        dto.setName(admin.getName());
        return dto;
    }

    public void updateAdmin(int id, AdminDTO adminDTO) {
        Admin admin=adminRepository.findById(id).orElseThrow(()->new RuntimeException("Admin not found"));
        admin.setName(adminDTO.getName());
        admin.setEmail(adminDTO.getEmail());
        adminRepository.save(admin);
    }
}
