package daou.jhw.controller;


import daou.jhw.model.OrgItem;
import daou.jhw.model.OrganizationItem;
import daou.jhw.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/org")
@RequiredArgsConstructor
public class OrganizationController {

    private final OrganizationService organizationService;

    @GetMapping("/organizations")
    public ResponseEntity<List<OrganizationItem>> getOrganization(@ModelAttribute OrgItem orgItem) {
        List<OrganizationItem> result = organizationService.getOrg(orgItem);
        return ResponseEntity.ok(result);
    }

//    @PostMapping("/dept")
//    public ResponseEntity<List<OrganizationItem>> deptAdd() {
//        return ResponseEntity.ok(result);
//    }
//
//    @PutMapping("/dept/{deptId}")
//    public ResponseEntity<List<OrganizationItem>> deptEdit(@PathVariable Long deptId) {
//        return ResponseEntity.ok(result);
//    }
//
//    @DeleteMapping("/dept/{deptId}")
//    public ResponseEntity<List<OrganizationItem>> deptDelete(@PathVariable Long deptId) {
//        return ResponseEntity.ok(result);
//    }
//
//    @PostMapping("/member")
//    public ResponseEntity<List<OrganizationItem>> memberAdd() {
//        return ResponseEntity.ok(result);
//    }
//
//    @PutMapping("/member/{memberId}")
//    public ResponseEntity<List<OrganizationItem>> memberEdit(@PathVariable Long memberId) {
//        return ResponseEntity.ok(result);
//    }
//
//    @DeleteMapping("/member/{memberId}")
//    public ResponseEntity<List<OrganizationItem>> memberDelete(@PathVariable Long memberId) {
//        return ResponseEntity.ok(result);
//    }



}

