package daou.jhw.model;

import daou.jhw.entity.Organization;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Setter
public class OrganizationItem {

    private Long id;

    private String type;

    private String name;

    private String code;

    private Boolean manager;

    private List<OrganizationItem> children = new ArrayList<>();

    public OrganizationItem() {
    }

    public OrganizationItem(Long id, String type, String name, String code, Boolean manager) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.code = code;
        this.manager = manager;
    }

    public OrganizationItem(Organization organization) {
        this.id = organization.getId();
        this.type = organization.getType();
        this.name = organization.getName();
        this.code = organization.getCode();
        this.manager = Optional.ofNullable(organization.getManager()).orElse(Boolean.FALSE);
        this.children = organization.getChildren().stream().map(OrganizationItem::new).collect(Collectors.toList());
    }
}
