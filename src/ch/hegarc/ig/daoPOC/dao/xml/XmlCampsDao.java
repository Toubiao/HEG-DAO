package ch.hegarc.ig.daoPOC.dao.xml;

import ch.hegarc.ig.daoPOC.dao.intf.Dao;
import ch.hegarc.ig.daoPOC.entity.Camp;
import ch.hegarc.ig.daoPOC.entity.Camps;

import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class XmlCampsDao implements Dao<Camp> {

    @Override
    public boolean create(Camp obj) {

        List<Camp> camps = unmarshallXml();
        camps.add(obj);
        return overrideXml(camps);
    }

    @Override
    public boolean delete(int nb) {
        List<Camp> camps = unmarshallXml();

        for(int i = 0;i < camps.size();i++) {
            if(camps.get(i).getNumber() == nb) {
                camps.remove(i);
                return overrideXml(camps);
            }
        }
        return false;
    }

    @Override
    public boolean update(Camp obj) {

        //cherche l'index du camp en param pour le remplacer
        List<Camp> camps = unmarshallXml();

        try{
            for(int i = 0;i < camps.size();i++){
                if(camps.get(i).getNumber() == obj.getNumber()) {
                    camps.set(i, obj);
                    return overrideXml(camps);
                }
            }
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Camp find(int id) {
        //Renvoie un camp en le cherchant dans la liste;
        List<Camp> camps = unmarshallXml();

        for(int i = 0;i < camps.size();i++) {
            if(camps.get(i).getNumber() == id)
                return camps.get(i);
        }
        return null;
    }

    @Override
    public List<Camp> findAll() {
        return unmarshallXml();
    }
    @Override
    public int findNextId() {
        //Trouve le Next Id d'un camp en prenant l'id du dernier camp du fichier +1
        List<Camp> camps = unmarshallXml();
        int nextIndex = camps.get(camps.size()).getNumber() + 1;
        return nextIndex;
    }

    private List<Camp> unmarshallXml(){
        // Cette fonction retourne la liste complète des eleves qui se trouve dans le fichier xml
        try{
            JAXBContext jaxbContext = JAXBContext.newInstance(Camps.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Camps camps = (Camps) jaxbUnmarshaller.unmarshal((new File("./camps.xml")));
            return camps.getListeCamps();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean overrideXml(List<Camp> camps){
        // cette fonction prend en paramètre une liste d'élève et va override le fichier xml
        Camps listeCamps = new Camps(camps);
        try {
            File file = new File("./camps.xml");
            FileOutputStream outputStream  = new FileOutputStream(file, false);
            JAXBContext jaxbContext = JAXBContext.newInstance(Camps.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(listeCamps,outputStream);
            return true;

        }catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
