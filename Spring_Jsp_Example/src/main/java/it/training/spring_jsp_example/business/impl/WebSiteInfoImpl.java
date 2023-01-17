package it.training.spring_jsp_example.business.impl;

import it.training.spring_jsp_example.business.interfaces.WebSiteInterface;
import it.training.spring_jsp_example.model.WebSiteInfo;
import it.training.spring_jsp_example.repo.WebSiteInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class WebSiteInfoImpl implements WebSiteInterface {
    @Autowired
    WebSiteInfoRepository webSiteInfoRepository;

    @Override
    public WebSiteInfo getWebSiteInfo() throws DataAccessException {
        return webSiteInfoRepository.findFirstByOrderByIdDesc();
    }

    @Override
    public void insertWebSiteInfo(WebSiteInfo webSiteInfo) throws DataAccessException {
        webSiteInfoRepository.save(webSiteInfo);
    }

    @Override
    public void deleteWebSiteInfo(long id) throws DataAccessException {
        webSiteInfoRepository.deleteById(id);
    }

    @Override
    public void updateWebSiteInfo(WebSiteInfo webSiteInfo) throws DataAccessException {
        webSiteInfoRepository.save(webSiteInfo);
    }
}
