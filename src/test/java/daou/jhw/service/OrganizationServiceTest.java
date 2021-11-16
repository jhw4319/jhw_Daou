package daou.jhw.service;

import daou.jhw.model.OrgItem;
import daou.jhw.model.OrganizationItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class OrganizationServiceTest {

    @Autowired
    OrganizationService service;

    @BeforeEach
    void testBefore() {

    }

    @Test
    @Transactional
    @DisplayName("조직도 조회")
    void getOrgDeptOnly() {

        OrgItem orgItem = new OrgItem();

        List<OrganizationItem> item =  service.getOrg(orgItem);

        assertThat(item.size()).isEqualTo(1);
        assertThat(item.get(0).getType()).isEqualTo("Company");
    }
}