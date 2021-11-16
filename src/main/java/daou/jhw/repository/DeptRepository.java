package daou.jhw.repository;


import com.querydsl.jpa.impl.JPAQueryFactory;
import daou.jhw.entity.Organization;
import daou.jhw.model.OrganizationItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class DeptRepository {

    private final JPAQueryFactory queryFactory;
    private final OrganizationRepository organizationRepository;

    // 부서 추가
    public void orgDeptAdd(OrganizationItem item) {
        Organization organization = new Organization();
        organization.setCode(item.getCode());
        organization.setName(item.getName());
        organization.setType(item.getType());

        organizationRepository.save(organization);
    }

    // 부서 수정
//    public List<Organization> orgDeptEdit() {
//        QOrganization parent = new QOrganization("parent");
//        QOrganization children = new QOrganization("children");
//
//        return queryFactory.update(parent)
//                .where(parent.parent.isNull())
//                .set()
//                .execute();
//    }
}
