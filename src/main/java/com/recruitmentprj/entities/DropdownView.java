package com.recruitmentprj.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


@ManagedBean
@ViewScoped
public class DropdownView implements Serializable {

    private Map<String,Map<String,String>> data = new HashMap<String, Map<String,String>>();
    private String experience;
    private Map<String,String> experiences;

    @PostConstruct
    public void init() {
        experiences  = new HashMap<String, String>();
        experiences.put("Entry", "Entry");
        experiences.put("Intermediate", "Intermediate");
        experiences.put("Expert", "Expert");
    }

    public Map<String, Map<String, String>> getData() {
        return data;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public Map<String, String> getExperiences() {
        return experiences;
    }

    public void onExperienceChange() {
        if(experience !=null && !experience.equals(""))
            experiences = data.get(experience);
        else
            experiences = new HashMap<String, String>();
    }
}