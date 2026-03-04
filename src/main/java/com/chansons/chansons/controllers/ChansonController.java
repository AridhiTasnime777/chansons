package com.chansons.chansons.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.chansons.chansons.entities.Chanson;
import com.chansons.chansons.services.ChansonService;
@Controller
public class ChansonController {
    @RequestMapping("/myView")
    public String myView()
    {
        return "myView";
    }
@Autowired
ChansonService chansonService;
@RequestMapping("/ListeChansons")
public String listeChansons(ModelMap modelMap)
{
List<Chanson> chs = chansonService.getAllChansons();
modelMap.addAttribute("chansons", chs);
return "listeChansons";
}
 @RequestMapping("/showCreate")
public String showCreate()
{
return "createChanson";
}
@RequestMapping("/saveChanson")
public String saveChanson(@ModelAttribute("chanson") Chanson chanson,
@RequestParam("date") String date,
ModelMap modelMap) throws ParseException
{
//conversion de la date
 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
 Date dateCreation = dateformat.parse(String.valueOf(date));
 chanson.setReleaseDate(dateCreation);

Chanson saveChanson = chansonService.saveChanson(chanson);
String msg ="chanson enregistré avec Id "+saveChanson.getIdChanson();
modelMap.addAttribute("msg", msg);
return "createChanson";
}
@RequestMapping("/supprimerChanson")
public String supprimerChanson(@RequestParam("id") Long id,
 ModelMap modelMap)
{
chansonService.deleteChansonById(id);
List<Chanson> chs = chansonService.getAllChansons();
modelMap.addAttribute("chansons", chs);
return "listeChansons";
}

 @RequestMapping("/modifierChanson")
public String editerChanson(@RequestParam("id") Long id,
 ModelMap modelMap)
{
Chanson p= chansonService.getChanson(id);
modelMap.addAttribute("chanson", p);
return "editerChanson";
}
@RequestMapping("/updateChanson")
public String updateChanson(@ModelAttribute("chanson") Chanson chanson, @RequestParam("date") String date,
 ModelMap modelMap) throws ParseException
{
//conversion de la date
 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
 Date dateCreation = dateformat.parse(String.valueOf(date));
 chanson.setReleaseDate(dateCreation);
 chansonService.updateChanson(chanson);
 List<Chanson> chs = chansonService.getAllChansons();
 modelMap.addAttribute("chansons", chs);
return "listeChansons";
}

}
