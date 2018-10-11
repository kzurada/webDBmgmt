package com.web.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Contract {

    @Id
    @GeneratedValue
    private int id;

    private String system;
    private Boolean active;
    private String contractName;

    public Contract() {
        super();
    }

    public Contract(int id, String system, Boolean active, String contractName) {
        super();
        this.id = id;
        this.system = system;
        this.active = active;
        this.contractName = contractName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public Boolean getActive() {
        return active;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
