
//domain-entity
//entity varlık demek kalıcı hale getirmek istediğimiz bilgiler demektir.biz şimdi öğrencinin bi
//bilgilerini data base de depolayıp daha sonra kullanmak istiyoruz
public class Student {


    /*genellikle entity lerimizin yani domainlerimizin fielderini oluştururken bunların
    * data tiplerini genellikleri non-primitive seçmeyi tercih ederiz çoğunlukla
    * nedeni ise eğer ben int girmiş olsaydım yani privitive data tipi girmiş olsyadım id nin
    * defaul değeri 0 olurdu .eğer ben herhangi bir sebepten id değerini vermeden bir öğrenci ol
    * oluşturursam öğrenciye 0 verir ama ben bu öğrencinin id sinin bilinmeyen olarkark kalmasını
    * istiyorum.yani null olarak kalsın isiyorum.eğer değer atamamışsam null olarak kalsın 0 verilmesin*/
    private Integer id;
private String name;
    private String lastname;
    private String city;
    private int age;

    //parametreli/paremetresis const

    public Student() {
    }

    public Student(String name, String lastname, String city, int age) {
        this.name = name;
        this.lastname = lastname;
        this.city = city;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    //henüz arayüzümüz olmadığı için konsol üzerinde çalıştığımız içinn .öğrenciyi doğrudan
    //consola yazdırmak isteyebilirz.objemin fieldlarını doğrudan consola yazdırmak istersem
    //Student objesini string e dönüştürebilmek için ToString methodunu kullanılırım

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                '}';
    }
}
