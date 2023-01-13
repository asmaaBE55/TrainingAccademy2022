package it.training.spring_jsp_example.business.interfaces;

import it.training.spring_jsp_example.model.WebSiteInfo;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface WebSiteInterface {
    public WebSiteInfo getWebSiteInfo() throws DataAccessException;

    public void insertWebSiteInfo(WebSiteInfo webSiteInfo) throws DataAccessException;

    public void deleteWebSiteInfo(long id) throws DataAccessException;
}
