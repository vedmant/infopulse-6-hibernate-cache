package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.*;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Formula;

@NamedQueries(
    @NamedQuery(
        name = "get_person_by_name",
        query = "select p from MyPerson p where name = :name"
    )
)
@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class MyPerson {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String nickName;

    @Temporal(TemporalType.TIMESTAMP )
    @Column(nullable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable=false, updatable=false)
    private Date timestamp = new Date();
    

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    @OrderColumn
    private List<MyPhone> phones = new ArrayList<>();

    @ElementCollection
    @MapKeyEnumerated(EnumType.STRING)
    private Map<AddressType, String> addresses = new HashMap<>();

    private double balance;
    
    private double sum;
    
    @Formula(value="balance*100/sum")
    private double percents;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getPercents() {
        return percents;
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public List<MyPhone> getPhones() {
        return phones;
    }

    public void setPhones(List<MyPhone> phones) {
        this.phones = phones;
    }

    public Map<AddressType, String> getAddresses() {
        return addresses;
    }

    public void setAddresses(Map<AddressType, String> addresses) {
        this.addresses = addresses;
    }
}
