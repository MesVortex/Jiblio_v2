package presentation;

import metier.Model.*;
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
                case 9 -> {
                    this.typeMenu("Reserver");
                    int reserverType = input.nextInt();
                    this.documentType(reserverType, "reserver");
                }
                case 10 -> {
                    this.typeMenu("Annuler reservation pour");
                    int reserverType = input.nextInt();
                    this.documentType(reserverType, "annuler reservation");
                }
                case 7 -> {
                    System.out.print("donner le titre du document a rechercher: ");
                    input.nextLine();
                    String titre = input.nextLine();
                    biblio.rechercher(titre);
                }
                case 8 -> {
                    this.userMenu();
                    int userAction = input.nextInt();
                    switch (userAction) {
                        case 1 -> {
                            this.userTypeMenu("Ajouter");
                            int ajouterType = input.nextInt();
                            this.userType(ajouterType, "ajouter");
                        }
                        case 2 -> {
                            this.userTypeMenu("Modifier");
                            int modifierType = input.nextInt();
                            this.userType(modifierType, "modifier");
                        }
                        case 3 -> {
                            this.userTypeMenu("Suprrimer");
                            int supprimerType = input.nextInt();
                            this.userType(supprimerType, "supprimer");
                        }
                    }
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
        System.out.println("8.Gere les utilisateurs");
        System.out.println("9.Reserver un document");
        System.out.println("10.Annuler reservation d'un document");
        System.out.println("0.Quitter");
        System.out.print("=> ");
    }

    public void userMenu() {
        System.out.println("1.Ajouter un utilisateur");
        System.out.println("2.Modifier un utilisateur");
        System.out.println("3.Supprimer un utilisateur");
        System.out.print("=> ");
    }

    public void typeMenu(String action) {
        System.out.println("1." + action + " un Livre");
        System.out.println("2." + action + " un Magazine");
        System.out.println("3." + action + " une journal Scientifique");
        System.out.println("4." + action + " une These Universitaire");
        System.out.print("=> ");
    }

    public void userTypeMenu(String action) {
        System.out.println("1." + action + " un Etudiant");
        System.out.println("2." + action + " un Professeur");
        System.out.print("=> ");
    }

    public void addMenu(String type) {
        Scanner input = new Scanner(System.in);
        Bibliotheque biblio = new Bibliotheque();

        switch (type) {
            case "livre" -> {
                Livre livre = new Livre();

                String titre = this.getStringInput(input, "1.titre du livre: ");
                livre.setTitre(titre);

                int isbn = this.getIntInput(input, "2.ISBN: ");
                livre.setISBN(isbn);

                String auteur = this.getStringInput(input, "3.nom de l'auteur: ");
                livre.setAuteur(auteur);

                String date = getDateInput(input, "4.date de publication: ");
                livre.setDatePublication(date);

                int nombreDePages = this.getIntInput(input, "5.nombre de pages: ");
                livre.setNombreDePages(nombreDePages);

                livre.setId(UUID.randomUUID());

                biblio.ajouter(livre);
            }
            case "magazine" -> {
                Magazine magazine = new Magazine();

                String titre = this.getStringInput(input, "1.titre du magazine: ");
                magazine.setTitre(titre);

                int numero = this.getIntInput(input, "2.numero du magazine: ");
                magazine.setNumero(numero);

                String auteur = this.getStringInput(input, "3.nom de l'auteur: ");
                magazine.setAuteur(auteur);

                String date = getDateInput(input, "4.date de publication: ");
                magazine.setDatePublication(date);

                int nombreDePages = this.getIntInput(input, "5.nombre de pages: ");
                magazine.setNombreDePages(nombreDePages);

                magazine.setId(UUID.randomUUID());

                biblio.ajouter(magazine);
            }
            case "journal" -> {
                JournalScientifique journal = new JournalScientifique();

                String titre = this.getStringInput(input, "1.titre du journal: ");
                journal.setTitre(titre);

                String auteur = this.getStringInput(input, "2.nom de l'auteur: ");
                journal.setAuteur(auteur);

                String domaineRecherche = this.getStringInput(input, "3.domaine de recherche: ");
                journal.setDomaineRecherche(domaineRecherche);

                String date = getDateInput(input, "4.date de publication: ");
                journal.setDatePublication(date);

                int nombreDePages = this.getIntInput(input, "5.nombre de pages: ");
                journal.setNombreDePages(nombreDePages);

                journal.setId(UUID.randomUUID());

                biblio.ajouter(journal);
            }
            case "these" -> {
                TheseUniversitaire these = new TheseUniversitaire();

                String titre = this.getStringInput(input, "1.titre du these: ");
                these.setTitre(titre);

                String auteur = this.getStringInput(input, "2.nom de l'auteur: ");
                these.setAuteur(auteur);

                String domaine = this.getStringInput(input, "3.domaine: ");
                these.setDomaine(domaine);

                String universite = this.getStringInput(input, "4.universite: ");
                these.setUniversite(universite);

                String date = getDateInput(input, "5.date de publication: ");
                these.setDatePublication(date);

                int nombreDePages = this.getIntInput(input, "6.nombre de pages: ");
                these.setNombreDePages(nombreDePages);

                these.setId(UUID.randomUUID());

                biblio.ajouter(these);
            }
            case "etudiant" -> {
                Etudiant etudiant = new Etudiant();

                String username = this.getStringInput(input, "1.nom d'etudiant: ");
                etudiant.setUsername(username);

                String email = this.getStringInput(input, "3.email: ");
                etudiant.setEmail(email);

                String password = this.getStringInput(input, "3.password: ");
                etudiant.setPassword(password);

                String filiere = this.getStringInput(input, "4.filiere_etudes: ");
                etudiant.setFiliere_etudes(filiere);

                etudiant.setId(UUID.randomUUID());

                biblio.ajouter(etudiant);
            }
            case "professeur" -> {
                Professeur professeur = new Professeur();

                String username = this.getStringInput(input, "1.nom du professeur: ");
                professeur.setUsername(username);

                String email = this.getStringInput(input, "3.email: ");
                professeur.setEmail(email);

                String password = this.getStringInput(input, "3.password: ");
                professeur.setPassword(password);

                String filiere = this.getStringInput(input, "4.module_enseigne: ");
                professeur.setModele_enseigne(filiere);

                professeur.setId(UUID.randomUUID());

                biblio.ajouter(professeur);
            }
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
        String date = getDateInput(input, "4.new publish date: ");
        livre.setDatePublication(date);

        System.out.println("(old number of pages: " + livre.getNombreDePages() + ")");
        int nombreDePages = this.getIntInput(input, "new number of pages: ");
        livre.setNombreDePages(nombreDePages);

        biblio.updateDocument(livre);
    }

    public void editMenu(Magazine magazine, Scanner input) {
        Bibliotheque biblio = new Bibliotheque();

        System.out.println("(old magazine title: " + magazine.getTitre() + ")");
        String titre = this.getStringInput(input, "new magazine title: ");
        magazine.setTitre(titre);

        System.out.println("(old Numero: " + magazine.getNumero() + ")");
        int isbn = this.getIntInput(input, "new Numero: ");
        magazine.setNumero(isbn);

        System.out.println("(old author name: " + magazine.getAuteur() + ")");
        String auteur = this.getStringInput(input, "new author name: ");
        magazine.setAuteur(auteur);

        System.out.println("(old publish date: " + magazine.getDatePublication() + ")");
        String date = getDateInput(input, "4.new publish date: ");
        magazine.setDatePublication(date);

        System.out.println("(old number of pages: " + magazine.getNombreDePages() + ")");
        int nombreDePages = this.getIntInput(input, "new number of pages: ");
        magazine.setNombreDePages(nombreDePages);

        biblio.updateDocument(magazine);
    }

    public void editMenu(JournalScientifique journal, Scanner input) {
        Bibliotheque biblio = new Bibliotheque();

        System.out.println("(old journal title: " + journal.getTitre() + ")");
        String titre = this.getStringInput(input, "new journal title: ");
        journal.setTitre(titre);

        System.out.println("(old research domain: " + journal.getDomaineRecherche() + ")");
        String domaineRecherche = this.getStringInput(input, "new research domain: ");
        journal.setDomaineRecherche(domaineRecherche);

        System.out.println("(old author name: " + journal.getAuteur() + ")");
        String auteur = this.getStringInput(input, "new author name: ");
        journal.setAuteur(auteur);

        System.out.println("(old publish date: " + journal.getDatePublication() + ")");
        String date = getDateInput(input, "4.new publish date: ");
        journal.setDatePublication(date);

        System.out.println("(old number of pages: " + journal.getNombreDePages() + ")");
        int nombreDePages = this.getIntInput(input, "new number of pages: ");
        journal.setNombreDePages(nombreDePages);

        biblio.updateDocument(journal);
    }

    public void editMenu(TheseUniversitaire these, Scanner input) {
        Bibliotheque biblio = new Bibliotheque();

        System.out.println("(old these title: " + these.getTitre() + ")");
        String titre = getStringInput(input, "new these title: ");
        these.setTitre(titre);

        System.out.println("(old domain: " + these.getDomaine() + ")");
        String domaine = getStringInput(input, "new domain: ");
        these.setDomaine(domaine);

        System.out.println("(old university: " + these.getUniversite() + ")");
        String universite = getStringInput(input, "new university: ");
        these.setUniversite(universite);

        System.out.println("(old author name: " + these.getAuteur() + ")");
        String auteur = getStringInput(input, "new author name: ");
        these.setAuteur(auteur);

        System.out.println("(old publish date: " + these.getDatePublication() + ")");
        String date = getDateInput(input, "4.new publish date: ");
        these.setDatePublication(date);

        System.out.println("(old number of pages: " + these.getNombreDePages() + ")");
        int nombreDePages = this.getIntInput(input, "new number of pages: ");
        these.setNombreDePages(nombreDePages);

        biblio.updateDocument(these);
    }

    public void editMenu(Etudiant etudiant, Scanner input) {
        Bibliotheque biblio = new Bibliotheque();

        System.out.println("(old username: " + etudiant.getUsername() + ")");
        String username = this.getStringInput(input, "new username: ");
        etudiant.setUsername(username);

        System.out.println("(old email: " + etudiant.getEmail() + ")");
        String email = this.getStringInput(input, "new email: ");
        etudiant.setEmail(email);

        System.out.println("(old password: " + etudiant.getPassword() + ")");
        String password = this.getStringInput(input, "new password: ");
        etudiant.setPassword(password);

        biblio.updateUser(etudiant);
    }

    public void editMenu(Professeur professeur, Scanner input) {
        Bibliotheque biblio = new Bibliotheque();

        System.out.println("(old username: " + professeur.getUsername() + ")");
        String username = this.getStringInput(input, "new username: ");
        professeur.setUsername(username);

        System.out.println("(old email: " + professeur.getEmail() + ")");
        String email = this.getStringInput(input, "new email: ");
        professeur.setEmail(email);

        System.out.println("(old password: " + professeur.getPassword() + ")");
        String password = this.getStringInput(input, "new password: ");
        professeur.setPassword(password);

        biblio.updateUser(professeur);
    }

    public void deleteMenu(String type, Scanner scan, UUID id) {
        System.out.println("Are u sure u want to delete this Document? (yes/no)");
        System.out.print("=>");
        String answer = scan.nextLine();
        if (answer.equals("yes")) {
            Bibliotheque biblio = new Bibliotheque();
            biblio.deleteDocument(type, id);
        }
    }

    public void deleteUserMenu(String type, Scanner scan, UUID id) {
        System.out.println("Are u sure u want to delete this User? (yes/no)");
        System.out.print("=>");
        String answer = scan.nextLine();
        if (answer.equals("yes")) {
            Bibliotheque biblio = new Bibliotheque();
            biblio.deleteUser(type, id);
        }
    }

    public void documentType(int docType, String operation) {
        Scanner input = new Scanner(System.in);
        Bibliotheque biblio = new Bibliotheque();
        if (operation.equals("ajouter")) {
            switch (docType) {
                case 1 -> {
                    this.addMenu("livre");
                }
                case 2 -> {
                    this.addMenu("magazine");
                }
                case 3 -> {
                    this.addMenu("journal");
                }
                case 4 -> {
                    this.addMenu("these");
                }
            }
        } else if (operation.equals("emprunter")) {
            switch (docType) {
                case 1 -> {
                    biblio.showAllBooks();
                    biblio.borrow("livre", input);
                }
                case 2 -> {
                    biblio.showAllMagazines();
                    biblio.borrow("magazine", input);
                }
                case 3 -> {
                    biblio.showAllJournals();
                    biblio.borrow("journal", input);
                }
                case 4 -> {
                    biblio.showAllTheses();
                    biblio.borrow("these", input);
                }
            }
        } else if (operation.equals("retourner")) {
            switch (docType) {
                case 1 -> {
                    biblio.showAllBooks();
                    biblio.retourner("livre", input);
                }
                case 2 -> {
                    biblio.showAllMagazines();
                    biblio.retourner("magazine", input);
                }
                case 3 -> {
                    biblio.showAllJournals();
                    biblio.retourner("journal", input);
                }
                case 4 -> {
                    biblio.showAllTheses();
                    biblio.retourner("these", input);
                }
            }
        } else if (operation.equals("modifier")) {
            switch (docType) {
                case 1 -> {
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
                case 2 -> {
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
                case 3 -> {
                    biblio.showAllJournals();
                    System.out.print("Enter the journal ID to Modify: ");
                    try {
                        String idString = input.nextLine();
                        UUID journalID = UUID.fromString(idString);
                        JournalScientifique oldJournal = biblio.getJournal(journalID);
                        this.editMenu(oldJournal, input);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid UUID format. Please enter a valid UUID.");
                    }
                }
                case 4 -> {
                    biblio.showAllTheses();
                    System.out.print("Enter the these ID to Modify: ");
                    try {
                        String idString = input.nextLine();
                        UUID theseID = UUID.fromString(idString);
                        TheseUniversitaire oldThese = biblio.getThese(theseID);
                        this.editMenu(oldThese, input);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid UUID format. Please enter a valid UUID.");
                    }
                }
            }
        } else if (operation.equals("supprimer")) {
            switch (docType) {
                case 1 -> {
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
                case 2 -> {
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
                case 3 -> {
                    biblio.showAllJournals();
                    System.out.print("Enter the journal ID to delete: ");
                    try {
                        String idString = input.nextLine();
                        UUID journalID = UUID.fromString(idString);
                        this.deleteMenu("journal", input, journalID);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid UUID format. Please enter a valid UUID.");
                    }
                }
                case 4 -> {
                    biblio.showAllTheses();
                    System.out.print("Enter the these ID to delete: ");
                    try {
                        String idString = input.nextLine();
                        UUID theseID = UUID.fromString(idString);
                        this.deleteMenu("these", input, theseID);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid UUID format. Please enter a valid UUID.");
                    }
                }
            }
        } else if (operation.equals("reserver")) {
            switch (docType) {
                case 1 -> {
                    biblio.showAllBooks();
                    biblio.reserver("livre", input);
                }
                case 2 -> {
                    biblio.showAllMagazines();
                    biblio.reserver("magazine", input);
                }
                case 3 -> {
                    biblio.showAllJournals();
                    biblio.reserver("journal", input);
                }
                case 4 -> {
                    biblio.showAllTheses();
                    biblio.reserver("these", input);
                }
            }
        } else {
            switch (docType) {
                case 1 -> {
                    biblio.showAllBooks();
                    biblio.annulerReservation("livre", input);
                }
                case 2 -> {
                    biblio.showAllMagazines();
                    biblio.annulerReservation("magazine", input);
                }
                case 3 -> {
                    biblio.showAllJournals();
                    biblio.annulerReservation("journal", input);
                }
                case 4 -> {
                    biblio.showAllTheses();
                    biblio.annulerReservation("these", input);
                }
            }
        }
    }

    public void userType(int userType, String operation) {
        Scanner input = new Scanner(System.in);
        Bibliotheque biblio = new Bibliotheque();
        switch (operation) {
            case "ajouter" -> {
                switch (userType) {
                    case 1 -> {
                        this.addMenu("etudiant");
                    }
                    case 2 -> {
                        this.addMenu("professeur");
                    }
                }
            }
            case "modifier" -> {
                switch (userType) {
                    case 1 -> {
                        biblio.showAllEtudiant();
                        System.out.print("Enter the student ID to Modify: ");
                        try {
                            String idString = input.nextLine();
                            UUID etudiantID = UUID.fromString(idString);
                            Etudiant oldEtudiant = biblio.getEtudiant(etudiantID);
                            this.editMenu(oldEtudiant, input);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Invalid UUID format. Please enter a valid UUID.");
                        }
                    }
                    case 2 -> {
                        biblio.showAllTeachers();
                        System.out.print("Enter the teacher ID to Modify: ");
                        try {
                            String idString = input.nextLine();
                            UUID teacherID = UUID.fromString(idString);
                            Professeur oldTeacher = biblio.getProfesseur(teacherID);
                            this.editMenu(oldTeacher, input);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Invalid UUID format. Please enter a valid UUID.");
                        }
                    }
                }
            }
            case "supprimer" -> {
                switch (userType) {
                    case 1 -> {
                        biblio.showAllEtudiant();
                        System.out.print("Enter the student ID to delete: ");
                        try {
                            String idString = input.nextLine();
                            UUID etudiantID = UUID.fromString(idString);
                            this.deleteUserMenu("etudiant", input, etudiantID);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Invalid UUID format. Please enter a valid UUID.");
                        }
                    }
                    case 2 -> {
                        biblio.showAllTeachers();
                        System.out.print("Enter the teacher ID to delete: ");
                        try {
                            String idString = input.nextLine();
                            UUID teacherID = UUID.fromString(idString);
                            this.deleteUserMenu("professeur", input, teacherID);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Invalid UUID format. Please enter a valid UUID.");
                        }
                    }
                }
            }
        }
    }

    public static String getDateInput(Scanner scan, String message) {
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
