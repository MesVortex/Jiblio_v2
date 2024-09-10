package presentation;

import DAO.impl.LivreDAOImpl;
import metier.Model.Bibliotheque;
import metier.Model.Livre;
import metier.Model.Magazine;
import utilitaire.DateUtils;
import utilitaire.Validation;

import java.util.Scanner;
import java.util.UUID;

public class ConsoleUI {
    public ConsoleUI() {
        while (true) {
            this.mainMenu();
            Bibliotheque biblio = new Bibliotheque();
            Scanner input = new Scanner(System.in);
            int choix = input.nextInt();
            switch (choix) {
                case 1 -> {
                    this.typeMenu("Ajouter");
                    int ajouterType = input.nextInt();
                    this.documentType(ajouterType, "ajouter");
                }
                case 2 -> {
                    this.typeMenu("Modifier");
                    int modifierType = input.nextInt();
                    this.documentType(modifierType, "modifier");
                }
                case 3 -> {
                    this.typeMenu("Supprimer");
                    int supprimerType = input.nextInt();
                    this.documentType(supprimerType, "supprimer");
                }
                case 4 -> {
                    this.typeMenu("Emprunter");
                    int emprunterType = input.nextInt();
                    this.documentType(emprunterType, "emprunter");
                }
                case 5 -> {
                    this.typeMenu("Retourner");
                    int retournerType = input.nextInt();
                    this.documentType(retournerType, "retourner");
                }
                case 6 -> {
                    biblio.showAllDocuments();
                }
                case 7 -> {
                    System.out.print("donner le titre du document a rechercher: ");
                    input.nextLine();
                    String titre = input.nextLine();
                    biblio.rechercher(titre);
                }
                default -> {
                    return;
                }
            }
        }
    }

    public void mainMenu() {
        System.out.println("1.Ajouter un document");
        System.out.println("2.Modifier un document");
        System.out.println("3.Supprimer un document");
        System.out.println("4.Emprunter un document");
        System.out.println("5.Retourner un document");
        System.out.println("6.Afficher tous les documents");
        System.out.println("7.Rechercher un document");
        System.out.println("0.Quitter");
        System.out.print("=> ");
    }

    public void typeMenu(String action) {
        System.out.println("1." + action + " un Livre");
        System.out.println("2." + action + " un Magazine");
        System.out.print("=> ");
    }

    public void addMenu(String type) {
        Scanner input = new Scanner(System.in);
        Bibliotheque biblio = new Bibliotheque();

        if (type.equals("livre")) {
            Livre livre = new Livre();

            String titre = this.getStringInput(input, "1.titre du livre: ");
            livre.setTitre(titre);

            int isbn = this.getIntInput(input, "2.ISBN: ");
            livre.setISBN(isbn);

            String auteur = this.getStringInput(input, "3.nom de l'auteur: ");
            livre.setAuteur(auteur);

            String date = this.getDateInput(input, "4.date de publication: ");
            livre.setDatePublication(date);

            int nombreDePages = this.getIntInput(input, "5.nombre de pages: ");
            livre.setNombreDePages(nombreDePages);

            livre.setId(UUID.randomUUID());

            biblio.ajouter(livre);
        } else {
            Magazine magazine = new Magazine();

            String titre = this.getStringInput(input, "1.titre du magazine: ");
            magazine.setTitre(titre);

            int numero = this.getIntInput(input, "2.numero du magazine: ");
            magazine.setNumero(numero);

            String auteur = this.getStringInput(input, "3.nom de l'auteur: ");
            magazine.setAuteur(auteur);

            String date = this.getDateInput(input, "4.date de publication: ");
            magazine.setDatePublication(date);

            int nombreDePages = this.getIntInput(input, "5.nombre de pages: ");
            magazine.setNombreDePages(nombreDePages);

            magazine.setId(UUID.randomUUID());

            biblio.ajouter(magazine);
        }
    }

    public void editMenu(Livre livre, Scanner input) {
        Bibliotheque biblio = new Bibliotheque();

        System.out.println("(old book title: " + livre.getTitre() + ")");
        input.nextLine();
        String titre = this.getStringInput(input, "new book title: ");
        livre.setTitre(titre);

        System.out.println("(old ISBN: " + livre.getISBN() + ")");
        int isbn = this.getIntInput(input, "new ISBN: ");
        livre.setISBN(isbn);

        System.out.println("(old author name: " + livre.getAuteur() + ")");
        String auteur = this.getStringInput(input, "new author name: ");
        livre.setAuteur(auteur);

        System.out.println("(old publish date: " + livre.getDatePublication() + ")");
        String date = this.getDateInput(input, "4.new publish date: ");
        livre.setDatePublication(date);

        System.out.println("(old number of pages: " + livre.getNombreDePages() + ")");
        int nombreDePages = this.getIntInput(input, "new number of pages: ");
        livre.setNombreDePages(nombreDePages);

        biblio.updateDocument(livre);
    }

    public void editMenu(Magazine magazine, Scanner input) {
        Bibliotheque biblio = new Bibliotheque();

        System.out.println("(old magazine title: " + magazine.getTitre() + ")");
        input.nextLine();
        String titre = this.getStringInput(input, "new magazine title: ");
        magazine.setTitre(titre);

        System.out.println("(old Numero: " + magazine.getNumero() + ")");
        int isbn = this.getIntInput(input, "new Numero: ");
        magazine.setNumero(isbn);

        System.out.println("(old author name: " + magazine.getAuteur() + ")");
        String auteur = this.getStringInput(input, "new author name: ");
        magazine.setAuteur(auteur);

        System.out.println("(old publish date: " + magazine.getDatePublication() + ")");
        String date = this.getDateInput(input, "4.new publish date: ");
        magazine.setDatePublication(date);

        System.out.println("(old number of pages: " + magazine.getNombreDePages() + ")");
        int nombreDePages = this.getIntInput(input, "new number of pages: ");
        magazine.setNombreDePages(nombreDePages);

        biblio.updateDocument(magazine);
    }

    public void deleteMenu(String type , Scanner scan , UUID id) {
        System.out.println("Are u sure u want to delete this Document? (yes/no)");
        System.out.print("=>");
        String answer = scan.nextLine();
        if (answer.equals("yes")){
            Bibliotheque biblio = new Bibliotheque();
            biblio.deleteDocument(type, id);
        }
    }

    public void documentType(int docType, String operation) {
        Scanner input = new Scanner(System.in);
        Bibliotheque biblio = new Bibliotheque();
        if (operation.equals("ajouter")) {
            switch (docType) {
                case 1:
                    this.addMenu("livre");
                    break;
                case 2:
                    this.addMenu("magazine");
                    break;
            }
        } else if (operation.equals("emprunter")) {
            switch (docType) {
                case 1:
                    System.out.print("donner le titre du livre a emprunter: ");
                    String livreTitre = input.nextLine();
                    biblio.emprunter(livreTitre, "livre");
                    break;
                case 2:
                    System.out.print("donner le titre du magazine a emprunter: ");
                    String magTitre = input.nextLine();
                    biblio.emprunter(magTitre, "magazine");
                    break;
            }
        } else if (operation.equals("retourner")) {
            switch (docType) {
                case 1:
                    System.out.print("donner le titre du livre a retourner: ");
                    String livreTitre = input.nextLine();
                    biblio.retourner(livreTitre, "livre");
                    break;
                case 2:
                    System.out.print("donner le titre du magazine a retourner: ");
                    String magTitre = input.nextLine();
                    biblio.retourner(magTitre, "magazine");
                    break;
            }
        } else if (operation.equals("modifier")) {
            switch (docType) {
                case 1 ->{
                    biblio.showAllBooks();
                    System.out.print("Enter the book ID to Modify: ");
                    try {
                        String idString = input.nextLine();
                        UUID bookID = UUID.fromString(idString);
                        Livre oldbook = biblio.getBook(bookID);
                        this.editMenu(oldbook, input);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid UUID format. Please enter a valid UUID.");
                    }
                }

                case 2 ->{
                    biblio.showAllMagazines();
                    System.out.print("Enter the magazine ID to Modify: ");
                    try {
                        String idString = input.nextLine();
                        UUID magazineID = UUID.fromString(idString);
                        Magazine oldMagazine = biblio.getMagazine(magazineID);
                        this.editMenu(oldMagazine, input);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid UUID format. Please enter a valid UUID.");
                    }
                }
            }
        } else if (operation.equals("supprimer")) {
            switch (docType) {
                case 1->{
                    biblio.showAllBooks();
                    System.out.print("Enter the book ID to delete: ");
                    try {
                        String idString = input.nextLine();
                        UUID bookID = UUID.fromString(idString);
                        this.deleteMenu("livre", input, bookID);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid UUID format. Please enter a valid UUID.");
                    }
                }
                case 2-> {
                    biblio.showAllMagazines();
                    System.out.print("Enter the magazine ID to delete: ");
                    try {
                        String idString = input.nextLine();
                        UUID magazineID = UUID.fromString(idString);
                        this.deleteMenu("magazine", input, magazineID);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid UUID format. Please enter a valid UUID.");
                    }
                }
            }
        }
    }

    public String getDateInput(Scanner scan, String message) {
        String date;
        while (true) {
            System.out.print(message);
            date = scan.nextLine();
            if (DateUtils.isValidDate(date)) {
                break;
            } else {
                System.out.println("Format de date invalide. Veuillez entrer une date au format dd/MM/yyyy.");
            }
        }
        return date;
    }

    public int getIntInput(Scanner scan, String message) {
        int number;
        while (true) {
            System.out.print(message);
            if (scan.hasNextInt()) {
                number = scan.nextInt();
                scan.nextLine();
                break;
            } else {
                System.out.println("Entrée invalide. Veuillez entrer un nombre entier.");
                scan.next();
            }
        }
        return number;
    }

    public String getStringInput(Scanner scan, String message) {
        String name;
        while (true) {
            System.out.print(message);
            name = scan.nextLine();
            if (Validation.isValidName(name)) {
                break;
            } else {
                System.out.println("Entrée invalide!");
            }
        }
        return name;
    }

}
