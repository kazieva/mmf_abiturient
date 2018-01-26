package by.epam.training.kazieva.entity;


public class Speciality {
    private int id;
    private String speciality_name;
    private String lang;
    private int recruitment_plan;

    public Speciality() {
    }
    public Speciality(int id, String speciality_name, String lang, int recruitment_plan) {
        this.id = id;
        this.speciality_name = speciality_name;
        this.lang = lang;
        this.recruitment_plan = recruitment_plan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpeciality_name() {
        return speciality_name;
    }

    public void setSpeciality_name(String speciality_name) {
        this.speciality_name = speciality_name;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public int getRecruitment_plan() {
        return recruitment_plan;
    }

    public void setRecruitment_plan(int recruitment_plan) {
        this.recruitment_plan = recruitment_plan;
    }

    @Override
    public String toString() {
        return "Speciality{" +
                "id=" + id +
                ", speciality_name='" + speciality_name + '\'' +
                ", lang='" + lang + '\'' +
                ", recruitment_plan=" + recruitment_plan +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Speciality that = (Speciality) o;

        if (id != that.id) return false;
        if (recruitment_plan != that.recruitment_plan) return false;
        if (!speciality_name.equals(that.speciality_name)) return false;
        return lang.equals(that.lang);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + speciality_name.hashCode();
        result = 31 * result + lang.hashCode();
        result = 31 * result + recruitment_plan;
        return result;
    }
}
