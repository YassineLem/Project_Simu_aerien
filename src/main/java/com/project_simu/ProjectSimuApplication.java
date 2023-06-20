package com.project_simu;

import com.project_simu.Controller.VolController;
import com.project_simu.Data.VolData;
import com.project_simu.Dijiksta.DijikstraImp;
import com.project_simu.entity.Aeroport;
import com.project_simu.entity.Avion;
import com.project_simu.entity.Avion_type;
import com.project_simu.entity.Vol;
import com.project_simu.repository.AeroportRepository;
import com.project_simu.repository.AvionRepository;
import com.project_simu.repository.VolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.*;

import static com.project_simu.Controller.VolController.*;
import static java.time.LocalDate.*;

@SpringBootApplication
public class ProjectSimuApplication {

    public static void main(String[] args) {

        ApplicationContext ctx=SpringApplication.run(ProjectSimuApplication.class, args);
        String a="      _                 _       _   _                   _                        _             _                                   _            \n" +
                "     (_)               | |     | | (_)                 | |                      | |           | |                                 (_)           \n" +
                "  ___ _ _ __ ___  _   _| | __ _| |_ _  ___  _ __     __| | ___    ___ ___  _ __ | |_ _ __ ___ | | ___ _   _ _ __    __ _  ___ _ __ _  ___ _ __  \n" +
                " / __| | '_ ` _ \\| | | | |/ _` | __| |/ _ \\| '_ \\   / _` |/ _ \\  / __/ _ \\| '_ \\| __| '__/ _ \\| |/ _ \\ | | | '__|  / _` |/ _ \\ '__| |/ _ \\ '_ \\ \n" +
                " \\__ \\ | | | | | | |_| | | (_| | |_| | (_) | | | | | (_| |  __/ | (_| (_) | | | | |_| | | (_) | |  __/ |_| | |    | (_| |  __/ |  | |  __/ | | |\n" +
                " |___/_|_| |_| |_|\\__,_|_|\\__,_|\\__|_|\\___/|_| |_|  \\__,_|\\___|  \\___\\___/|_| |_|\\__|_|  \\___/|_|\\___|\\__,_|_|     \\__,_|\\___|_|  |_|\\___|_| |_|";

        int i = 0;
        DijikstraImp dijisktra=ctx.getBean(DijikstraImp.class);
        VolController volController=ctx.getBean(VolController.class);
        VolRepository VolRepository=ctx.getBean(VolRepository.class);
        AeroportRepository AeroportRepository=ctx.getBean(AeroportRepository.class);
        AvionRepository AvionRepository=ctx.getBean(AvionRepository.class);
//        Avion avionA=new Avion("Airbus A380", Avion_type.LONG,8,1000);//12500
//        Avion avionB=new Avion("Boeing 747",Avion_type.COURT,7,500);//7142
//        Avion avionC=new Avion("Boeing 777",Avion_type.MOYEN,7,800);//1142
//        Avion avionD = new Avion("Airbus A320", Avion_type.COURT, 5, 300);
//        Avion avionE = new Avion("Boeing 787", Avion_type.LONG, 8, 900);
//        Avion avionF = new Avion("Embraer E190", Avion_type.COURT, 4, 200);
//        Avion avionG = new Avion("Airbus A350", Avion_type.MOYEN, 6, 600);
//        Avion avionH = new Avion("Boeing 767", Avion_type.LONG, 7, 700);
//        Avion avionI = new Avion("Embraer E195", Avion_type.COURT, 4, 250);
//        Avion avionJ = new Avion("Airbus A330", Avion_type.MOYEN, 6, 700);
//        Avion avionK = new Avion("Boeing 737", Avion_type.COURT, 5, 400);
//        Avion avionL = new Avion("Airbus A340", Avion_type.LONG, 8, 800);
//        Avion avionM = new Avion("Embraer E175", Avion_type.COURT, 4, 180);
//        Avion avionN = new Avion("Boeing 787", Avion_type.MOYEN, 6, 650);
//        Avion avionO = new Avion("Airbus A320", Avion_type.COURT, 5, 350);
//        AvionRepository.save(avionA);
//        AvionRepository.save(avionB);
//        AvionRepository.save(avionC);
//        AvionRepository.save(avionD);
//        AvionRepository.save(avionE);
//        AvionRepository.save(avionF);
//        AvionRepository.save(avionG);
//        AvionRepository.save(avionH);
//        AvionRepository.save(avionI);
//        AvionRepository.save(avionJ);
//        AvionRepository.save(avionK);
//        AvionRepository.save(avionL);
//        AvionRepository.save(avionM);
//        AvionRepository.save(avionN);
//        AvionRepository.save(avionO);







        List<Aeroport> Aeroport=AeroportRepository.findAll();
        while (i != 5) {
            System.out.println(a);
            System.out.println("1-Créé un vol");
            System.out.println("2-afficher les vols créér");
            System.out.println("3-Afficher les avions");
            System.out.println("4-Afficher les airports");
            System.out.println("5-Demarrer la Simulation");
            Scanner scanner = new Scanner(System.in);
            i = scanner.nextInt();
            switch (i) {
                case 1:
                    System.out.println("Donner nom de vol");
                    String name=scanner.next();
                    System.out.println(name);
                    System.out.println("Donner id de aéroport de depart");
                    for (i=1;i<=Aeroport.size();i++){
                        System.out.println(Aeroport.get(i-1).getID_aeroport()+"-->"+Aeroport.get(i-1).getNom_aeroport());
                    }
                    Long deb=scanner.nextLong();
                    Aeroport Aeroport_deb=AeroportRepository.findById(deb).orElse(null);
                    System.out.println(Aeroport_deb);
                    System.out.println("Donner id de aéroport d'arrive");
                    for (i=1;i<=Aeroport.size();i++){
                        if(i!=deb)
                            System.out.println(Aeroport.get(i-1).getID_aeroport()+"-->"+Aeroport.get(i-1).getNom_aeroport());
                    }
                    Long fin=scanner.nextLong();
                    Aeroport Aeroport_fin=AeroportRepository.findById(fin).orElse(null);
                    System.out.println(Aeroport_fin);
                    System.out.println("Donner id de l'avion");
                    Avion avion=AvionRepository.findById(scanner.nextLong()).orElse(null);
                    System.out.println(avion);
                    VolData Vol=new VolData(name,Aeroport_deb,Aeroport_fin,avion);
                    dijisktra.AdjacencyMatrix();
                    LinkedList <Integer> chemin=dijisktra.dijkstra(Aeroport_deb.getID_aeroport().intValue()-1,Aeroport_fin.getID_aeroport().intValue()-1, (avion.getCapacite()*100)/avion.getConsommation());
                    if(chemin!=null){
//                        volData.getTrajectoire().add(Aeroport_deb);
//                        VolData.getTrajectoire().add(Aeroport_fin);
                        for (i = 0; i < chemin.size(); i++) {
                                Aeroport a1 = AeroportRepository.findById((long) (chemin.get(i) + 1)).orElse(null);
                                Vol.getTrajectoire().add(a1);
                            }
                        VolController.addVolData(Vol);
                        }
                    break;
                case 2:
                    System.out.println(" _ _     _         _                        _     \n" +
                            " | (_)   | |       | |                      | |    \n" +
                            " | |_ ___| |_    __| | ___  ___  __   _____ | |___ \n" +
                            " | | / __| __|  / _` |/ _ \\/ __| \\ \\ / / _ \\| / __|\n" +
                            " | | \\__ \\ |_  | (_| |  __/\\__ \\  \\ V / (_) | \\__ \\\n" +
                            " |_|_|___/\\__|  \\__,_|\\___||___/   \\_/ \\___/|_|___/\n" +
                            "                                                   \n" +
                            "                                                   ");
                    List<Vol> vols=VolRepository.findAll();
                    System.out.println(vols.size());
                    Iterator<Vol> iterator = vols.iterator();
                    while (iterator.hasNext()) {
                        Vol vol = iterator.next();
                        System.out.println(vol);
                        System.out.println("la distance parcourue " + vol.calculateDistance() + " KM");
                    }
                    break;
                case 3:
                    System.out.println("  _ _     _         _                         _                 \n" +
                            " | (_)   | |       | |                       (_)                \n" +
                            " | |_ ___| |_    __| | ___  ___    __ ___   ___  ___  _ __  ___ \n" +
                            " | | / __| __|  / _` |/ _ \\/ __|  / _` \\ \\ / / |/ _ \\| '_ \\/ __|\n" +
                            " | | \\__ \\ |_  | (_| |  __/\\__ \\ | (_| |\\ V /| | (_) | | | \\__ \\\n" +
                            " |_|_|___/\\__|  \\__,_|\\___||___/  \\__,_| \\_/ |_|\\___/|_| |_|___/\n" +
                            "                                                                ");
                    List<Avion> Avion=AvionRepository.findAll();
                    Iterator<Avion> iterator1 = Avion.iterator();
                    while (iterator1.hasNext()) {
                        System.out.println(iterator1.next());
                    }
                    break;
                case 4:
                    System.out.println("  _ _     _             _                     __                            _       \n" +
                            " | (_)   | |           | |                   /_/                           | |      \n" +
                            " | |_ ___| |_ ___    __| | ___  ___    __ _  ___ _ __ ___  _ __   ___  _ __| |_ ___ \n" +
                            " | | / __| __/ _ \\  / _` |/ _ \\/ __|  / _` |/ _ \\ '__/ _ \\| '_ \\ / _ \\| '__| __/ __|\n" +
                            " | | \\__ \\ ||  __/ | (_| |  __/\\__ \\ | (_| |  __/ | | (_) | |_) | (_) | |  | |_\\__ \\\n" +
                            " |_|_|___/\\__\\___|  \\__,_|\\___||___/  \\__,_|\\___|_|  \\___/| .__/ \\___/|_|   \\__|___/\n" +
                            "                                                          | |                       \n" +
                            "                                                          |_|                       ");
                    Iterator<Aeroport> iterator3 = Aeroport.iterator();
                    while (iterator3.hasNext()) {
                        System.out.println(iterator3.next());}
                    break;

            }
        }

    }
}
