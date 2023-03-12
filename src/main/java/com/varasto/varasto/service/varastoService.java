package com.varasto.varasto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.varasto.varasto.data.Tavara;

@Service
public class varastoService {
    private List<Tavara> lista = new ArrayList<>();
    
    //varastolistan alustaminen
    public varastoService(){
        lista.add(new Tavara(0, "tv", 24.4, 'a', '1'));
        lista.add(new Tavara(1, "porakone", 0.99, 'a', '2'));
        lista.add(new Tavara(2, "jääkaappi", 63, 'a', '3'));
        lista.add(new Tavara(3, "matto", 5.2, 'a', '4'));
        lista.add(new Tavara(4, "kassakaappi", 100.1, 'a', '5'));
        lista.add(new Tavara(5, "videotykki", 0.5, 'b', '1'));
    }
    //tavaran lisäys
    public boolean addTavara(Tavara tavara){
        //tarkistetaan onko hyllypaikka käytössä
        if(!tarkistaHylly(tavara.getHyllyKirjain(), tavara.getHyllyNumero())){
        lista.add(tavara);
        return true;
    }
    return false;

    }
    //haetaan koko lista
    public List<Tavara> haeLista(){
        return new ArrayList<>(lista);
    }
    //tavaran etsiminen id:lla
    public Tavara etsiTavara(int id){
        for (Tavara haku : lista){
            if(haku.getId()== id){
                return haku;
            }
        }
        return null;
    }
    //tavaran poisto
    public boolean poistaTavara(int id){
        Tavara p = etsiTavara(id);

        if(p != null){
            return lista.remove(p);
        }
        return false;
    }
    //hyllypaikan tarkistus
    public boolean tarkistaHylly(char hyllyKirjain, char hyllyNumero){
        for (Tavara haku : lista){
            if(haku.getHyllyKirjain()== hyllyKirjain && haku.getHyllyNumero()== hyllyNumero){
                return true;
            }
        }
        return false;
    }
    //hyllypaikan siirtäminen Id:lla
    public boolean siirraHylly(int id, char hyllyKirjain, char hyllyNumero){
        Tavara t = etsiTavara(id);

        if(t != null){
            if(!tarkistaHylly(hyllyKirjain, hyllyNumero)){
                t.setHyllyKirjain(hyllyKirjain);
                t.setHyllyNumero(hyllyNumero);
                return true;
            }
        }
        return false;
    }

}
