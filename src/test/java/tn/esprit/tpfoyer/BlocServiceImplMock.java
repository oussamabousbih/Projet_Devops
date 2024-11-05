package tn.esprit.tpfoyer;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.repository.BlocRepository;
import tn.esprit.tpfoyer.service.BlocServiceImpl;

import java.util.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
@AllArgsConstructor
public class BlocServiceImplMock {

    @Mock
    BlocRepository blocRepository;

    @InjectMocks
    BlocServiceImpl blocService;


    Foyer f = new Foyer();
    Set<Chambre> chambres = new HashSet<Chambre>();


    Bloc bloc = new Bloc(1,"bloc a",15,f,chambres);


    List<Bloc> listBlocs = new ArrayList<Bloc>() {
        {
            add(new Bloc(2,"bloc b",20,f,chambres));
            add(new Bloc(3,"bloc c",25,f,chambres));
        }
    };


    @Test
    public void testRetrieveBloc() {
        Mockito.when(blocRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(bloc));
        Bloc bloc1 = blocService.retrieveBloc((long)5);
        Assertions.assertNotNull(bloc1);
    }


}
