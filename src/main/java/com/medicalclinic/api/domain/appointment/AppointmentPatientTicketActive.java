package com.medicalclinic.api.domain.appointment;

public class AppointmentPatientTicketActive {

    private Long id;
    private String patient;
    private String ticket;
    private String expire_in;

    public AppointmentPatientTicketActive() {
    }

    public AppointmentPatientTicketActive(Long id, String patient, String ticket, String expire_in) {
        this.id = id;
        this.patient = patient;
        this.ticket = ticket;
        this.expire_in = expire_in;
    }

    public AppointmentPatientTicketActive(Appointment ap) {
        this.id = ap.getId();
        this.patient = ap.getPatient().getName();
        this.ticket = ap.getTicket().getId().toString();
        this.expire_in = ap.getTicket().getExpireInLocal().toString();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getExpire_in() {
        return expire_in;
    }

    public void setExpire_in(String expire_in) {
        this.expire_in = expire_in;
    }
}