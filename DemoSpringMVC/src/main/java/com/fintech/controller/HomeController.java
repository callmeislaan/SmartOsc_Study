package com.fintech.controller;

import com.fintech.model.Person;
import com.fintech.model.Persons;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = {"/", "/home"})
public class HomeController {

    @RequestMapping("/")
    public String getIndex() {
        return "index";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getHome(Model model) {
        List<Person> list = new ArrayList<>();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Persons.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Persons persons = (Persons) unmarshaller.unmarshal(
                    getClass().getClassLoader().getResource("test.xml")
            );
            list = persons.getPersonList();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        model.addAttribute("persons", list);

        return "home";
    }

//    @RequestMapping("/home")
//    public @ResponseBody Persons getPersons() {
//        List<Person> list = new ArrayList<>();
//        Persons persons = null;
//        try {
//            JAXBContext jaxbContext = JAXBContext.newInstance(Persons.class);
//            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
//            persons = (Persons) unmarshaller.unmarshal(
//                    getClass().getClassLoader().getResource("test.xml")
//            );
//            list = persons.getPersonList();
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
//        return persons;
//    }
}
