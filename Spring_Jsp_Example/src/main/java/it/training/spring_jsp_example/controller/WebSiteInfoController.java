package it.training.spring_jsp_example.controller;

import it.training.spring_jsp_example.business.interfaces.WebSiteInterface;
import it.training.spring_jsp_example.model.WebSiteInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebSiteInfoController {
    @Autowired
    WebSiteInterface webSiteInterface;

    @GetMapping(path = {"/", "/index"})
    public ModelAndView home() {
        WebSiteInfo webSiteInfo = webSiteInterface.getWebSiteInfo();
        return new ModelAndView("/jsp/index.jsp", "Info", webSiteInfo);
    }

    @GetMapping("createInfo")
    public ModelAndView createInfo() {
        return new ModelAndView("/jsp/createInfo.jsp");
    }

    @PostMapping("createInfo")
    public ModelAndView insertInfo(@RequestParam String description, @RequestParam String name) {
        WebSiteInfo webSiteInfo = new WebSiteInfo();
        webSiteInfo.setName(name);
        webSiteInfo.setDescription(description);
        webSiteInterface.insertWebSiteInfo(webSiteInfo);
        return new ModelAndView("/jsp/createInfo.jsp", "operation", true);
    }

    @GetMapping("deleteViewInfo")
    public ModelAndView deleteInfo() {
        return new ModelAndView("/jsp/deleteInfo.jsp");
    }

    @GetMapping("deleteInfo")
    public ModelAndView deleteInfo(@RequestParam String id) {
        if (!id.isEmpty()) {
            webSiteInterface.deleteWebSiteInfo(Long.parseLong(id));
            return new ModelAndView("/jsp/deleteInfo.jsp", "operation", true);
        }
        return new ModelAndView("/jsp/deleteInfo.jsp", "id_not_found", true);
    }
    @PostMapping("updateInfo")
    public ModelAndView updateInfo(@RequestParam String id,@RequestParam String description, @RequestParam String name) {
        WebSiteInfo webSiteInfo = new WebSiteInfo();
        webSiteInfo.setName(name);
        webSiteInfo.setDescription(description);
        webSiteInterface.updateWebSiteInfo(Long.parseLong(id));
        return new ModelAndView("/jsp/updateInfo.jsp", "operation", true);
    }
}
