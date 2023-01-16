package it.training.spring_jsp_example.repo;

import it.training.spring_jsp_example.model.WebSiteInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface WebSiteInfoRepository extends JpaRepository<WebSiteInfo, Long> {
    WebSiteInfo findFirstByOrderByIdDesc();
    WebSiteInfo updateWebsiteInfo(long id);
}