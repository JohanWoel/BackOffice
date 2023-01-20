package encheres.backoffice.service;

import encheres.backoffice.models.statistiques.AvgMise;
import encheres.backoffice.models.statistiques.NbEncheres;
import encheres.backoffice.models.statistiques.NbMise;
import encheres.backoffice.repository.AvgMiseRepository;
import encheres.backoffice.repository.NbEncheresRepository;
import encheres.backoffice.repository.NbMiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class StatistiqueService {
    @Autowired
    AvgMiseRepository avgMiseRepository;
    @Autowired
    NbMiseRepository nbMiseRepository;
    @Autowired
    NbEncheresRepository nbEncheresRepository;

    public HashMap<String, Iterable<?>> getStatistiques(){
        HashMap<String, Iterable<?>> map=new HashMap<>();
        map.put("avgmise",avgMiseRepository.findAll());
        map.put("nbmise",nbMiseRepository.findAll());
        map.put("nbencheres",nbEncheresRepository.findAll());
        return map;
    }

    public List<NbMise> getStatNbMises(){
        List<NbMise> list=new ArrayList<>();
        nbMiseRepository.findAll().forEach(list::add);
        return list;
    }

    public List<AvgMise> getStatAvgMises(){
        List<AvgMise> list=new ArrayList<>();
        avgMiseRepository.findAll().forEach(list::add);
        return list;
    }

    public List<NbEncheres> getStatNbEncheres(){
        List<NbEncheres> list=new ArrayList<>();
        nbEncheresRepository.findAll().forEach(list::add);
        return list;
    }
}
