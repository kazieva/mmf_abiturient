package by.epam.training.kazieva.entity;

public class Abiturient {
    private String passport_series;
    private int passport_id;
    private String fname;
    private String sname;
    private String patronymic;
    private String phone;
    private byte school_certificate;
    private byte math_certificate;
    private byte physics_certificate;
    private byte language_certificate;
    private int speciality_id;

    public Abiturient() {
    }

    public Abiturient(String passport_series, int passport_id, String fname, String sname, String patronymic, String phone, byte school_certificate, byte math_certificate, byte physics_certificate, byte language_certificate, int speciality_id) {
        this.passport_series = passport_series;
        this.passport_id = passport_id;
        this.fname = fname;
        this.sname = sname;
        this.patronymic = patronymic;
        this.phone = phone;
        this.school_certificate = school_certificate;
        this.math_certificate = math_certificate;
        this.physics_certificate = physics_certificate;
        this.language_certificate = language_certificate;
        this.speciality_id = speciality_id;
    }

    public String getPassport_series() {
        return passport_series;
    }

    public void setPassport_series(String passport_series) {
        this.passport_series = passport_series;
    }

    public int getPassport_id() {
        return passport_id;
    }

    public void setPassport_id(int passport_id) {
        this.passport_id = passport_id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public byte getSchool_certificate() {
        return school_certificate;
    }

    public void setSchool_certificate(byte school_certificate) {
        this.school_certificate = school_certificate;
    }

    public byte getMath_certificate() {
        return math_certificate;
    }

    public void setMath_certificate(byte math_certificate) {
        this.math_certificate = math_certificate;
    }

    public byte getPhysics_certificate() {
        return physics_certificate;
    }

    public void setPhysics_certificate(byte physics_certificate) {
        this.physics_certificate = physics_certificate;
    }

    public byte getLanguage_certificate() {
        return language_certificate;
    }

    public void setLanguage_certificate(byte language_certificate) {
        this.language_certificate = language_certificate;
    }

    public int getSpeciality_id() {
        return speciality_id;
    }

    public void setSpeciality_id(int speciality_id) {
        this.speciality_id = speciality_id;
    }

    @Override
    public String toString() {
        return "Abiturient{" +
                "passport_series='" + passport_series + '\'' +
                ", passport_id=" + passport_id +
                ", fname='" + fname + '\'' +
                ", sname='" + sname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", phone='" + phone + '\'' +
                ", school_certificate=" + school_certificate +
                ", math_certificate=" + math_certificate +
                ", physics_certificate=" + physics_certificate +
                ", language_certificate=" + language_certificate +
                ", speciality_id=" + speciality_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Abiturient that = (Abiturient) o;

        if (passport_id != that.passport_id) return false;
        if (!passport_series.equals(that.passport_series)) return false;
        if (!fname.equals(that.fname)) return false;
        if (!sname.equals(that.sname)) return false;
        if (patronymic != null ? !patronymic.equals(that.patronymic) : that.patronymic != null) return false;
        return phone != null ? phone.equals(that.phone) : that.phone == null;
    }

    @Override
    public int hashCode() {
        int result = passport_series.hashCode();
        result = 31 * result + passport_id;
        result = 31 * result + fname.hashCode();
        result = 31 * result + sname.hashCode();
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }
}
