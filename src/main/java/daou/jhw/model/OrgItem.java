package daou.jhw.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrgItem {

    private String deptCode;

    private boolean deptOnly;

    private String searchType;

    private String searchKeyword;

    public OrgItem() {
    }

    public OrgItem(String deptCode, boolean deptOnly, String searchType, String searchKeyword) {
        this.deptCode = deptCode;
        this.deptOnly = deptOnly;
        this.searchType = searchType;
        this.searchKeyword = searchKeyword;
    }
}
