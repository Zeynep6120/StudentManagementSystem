import java.util.List;

//course,student,instructor için
//data tipinden bağımsız CRUD işlemlerini listeleyen bir interface
//o halde inteface imi generic hale getiricem yani bir data tipi ile değil de birden fazla data tipi ile çalışabilecek
//hale getiricem
public interface Repository<S,U> {

    void createTable();
     void save(S entity);
      List<S> findAll();
      /*
      burda listenin data tipi eğer benim objem Student is student instructor ise  instructor course ise course olucak
      Yani değişken olabilir*/

    void update(S entity);

    void deleteById(U id);
    /*ben id  nin data tipine sonradan karar vericem yani verilen parametrenin data tipi değişebilir.mesela student kink
    * integer ,course id si long ya da instructor ın id si short olabilir ben buna da sonradan karar vereceğim için
    * bunu da generic hale getirdım ve data tipine U dedim*/

      S findById(U id);
      /* U tipin de bir ıd alack ve geriye S tipinde tek bir tane  öğrenci ya da obje döndürmüş olacak */
}
