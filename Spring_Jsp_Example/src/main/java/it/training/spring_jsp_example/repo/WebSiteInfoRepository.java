package it.training.spring_jsp_example.repo;

import it.training.spring_jsp_example.model.WebSiteInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface WebSiteInfoRepository extends JpaRepository<WebSiteInfo, Long> {
    @Transactional
    @Modifying
    @Query("update WebSiteInfo w set w.name = ?1, w.description = ?2 where w.name = ?3 and w.description = ?4")
    WebSiteInfo updateWebsiteInfo(long id,String name, String description, String name1, String description1);
    WebSiteInfo findFirstByOrderByIdDesc();

    void updateWebsiteInfo(long id, String name, String description);
}