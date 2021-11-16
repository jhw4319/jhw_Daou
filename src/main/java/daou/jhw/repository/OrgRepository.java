package daou.jhw.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import daou.jhw.entity.Organization;
import daou.jhw.entity.QOrganization;
import daou.jhw.model.OrganizationItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrgRepository {

    private final JPAQueryFactory queryFactory;

    // 부서
    private static final String DEPT = "dept";
    // 부서원
    private static final String MEMBER = "member";

    // 조직도 조회
    public List<Organization> findAllOrg() {
        QOrganization parent = new QOrganization("parent");
        QOrganization children = new QOrganization("children");

        return queryFactory.selectFrom(parent)
                .distinct()
                .innerJoin(parent.children, children)
                .fetchJoin()
                .where(parent.parent.isNull())
                .fetch();
    }

    // 조직도 조회(부서정보)
    public List<Organization> findDeptOnly() {
        QOrganization parent = new QOrganization("parent");
        QOrganization children = new QOrganization("children");

        return queryFactory.selectFrom(parent)
                .distinct()
                .innerJoin(parent.children, children)
                .fetchJoin()
                .where(parent.parent.isNull(), children.type.ne("Member"))
                .fetch();
    }

    // 조직도 조회(부서코드)
    public List<Organization> findDeptCode(String deptCode) {
        QOrganization parent = new QOrganization("parent");
        QOrganization children = new QOrganization("children");

        return queryFactory.selectFrom(parent)
                .distinct()
                .innerJoin(parent.children, children)
                .fetchJoin()
                .where(parent.parent.isNull(), eqDeptCode(deptCode, children))
                .fetch();
    }

    // 조직도 조회(검색 대상)
    public List<Organization> findSearchType(String searchType) {
        QOrganization parent = new QOrganization("parent");
        QOrganization children = new QOrganization("children");

        return queryFactory.selectFrom(parent)
                .distinct()
                .innerJoin(parent.children, children)
                .fetchJoin()
                .where(parent.parent.isNull(), eqSearchType(searchType, children))
                .fetch();
    }

    // 조직도 조회(검색어)
    public List<Organization> findSearchKeyword(String searchKeyword) {
        QOrganization parent = new QOrganization("parent");
        QOrganization children = new QOrganization("children");

        return queryFactory.selectFrom(parent)
                .distinct()
                .innerJoin(parent.children, children)
                .fetchJoin()
                .where(parent.parent.isNull(), likeSearchKeyword(searchKeyword, children))
                .fetch();
    }

    private BooleanExpression eqDeptCode(String deptCode, QOrganization qOrg) {
        if (StringUtils.hasText(deptCode)) {
            return qOrg.code.eq(deptCode);
        }
        return null;
    }

    private BooleanExpression eqSearchType(String searchType, QOrganization qOrg) {
        if (StringUtils.hasText(searchType)) {
            if (DEPT.equals(searchType)) {
                return qOrg.type.ne("Member");
            } else {
                return qOrg.type.eq("Member");
            }
        }
        return null;
    }

    private BooleanExpression likeSearchKeyword(String searchKeyword, QOrganization qOrg) {
        if (StringUtils.hasText(searchKeyword)) {
            return qOrg.name.like(searchKeyword);
        }
        return null;
    }
}
