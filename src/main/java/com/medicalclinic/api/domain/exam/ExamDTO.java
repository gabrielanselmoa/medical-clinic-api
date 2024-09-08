package com.medicalclinic.api.domain.exam;

public class ExamDTO {

    private Long id;
    private String name;
    private String type;

    public ExamDTO(){}

    public ExamDTO(Long id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }
    public ExamDTO(Exam exam) {
        this.id = exam.getId();
        this.name = exam.getName();
        this.type = exam.getType();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
