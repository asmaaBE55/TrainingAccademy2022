package it.training.spring_jsp_example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "web_site_info")
public class WebSiteInfo extends BaseEntity {
    private String name;
    private String description;

}