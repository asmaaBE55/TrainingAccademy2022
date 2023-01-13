package it.training.spring_jsp_example.repo;

import it.training.spring_jsp_example.model.WebSiteInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WebSiteInfoRepository extends JpaRepository<WebSiteInfo, Long> {
    WebSiteInfo findFirstByOrderByIdDesc();
    List<WebSiteInfo> findAll();
}