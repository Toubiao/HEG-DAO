package ch.hegarc.ig.daoPOC.dao.xml;

import ch.hegarc.ig.daoPOC.dao.intf.Dao;
import ch.hegarc.ig.daoPOC.entity.Eleve;
import ch.hegarc.ig.daoPOC.entity.Eleves;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class XmlElevesDao implements Dao<Eleve> {

    @Override
    public boolean create(Eleve obj) {
        List<Eleve> eleves = unmarshallXml();
        eleves.add(obj);
        return overrideXml(eleves);
    }

    @Override
    public boolean delete(int nb) {
        List<Eleve> eleves = unmarshallXml();

        for(int i = 0;i < eleves.size();i++) {
            if(eleves.get(i).getNumber() == nb) {
                eleves.remove(i);
                return overrideXml(eleves);
            }
        }
        return false;
    }

    @Override
    public boolean update(Eleve obj) {
        //cherche l'index de l'élève en param pour le remplacer
        List<Eleve> eleves = unmarshallXml();

        try{
            for(int i = 0;i < eleves.size();i++){
                if(eleves.get(i).getNumber() == obj.getNumber()) {
                    eleves.set(i, obj);
                    return overrideXml(eleves);
                }
            }
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Eleve find(int id) {
        //Renvoie un élève en le cherchant dans la liste;
        List<Eleve> eleves = unmarshallXml();

            for(int i = 0;i < eleves.size();i++) {
                if(eleves.get(i).getNumber() == id)
                    return eleves.get(i);
            }
        return null;
    }

    @Override
    public List<Eleve> findAll() {
        return unmarshallXml();
    }

    @Override
    public int findNextId(){
        //Trouve le Next Id d'un eleve en prenant l'id du dernier éléve du fichier +1
        List<Eleve> eleves = unmarshallXml();
        int nextIndex = eleves.get(eleves.size()).getNumber() + 1;
        return nextIndex;
    }

    private List<Eleve> unmarshallXml(){
        // Cette fonction retourne la liste complète des eleves qui se trouve dans le fichier xml
        try{
            JAXBContext jaxbContext = JAXBContext.newInstance(Eleves.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Eleves eleves = (Eleves) jaxbUnmarshaller.unmarshal((new File("./eleves.xml")));
            return eleves.getListeEleves();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean overrideXml(List<Eleve> eleves){
        // cette fonction prend en paramètre une liste d'élève et va override le fichier xml
        Eleves listeEleves = new Eleves(eleves);
        try {
            File file = new File("./eleves.xml");
            FileOutputStream outputStream  = new FileOutputStream(file, false);
            JAXBContext jaxbContext = JAXBContext.newInstance(Eleves.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(listeEleves,outputStream);
            return true;

        }catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
