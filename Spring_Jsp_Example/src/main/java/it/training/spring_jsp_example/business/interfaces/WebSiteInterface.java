package it.training.spring_jsp_example.business.interfaces;

import it.training.spring_jsp_example.model.WebSiteInfo;
import org.springframework.dao.DataAccessException;

public interface WebSiteInterface {
    WebSiteInfo getWebSiteInfo() throws DataAccessException;

    void insertWebSiteInfo(WebSiteInfo webSiteInfo) throws DataAccessException;

    void deleteWebSiteInfo(long id) throws DataAccessException;

    void updateWebSiteInfo(long id) throws DataAccessException;
}
