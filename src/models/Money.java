package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Table(name = "moneys")
@NamedQueries({
    @NamedQuery(
            name="getMyAllMoney",
            query="SELECT m FROM Money AS m WHERE m.person = :person ORDER BY m.id DESC"
            ),
    @NamedQuery(
            name="getMyAllYear",
            query="SELECT m.year FROM Money AS m WHERE m.person = :person GROUP BY m.year"
            ),
    @NamedQuery(
            name="getMyAllMoneys",
            query="SELECT m FROM Money AS m WHERE m.person = :person AND m.year = :year ORDER BY m.id DESC"
            ),
    @NamedQuery(
            name="getMoneysSum",
            query="SELECT  SUM(m.january) + SUM(m.february) + SUM(m.march) + SUM(m.april) + SUM(m.may) + "
                    + "SUM(m.june) + SUM(m.july) + SUM(m.august) + SUM(m.september) + "
                    + "SUM(m.october) + SUM(m.november) + SUM(m.december) FROM Money m WHERE m.person = :person"
            ),
    @NamedQuery(
            name="getMoneysMonth1",
            query="SELECT SUM(m.january) FROM Money m WHERE m.person = :person AND m.delete_flag = 0 AND m.year = :year"
            ),
    @NamedQuery(
            name="getMoneysMonth2",
            query="SELECT SUM(m.february) FROM Money m WHERE m.person = :person AND m.delete_flag = 0 AND m.year = :year"
            ),
    @NamedQuery(
            name="getMoneysMonth3",
            query="SELECT SUM(m.march) FROM Money m WHERE m.person = :person AND m.delete_flag = 0 AND m.year = :year"
            ),
    @NamedQuery(
            name="getMoneysMonth4",
            query="SELECT SUM(m.april) FROM Money m WHERE m.person = :person AND m.delete_flag = 0 AND m.year = :year"
            ),
    @NamedQuery(
            name="getMoneysMonth5",
            query="SELECT SUM(m.may) FROM Money m WHERE m.person = :person AND m.delete_flag = 0 AND m.year = :year"
            ),
    @NamedQuery(
            name="getMoneysMonth6",
            query="SELECT SUM(m.june) FROM Money m WHERE m.person = :person AND m.delete_flag = 0 AND m.year = :year"
            ),
    @NamedQuery(
            name="getMoneysMonth7",
            query="SELECT SUM(m.july) FROM Money m WHERE m.person = :person AND m.delete_flag = 0 AND m.year = :year"
            ),
    @NamedQuery(
            name="getMoneysMonth8",
            query="SELECT SUM(m.august) FROM Money m WHERE m.person = :person AND m.delete_flag = 0 AND m.year = :year"
            ),
    @NamedQuery(
            name="getMoneysMonth9",
            query="SELECT SUM(m.september) FROM Money m WHERE m.person = :person AND m.delete_flag = 0 AND m.year = :year"
            ),
    @NamedQuery(
            name="getMoneysMonth10",
            query="SELECT SUM(m.october) FROM Money m WHERE m.person = :person AND m.delete_flag = 0 AND m.year = :year"
            ),
    @NamedQuery(
            name="getMoneysMonth11",
            query="SELECT SUM(m.november) FROM Money m WHERE m.person = :person AND m.delete_flag = 0 AND m.year = :year"
            ),
    @NamedQuery(
            name="getMoneysMonth12",
            query="SELECT SUM(m.december) FROM Money m WHERE m.person = :person AND m.delete_flag = 0 AND m.year = :year"
            )


})
@Entity
public class Money {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @Column(name = "company_name")
    private String company_name;

    @Column(name = "year")
    private String year;

    @Column(name = "january")
    private Integer january;

    @Column(name = "february")
    private Integer february;

    @Column(name = "march")
    private Integer march;

    @Column(name = "april")
    private Integer april;

    @Column(name = "may")
    private Integer may;

    @Column(name = "june")
    private Integer june;

    @Column(name = "july")
    private Integer july;

    @Column(name = "august")
    private Integer august;

    @Column(name = "september")
    private Integer september;

    @Column(name = "october")
    private Integer october;

    @Column(name = "november")
    private Integer november;

    @Column(name = "december")
    private Integer december;

    @Column(name = "registration")
    private Timestamp registration;

    @Column(name="delete_flag")
    private Integer delete_flag;

    @Column(name = "updated_at")
    private Timestamp updated_at;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getJanuary() {
        return january;
    }

    public void setJanuary(Integer january) {
        this.january = january;
    }

    public Integer getFebruary() {
        return february;
    }

    public void setFebruary(Integer february) {
        this.february = february;
    }

    public Integer getMarch() {
        return march;
    }

    public void setMarch(Integer march) {
        this.march = march;
    }

    public Integer getApril() {
        return april;
    }

    public void setApril(Integer april) {
        this.april = april;
    }

    public Integer getMay() {
        return may;
    }

    public void setMay(Integer may) {
        this.may = may;
    }

    public Integer getJune() {
        return june;
    }

    public void setJune(Integer june) {
        this.june = june;
    }

    public Integer getJuly() {
        return july;
    }

    public void setJuly(Integer july) {
        this.july = july;
    }

    public Integer getAugust() {
        return august;
    }

    public void setAugust(Integer august) {
        this.august = august;
    }

    public Integer getSeptember() {
        return september;
    }

    public void setSeptember(Integer september) {
        this.september = september;
    }

    public Integer getOctober() {
        return october;
    }

    public void setOctober(Integer october) {
        this.october = october;
    }

    public Integer getNovember() {
        return november;
    }

    public void setNovember(Integer november) {
        this.november = november;
    }

    public Integer getDecember() {
        return december;
    }

    public void setDecember(Integer december) {
        this.december = december;
    }

    public Timestamp getRegistration() {
        return registration;
    }

    public void setRegistration(Timestamp registration) {
        this.registration = registration;
    }

    public Integer getDelete_flag() {
        return delete_flag;
    }

    public void setDelete_flag(Integer delete_flag) {
        this.delete_flag = delete_flag;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }
}
