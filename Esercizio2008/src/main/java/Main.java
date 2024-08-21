public class Main {
    public static void main(String[] args) {

        Persona persona = new Persona("Mario", "Rossi", "mario.rossi@example.com", LocalDate.of(1990, 5, 15));
        PersonaDAO personaDAO = new PersonaDAO();
        personaDAO.save(persona);

        Location location = new Location("Milano");
        LocationDAO locationDAO = new LocationDAO();
        locationDAO.save(location);

        Evento evento = new Evento("Evento di prova", LocalDateTime.now(), "Descrizione dell'evento", TipoEvento.PUBBLICO, 100);
        evento.setLocation(location);

        Partecipazione partecipazione = new Partecipazione(persona, evento, "Partecipo");
        evento.getPartecipazioni().add(partecipazione);

        EventoDAO eventoDAO = new EventoDAO();
        eventoDAO.save(evento);
    }
}