package org.JanuszPol;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        TechnicianTODO technicianTODO = new TechnicianTODO();
        Product tempProduct = null;
        Scanner scanner = new Scanner(System.in);
        Calendar calendar = new Calendar();
        // potrzebne
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp timeStart = null;
        Timestamp timeEnd = null;


        try{
            timeStart = new Timestamp(dateFormat.parse("2024-06-01 09:00:00").getTime());
            timeEnd = new Timestamp(dateFormat.parse("2024-06-03 18:00:00").getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }


        Manager tomek = new Manager("tomek1","123");
        UserUtility.getInstance().register(tomek);
        tomek.login();
        tomek.addProduct("koparka",20.20);
        tomek.addProduct("dźwig",23.1);
        tomek.addProduct("betoniarka",4.20);
        tomek.addProduct("buldożer",123.4, 2);

        // IMPORTANT: kiedy dodajesz produkt bez amount in stock to ustawia sie na 1 (nwm dlaczego nie dziala jak sie na 0 ustawiało, ale jak liczba ZEJDZIE do 0 to działa wtedy???)

        System.out.println(tomek.getSessionCode());

        Customer franek = new Customer("franek420","2131321");
        UserUtility.getInstance().register(franek);
        franek.login();


        franek.browseCatalog();
        System.out.println();

        technicianTODO.addProblem("test1", "test descr");


        String response = "";
        boolean running=true;
        User currentUser = null;


        while(running) {

            System.out.println("-----------MENU------------");
            System.out.println("0 - log in ");
            System.out.println("1 - show catalog [customer only]");
            System.out.println("2 - rent [customer only]");
            System.out.println("3 - report a problem [customer and manager]");
            System.out.println("4 - add product [manager only]");
            System.out.println("5 - display current problems [technician and manager only]");
            System.out.println("6 - solve problem [technician only]");
            System.out.println("7 - register");
            response = scanner.nextLine();
            switch (response) {
                case "0":
                    System.out.println("login:");
                    String login = scanner.nextLine();
                    System.out.println("password:");
                    String password = scanner.nextLine();
                    if (UserUtility.getInstance().login(login,password)!=null){
                        System.out.println("login successful");
                        currentUser = UserUtility.getInstance().getUserByLogin(login);
                    }else
                        System.out.println("login failed");
                    ;

                    break;
                case "1":
                    if (currentUser instanceof Customer) ((Customer) currentUser).browseCatalog();
                    else System.out.println("not a correct account");
                    break;
                case "2":

                    if (currentUser instanceof Customer){
                        System.out.println("provide model name: ");
                        String line = scanner.nextLine();

                        tempProduct = ProductCatalog.chooseProduct(line);

                        if(!calendar.checkIfBusy(tempProduct, timeStart, timeEnd)){
                            calendar.reserveTime(tempProduct, timeStart, timeEnd);
                            System.out.println("product successfully reserved");
                        } else {
                            // jesli zajety --> jakas wiadomosc 🕋
                            System.out.println("product not available");
                        }
                    }else System.out.println("not a correct account");


                    break;
                case "3":
                    if (currentUser instanceof Customer || currentUser instanceof Manager){
                        System.out.println("model name: ");
                        String modelName = scanner.nextLine();
                        System.out.println("provide information about the problem: ");
                        String description = scanner.nextLine();

                        technicianTODO.addProblem(modelName, description);

                        technicianTODO.displayProblems();


                    }else System.out.println("not a correct account");



                    break;
                case "4":
                    if (currentUser instanceof Manager){
                        System.out.println("name of product:");
                        String name = scanner.nextLine();
                        System.out.println("Price per day:");
                        Double price = Double.valueOf(scanner.nextLine());
                        ((Manager) currentUser).addProduct(name,price);
                    }else System.out.println("not a correct account");


                    break;
                case "5":
                    if (currentUser instanceof Technician){
                        technicianTODO.displayProblems();

                    }
                    break;
                case "6":
                    if (currentUser instanceof Technician){

                        System.out.println("problem ID: ");
                        String uuidInput = scanner.nextLine();

                        try {
                            UUID uuid = UUID.fromString(uuidInput);
                            TechnicianTODO.Problem problem = technicianTODO.getProblemById(uuid);
                            if (problem != null) {
                                System.out.println("Znaleziono problem: " + problem.getDescription());
                                technicianTODO.solveProblem(problem);
                            } else {
                                System.out.println("Nie znaleziono problemu o podanym UUID.");
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println("Wprowadzono nieprawidłowy format UUID.");
                        }


                    }else System.out.println("not a correct account");

                    break;

                case "7":
                    {
                        System.out.println("select the type of account");
                        System.out.println("1 - customer");
                        System.out.println("2 - technician");
                        System.out.println("3 - manager");

                        int choice = Integer.parseInt(response = scanner.nextLine());
                        System.out.println("Login:");
                        String tempLogin = scanner.nextLine();
                        System.out.println("Password:");
                        String tempPassword = scanner.nextLine();

                        User temp = null;
                        if (choice == 1) {
                            temp = new Customer(tempLogin,tempPassword);
                        }
                        if (choice == 1) {
                            temp = new Technician(tempLogin,tempPassword);
                        }
                        if (choice == 1) {
                            temp = new Manager(tempLogin,tempPassword);
                        }
                        UserUtility.getInstance().register(temp);

                    }
                    break;
                default:
                    running=false;
            }}


//        System.out.println(" testy tutaj : ");
//
//        Product testProduct = ProductCatalog.chooseProduct("betoniarka");
//
//
//        if(!calendar.checkIfBusy(testProduct, timeStart, timeEnd)){
//            calendar.reserveTime(testProduct, timeStart, timeEnd);
//            System.out.println("PRODUKT ZAREZERWOWANY POMYSLNIE");
//        } else {
//            // jesli zajety --> jakas wiadomosc 🕋
//            System.out.println("PRODUKT NIE JEST DOSTĘPNY W PODANYM OKRESIE CZASOWYM");
//        }
//
//        if(!calendar.checkIfBusy(testProduct, timeStart, timeEnd)){
//            calendar.reserveTime(testProduct, timeStart, timeEnd);
//            System.out.println("PRODUKT ZAREZERWOWANY POMYSLNIE");
//        } else {
//            // jesli zajety --> jakas wiadomosc 🕋
//            System.out.println("PRODUKT NIE JEST DOSTĘPNY W PODANYM OKRESIE CZASOWYM");
//        }
//        if(!calendar.checkIfBusy(testProduct, timeStart, timeEnd)){
//            calendar.reserveTime(testProduct, timeStart, timeEnd);
//            System.out.println("PRODUKT ZAREZERWOWANY POMYSLNIE");
//        } else {
//            // jesli zajety --> jakas wiadomosc 🕋
//            System.out.println("PRODUKT NIE JEST DOSTĘPNY W PODANYM OKRESIE CZASOWYM");
//        }


        } ;


    }




