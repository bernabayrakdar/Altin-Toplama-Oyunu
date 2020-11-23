
ALTIN TOPLAMA OYUNU


Projemizde bizden 20x20’lik bir kare tahta üzerinde farklı özelliklere sahip olan oyuncuların altın toplama yarışı yapması istenmiştir.
İlk olarak GUI2 classı oluşturulur. Bu class içerisinde tahta üzerinde oyuncular 4 köşeye yerleştirilir. Rastgele altın dağıtımı yapılırken bu köşelere altın gelmemesi sağlanır. 
Rastgele dağıtılan altınların altın değerleri belirlenir ve dağıtılan altınlardan tekrar rastgele gizli altın seçme işlemi yapılır. Tahtada gizli altınlar kırmızı olarak, diğer altınlar ise icon ile gösterilmiştir.Oyuncular için ayrı classlar oluşturulur. 
AOyuncu classında oyuncunun tahtada dağıtılan altınlardan en yakın altına ulaşması sağlanır. Boyuncu classında tahta üzerinde rastgele dağıtılan altınlardan altın uzaklığı ve altın miktarı dikkate alınarak en karlı altını seçmesi sağlanır. 
COyuncu classınında  Boyuncu classı ile aynı şekilde çalışması sağlanır ve C oyuncusunun oyuna başlamadan önce kendisine en yakın iki gizli altını açması sağlanmıştır. 
DOyuncu classında ise oyuncu maliyeti en yüksek altına ulaşmalı ancak hedef belirlerken diğer oyuncuların hedefine onlardan önce ulaşamıyorsa bu noktaları hedeflememesi sağlanmıştır. Main classı oluşturulur. Oyun bu classta oynanmaktadır.
Uygulama çalıştırıldığında ilk olarak A oyuncusunun hedef belirleyip kendisine en yakın altını bulduktan sonra buraya ulaşması ve bu noktaya giderken gizli altın varsa bu altını arayüzde görünür yapması sağlanır.
 Hedefine ulaşınca burada rastgele verilmiş olan altın değerini alarak başlangıçta sahip olduğu altın değerinden ulaştığı altın değeri ve ulaşırken kaydettiği mesafenin 2 katı kadar altın kaybederek maliyeti hesaplanır ve sıra B oyuncusuna geçer.
B oyuncusunun altın uzaklıkları ve altın değerlerini göz önüne alarak maliyeti en yüksek altını hedeflemesi sağlanır. 
Hedefine ulaşırken gideceği yolda gizli altınlar varsa bu altınları görünür yapar. Hedefine ulaştığında burada rastgele verilmiş olan altın değerini alarak başlangıçta sahip olduğu altın değerinden ulaştığı altın değeri ve ulaşırken kaydettiği
mesafenin 2 katı kadar altın kaybederek maliyeti hesaplanır ve sıra C oyuncusuna geçer.C oyuncusunun ilk olarak kendisine en yakın iki adet gizli altını arayüzde görünür yapması sağlanır. 
Daha sonra B oyuncusu gibi maliyeti en yüksek altını hedefler ve bu hedefine ulaştığında burada rastgele verilmiş olan altın değerini alarak başlangıçta sahip olduğu altın değerinden 
ulaştığı altın değeri ve ulaşırken kaydettiği mesafenin 2 katı kadar altın kaybederek maliyeti hesaplanır ve sıra D oyuncusuna geçer.
D oyuncusunun altın uzaklıkları ve altın değerlerini göz önüne alarak maliyeti en yüksek altını hedeflemesi sağlanır. 
Ancak oyuncu hedef listesini belirlenirken diğer oyuncuların bir sonraki hedefledikleri altınları bilmeli ve o oyunculardan önce altına ulaşabiliyorsa o altını hedefleyebilmesi,ulaşamıyorsa hedef listesine o altını eklememesi sağlanmıştır. 
Hedefine ulaşırken gideceği yolda gizli altınlar varsa bu altınları görünür yapar. 
Hedefine ulaştığında burada rastgele verilmiş olan altın değerini alarak başlangıçta sahip olduğu altın değerinden ulaştığı altın değeri ve ulaşırken kaydettiği 
mesafenin 2 katı kadar altın kaybederek maliyeti hesaplanır ve sıra tekrar A oyuncusuna geçer.
Oyun bu şeklide dinamik olarak oyuncuların altını bitene kadar veya tahta üzerindeki altınlar tamamen toplanana kadar oynanmaya devam eder.
 
Proje Java programlama dilinde eclipse ortamında gerçekleştirilmiştir. Zip dosyası indilir ve projenin olduğu klasör çıkartılır. Proje kullanılan ide ile file open project from file
system ile dosyası bulunarak eklenir ve çalıştırılır.




                                                                                                                                                                                                                                                                                    





