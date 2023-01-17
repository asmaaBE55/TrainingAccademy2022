package it.training.spring_jsp_example.repo;

import it.training.spring_jsp_example.model.WebSiteInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebSiteInfoRepository extends JpaRepository<WebSiteInfo, Long> {
    WebSiteInfo findFirstByOrderByIdDesc();

}