package Data;

import java.io.*;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Agenda implements Serializable {

    private List<Contact> contacte = new ArrayList<>();

    public Agenda() {

    }

    private Predicate<Contact> getFilter(xFiltrare xFiltru, String sText) {
        switch (xFiltru) {
            case xFiltrareNume:
                return (p) -> p.getNume().toLowerCase().contains(sText.toLowerCase());
            case xFiltrarePrenume:
                return (p) -> p.getPrenume().toLowerCase().contains(sText.toLowerCase());
            case xFiltrareTel:
                return (p) -> p.getNrTelefon().toLowerCase().contains(sText.toLowerCase());
            default:
                return (p) -> true;
        }
    }

    private Comparator<Contact> getOrdine(xOrdonare xOrdine) {
        Comparator<Contact> comp = null;
        switch (xOrdine) {
            case xOrdonareNume:
                return (p1, p2) -> p1.getNume().compareToIgnoreCase(p2.getNume());
            case xOrdonarePrenume:
                return (p1, p2) -> p1.getPrenume().compareToIgnoreCase(p2.getPrenume());
            case xOrdonareTel:
                return (p1, p2) -> p1.getNrTelefon().compareToIgnoreCase(p2.getNrTelefon());
            default:
            case xOrdonareData:
                return (p1, p2) -> p1.getDataNasterii().compareToIgnoreCase(p2.getDataNasterii());
        }
    }

    public List<Contact> getAllContacts() {
        return contacte;
    }

    public List<Contact> getContacteDeAfisat(xFiltrare xFiltru, String sText, xOrdonare xOrdine) {
        Predicate<Contact> filtru = getFilter(xFiltru, sText);
        Comparator<Contact> comp = getOrdine(xOrdine);

        List<Contact> contacteDeAfisat = contacte.stream()
                .filter(filtru)
                .sorted(comp)
                .collect(Collectors.toList());

        return contacteDeAfisat;
    }

    public boolean modificaContact(Contact cSelectat, Contact cEditat) {
        int indexContact = getIndexContact(cSelectat);
        if (indexContact >= 0) {
            contacte.set(indexContact, cEditat);
            return true;
        }
        return false;
    }

    public int getIndexContact(Contact c) {
        for (int i = 0; i < contacte.size(); i++) {
            if (contacte.get(i).getNume() == c.getNume()) {
                return i;
            } else if (contacte.get(i).getPrenume() == c.getPrenume()) {
                return i;
            } else if (contacte.get(i).getNrTelefon() == c.getNrTelefon()) {
                return i;
            } else if (contacte.get(i).getDataNasterii() == c.getDataNasterii()) {
                return i;
            }
        }
        return -1;
    }

    public boolean stergeContact(Contact contact) {
        return contacte.remove(contact);
    }

    public boolean adaugaContact(Contact cAdd) {
        contacte.add(cAdd);
        return true;
    }

    public void salveazaContacte(File selectedFile) {
        try {
            FileOutputStream fos = new FileOutputStream(selectedFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(contacte);
            System.out.println("Salvare...");
            oos.close();
            fos.close();
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }

    public List<Contact> incarcareContacte(File selectedFile) {
        try {
            FileInputStream fis = new FileInputStream(selectedFile);
            ObjectInputStream ois = new ObjectInputStream(fis);
            contacte = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException e) {
            System.out.println("IOException");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
        }
        return contacte;
    }
}
