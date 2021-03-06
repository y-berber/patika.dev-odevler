package AdventureGame;
//import java.util.ArrayList;
//import java.util.List;
import java.util.HashSet;
import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);

    public static HashSet<String> territoriesWon = new HashSet<>();

    public void start(){
    	territoriesWon.add("Test");
        boolean control=false;
        System.out.print("Lütfen Bir İsim Giriniz : ");
        String playerName=input.nextLine();

        Player player = new Player(playerName);

        System.out.println("Karanlık ormanların , dipsiz kuyuların Mekanı"+" Orta Dünya`ya "+" Hoşgeldin ! "+player.getName());

        System.out.println("Orta Dünya`da Yenilmez Olmak İstiyorsan Önce Bir Karakterin Olmalı !");
        System.out.println("Hadi O Zaman Bir Karakter Seç");
        player.selectChar();

        while (true) {
            player.printInfo();
            Location location = null;
            Location[] locations = {new SafeHouse(player), new ToolStore(player), new Cave(player), new Forest(player), new River(player),new Mine(player)};

            System.out.println("\n------------------Bölge Listesi------------------------------------------------\n");
            System.out.println("0-) Çıkış --> Savaştan Kaçmak Mı İstiyorsun ? Görüşürüz Korkak \n");
            for (Location lct : locations) {
                System.out.println(lct.getId() + "-) " + lct.getName() + " --> " + lct.getDescription());
                System.out.println();
            }

            System.out.println("\nGücünün Yetmediği Bölgelere Girmeye Çalışırsan  Orta Dünya Kuşlarına Yem Olursun !");
            System.out.println("\n-------------------------------------------------------------------------------");

            System.out.print("\nBölge Seçiminiz : ");
            int selectLocation = input.nextInt();

            System.out.println();

            for (String x:territoriesWon) {
                if (x!=null) {
                    if (x.equals("Mağara") && selectLocation == 3) control = true;
                    else if (x.equals("Nehir") && selectLocation == 5) control = true;
                    else if (x.equals("Orman") && selectLocation == 4) control = true;
                    else if (x.equals("Maden") && selectLocation == 6) control = true;
                }
            }
            if (control!=true) {
                switch (selectLocation) {
                    case 0: location = null;break;
                    case 1: location = new SafeHouse(player);break;
                    case 2: location = new ToolStore(player);break;
                    case 3: location = new Cave(player);break;
                    case 4: location = new Forest(player);break;
                    case 5: location = new River(player);break;
                    case 6: location = new Mine(player);break;
                    default: location = new SafeHouse(player);break;
                }
                 if (location == null) {
                    System.out.println("\nDemek Kaçıyorsun  Orta Dünya  Seni Bekliyor Olucak ..."); break;
                 }

                 if (!location.onLocation()) {
                    System.out.println("GAME OVER !");break;
                }
           }
            else System.out.println("Bu Bölge Zaten Kazanıldı !");

            control=false;
        }
    }
}