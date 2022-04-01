package com.lpp.crud.bean;

public class Department {
    private Integer deptId;

    private String deprName;

    public Department() {
        super();
    }

    public Department(Integer deptId, String deprName) {
        super();
        this.deptId = deptId;
        this.deprName = deprName;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeprName() {
        return deprName;
    }

    public void setDeprName(String deprName) {
        this.deprName = deprName == null ? null : deprName.trim();
    }
}