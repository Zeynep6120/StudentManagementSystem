import java.util.Scanner;

//uygulamayı başlatan ve (controller:istemci ile iletişime geçilecek)
//controller classları ile sadece service classları görüşür.
public class Runner {
    /*scannar objesini sadece bu method içerisinde değil bu class ta ve diğer classlarda aynı scanner objesini kulalnıcma
     * yani her seferinde tekrar tekrar scanner objesi oluşturmucam.hatta tüm uygulamada aynı scanner objesini kullannıcam*/
//kullanıcıdan alınan tüm bilgiler controller katmanında alınır.kullanıcıya verilicek olan tüm cevaplar controller
    //katmanında verilir
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        StudentService service= new StudentService();
        //7-c uygulama başladığında tablo oluşturulsun
        service.createStudentTable();
        int select = 0;
        int id;
        do {
            System.out.println("===================================================");
            System.out.println("Öğrenci Yönetim Paneli");
            System.out.println("1-Öğrenci Kaydetme");
            System.out.println("2-Tüm Öğrencileri Görüntüleme");
            System.out.println("3-Öğrenciyi Güncelleme");
            System.out.println("4-Öğrenciyi Silme");
            System.out.println("5-Tek Bir Öğrenciyi Görüntüleme");
            System.out.println("6-Tüm öğrencilerin AD-SOYAD bilgilerini rapora yazdırma");
            System.out.println("0-ÇIKIŞ");
            System.out.println("İşlem Seçiniz : ");
            select = input.nextInt();
            input.nextLine();

            switch (select) {
                case 1:
                    //bilgileri verilen öğrenciyi kaydetme
                    Student newStudent=service.getStudentInfo();
                    new Thread(()->{
                        service.saveStudent(newStudent);
                    }).start();
                    break;
                case 2:
                    //öğrencileri consola yazdırma
                    service.printAllStudent();
                    break;
                case 3:
                    id=getIdInfo();
                    //id si verilen öğrenciyi güncelleme
                    service.updateStudentById(id);
                    break;
                case 4:
                    id=getIdInfo();
                    //id si verilen öğrenciyi silme
                    service.deleteStudentById(id);
                    break;
                case 5:
                    id=getIdInfo();
                    //id si verilen öğrenciyi görüntüleme
                    service.printStudentById(id);
                    break;
                case 6:
                    new Thread(()->{
                        service.generateReport();
                    }).start();

                    break;
                case 0:
                    System.out.println("iyi Günler...");
                    break;
                default:
                    System.out.println("Hatalı Giriş!!!");
                    break;
            }

        } while (select != 0);
    }
    private static  int getIdInfo(){
        System.out.println("Öğrenci id: ");
        int id=input.nextInt();
        input.nextLine();
        return id;
    }
}
/*
* uydulamamız içerisinde birden fazla thread oluşturarak. threadlerimiz arasında görev dağılımı gerçekleştirerek aseckron uygulamalr geliştirdiğimizde
* işlemcimizi etkin bir şekilde kullanarak.bekleme aşamaların verimli hale dönüştürebiliriz.işlemcimiz herhangi bir işlem için beklme yaparken diğer bir
thread işlemine devam edebilir./
 */