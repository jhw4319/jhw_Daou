package daou.jhw.service;


import daou.jhw.entity.Organization;
import daou.jhw.model.OrgItem;
import daou.jhw.model.OrganizationItem;
import daou.jhw.repository.OrgRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrganizationService {

    private final OrgRepository orgRepository;


    public List<OrganizationItem> getOrg(OrgItem orgItem) {

        List<Organization> find;
        if (orgItem.isDeptOnly()) {
            find = orgRepository.findDeptOnly();
        }
        else if (orgItem.getDeptCode() != null) {
            find = orgRepository.findDeptCode(orgItem.getDeptCode());
        }
        else if (orgItem.getSearchType() != null) {
            find = orgRepository.findSearchType(orgItem.getSearchType());
        }
        else if (orgItem.getSearchKeyword() != null) {
            find = orgRepository.findSearchType(orgItem.getSearchKeyword());
        }
        else {
            find = orgRepository.findAllOrg();
        }
        return find.stream().map(OrganizationItem::new).collect(Collectors.toList());

    }

}
